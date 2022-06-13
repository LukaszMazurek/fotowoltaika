package com.example.fotowoltaika;

import com.example.fotowoltaika.domain.InstalationJPARepository;
import com.example.fotowoltaika.domain.MeasurementJPARepository;
import com.example.fotowoltaika.domain.User;
import com.example.fotowoltaika.domain.UserJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import net.aksingh.owmjapis.core.OWM;
import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.model.CurrentWeather;

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

    public MeasurementCycle() throws APIException {
    }

    @Scheduled(fixedRate = 5000)
    public void test()
    {
        Iterable<User> users = userRepository.findAll();
       /* for (User user:users)
        {
            if (user.getSettings().getAutoCalculated() == Boolean.TRUE)
            {
                for(Instalation instalation: user.getInstalationList()){
                    Measurement m = new Measurement();
                    m.setDate(cwd.getDateTime());
                    m.setInstalation(instalation);
                    m.setScore(2.5*(cwd.getMainData().getTempMax()-273));
                    System.out.println(m.getScore());
                    measurementJPARepository.save(m);
                }
            }
        }*/
        System.out.println("City: " + cwd.getMainData());
    }
}
