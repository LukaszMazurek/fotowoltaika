package com.example.fotowoltaika.event.listener;

import com.example.fotowoltaika.entity.User;
import com.example.fotowoltaika.event.RegistrationCompleteEvent;
import com.example.fotowoltaika.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;

import java.util.UUID;

@Slf4j
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {

    @Autowired
    private UserService userService;

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        // Create the verification token for the user Link
        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        userService.saveVerificationTokenForUser(token, user);
        // Send email to user
        String url = event.getApplicationUrl()
                + "verifyRegistration?token="
                 + token;
        // sendVerificationEmail()
        log.info("Click the link to verify to your account", url);
    }
}
