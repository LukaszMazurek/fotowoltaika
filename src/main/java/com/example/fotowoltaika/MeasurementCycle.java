package com.example.fotowoltaika;

import com.example.fotowoltaika.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import jdk.jfr.StackTrace;
import net.aksingh.owmjapis.core.OWM;
import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.model.CurrentWeather;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class MeasurementCycle {
    OWM omw = new OWM("ec71b0036772b66e85b5ebffe7cc8d3e");
    CurrentWeather cwd = omw.currentWeatherByCoords(51.14,22.34);

    @Autowired
    private UserJPARepository userRepository;
    @Autowired
    private InstalationJPARepository instalationJPARepository;
    @Autowired
    private MeasurementJPARepository measurementJPARepository;
    @Autowired
    private DailyMeasurementsJPARepository dailyMeasurementsJPARepository;
    public MeasurementCycle() throws APIException {
    }
    public interface CheckIfDateIsEqual
    {
        public boolean check(int Day, int Month, int Year);
    }
    public void updateDaily(Instalation instalation, Measurement measurement)
    {
        System.out.println("BEGIN");
        CheckIfDateIsEqual isEqual = (int Day, int Month, int Year) ->
                ((Day == measurement.getDate().getDay() ? true : false) &
                (Month == measurement.getDate().getMonth() ? true : false) &
                (Year == measurement.getDate().getYear() ? true : false));

        List<DailyMeasurement> dailyMeasurements = dailyMeasurementsJPARepository.findAll();
        System.out.println(dailyMeasurements);
        DailyMeasurement dailyMeasurement;
        if (!dailyMeasurements.isEmpty()) {
            dailyMeasurement = null;
            for (DailyMeasurement dm : dailyMeasurements) {

                if (isEqual.check(dm.getDate().getDay(), dm.getDate().getMonth(), dm.getDate().getYear())) {
                    if (dm.getInstalation().getId() == instalation.getId()) {
                        dailyMeasurement = dm;
                        break;
                    }
                }
            }
            if (dailyMeasurement == null) {
                dailyMeasurement = new DailyMeasurement();
                dailyMeasurement.setDailysum(measurement.getScore());
                dailyMeasurement.setDate(measurement.getDate());
                dailyMeasurement.setInstalation(instalation);
            }
            else {
                dailyMeasurement.setDailysum(dailyMeasurement.getDailysum() + measurement.getScore());
            }
        }
        else
        {
            //DailyMeasurement dailyMeasurement = null;
            dailyMeasurement = new DailyMeasurement();
            dailyMeasurement.setDailysum(measurement.getScore());
            dailyMeasurement.setDate(measurement.getDate());
            dailyMeasurement.setInstalation(instalation);
        }
        dailyMeasurementsJPARepository.save(dailyMeasurement);
    }
    @Scheduled(fixedRate = 300000)
    public void SingleMeasure()
    {
        System.out.print("BEGIN BEGIN");
        Iterable<User> users = userRepository.findAll();
        for (User user:users)
        {
            System.out.print("USERS FOUND");

            if (user.getSettings().getAutoCalculated() == Boolean.TRUE)
            {
                for(Instalation instalation: user.getInstalationList()){
                    CurrentWeather cwd = null;
                    try {
                        cwd = omw.currentWeatherByCoords(instalation.getLatitude(), instalation.getLongtitude());
                    } catch (APIException e) {
                        e.printStackTrace();
                    }
                    //TODO Czas pomiarów


                    Measurement m = new Measurement();
                    m.setDate(cwd.getDateTime());
                    m.setInstalation(instalation);
                    m.setScore((cwd.getMainData().getTempMax()-273)+(instalation.getAmountOfPanels()*instalation.getPowerOfPanel()));
                    measurementJPARepository.save(m);
                    updateDaily(instalation,m);
                }
            }
        }
        //System.out.println("City: " + cwd.getMainData());
    }
}
