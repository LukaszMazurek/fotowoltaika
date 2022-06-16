package com.example.fotowoltaika.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;
import org.json.*;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Objects;

@RestController
public class SettingsController {
    @Autowired
    private UserJPARepository userJPARepository;
    @Autowired
    private SettingsJPARepository settingsJPARepository;

   // private final EmployeeModelAssembler assembler;

    interface isAutoCalculated
    {
        Boolean autoCalculated(String autocalculated);
    }
    @PostMapping("/users/{id}/settings")
    public String addSettings(@PathVariable Long id, @RequestBody String requestBody )
    {
        User user = userJPARepository.findById(id).get();
        JSONObject ja = new JSONObject(requestBody);
        System.out.println(ja.getString("autoCalculated"));
        Settings settings = new Settings();
        isAutoCalculated iAC = (String autocalculated) -> Objects.equals(autocalculated, "true");
        settings.setAutoCalculated(iAC.autoCalculated(ja.getString("autoCalculated")));
        settings.setUser(user);
        settingsJPARepository.save(settings);
        System.out.println(settings.getAutoCalculated());
        user.setSettings(settings);
        userJPARepository.save(user);
        System.out.println(user.getSettings().getId());

        return "redirect:/users/"+id.toString()+"/settings/";
    }
    @PutMapping("/users/{id}/settings")
    public String updateSettings(@PathVariable Long id, @RequestBody String requestBody)
    {
        User user = userJPARepository.findById(id).get();
        JSONObject ja = new JSONObject(requestBody);
        isAutoCalculated iAC = (String autocalculated) -> (Objects.equals(autocalculated, "true"));
        System.out.println(iAC.autoCalculated(ja.getString("autoCalculated"))+" ___autoCalc");
        user.getSettings().setAutoCalculated(iAC.autoCalculated(ja.getString("autoCalculated")));
        //user.getSettings().setUser(user);
        settingsJPARepository.save(user.getSettings());
        //System.out.println(settings.getAutoCalculated());
        //user.setSettings(settings);
        userJPARepository.save(user);
        System.out.println(user.getSettings().getId());

        return "redirect:/users/"+id.toString()+"/settings/";
    }

}
