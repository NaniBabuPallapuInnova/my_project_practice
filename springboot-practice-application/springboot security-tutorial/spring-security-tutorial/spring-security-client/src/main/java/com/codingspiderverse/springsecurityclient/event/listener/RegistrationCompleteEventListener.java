package com.codingspiderverse.springsecurityclient.event.listener;

import com.codingspiderverse.springsecurityclient.entity.User;
import com.codingspiderverse.springsecurityclient.event.RegistrationCompleteEvent;
import com.codingspiderverse.springsecurityclient.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {

    private static final Logger log = LoggerFactory.getLogger(RegistrationCompleteEventListener.class);

    @Autowired
    private UserService userService;

    /**
     * Event listener for handling user registration completion event.
     * @param event RegistrationCompleteEvent.
     */

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {

        User user = event.getUser();

        // creating random verification token for the User.
        String token = UUID.randomUUID().toString();

        // Save verification token for the user
        userService.saveVerificationTokenForUser(token,user);

        // whatever token is created and attached to the link and when user clicks the link and redirect back to the application.

        // Building the verification URL
        String url = event.getApplicationUrl() + "/api/verifyRegistration?token="+token;

        // create a method here to sendVerificationMail to User


        // Log the verification URL (you might want to send an email with this URL)
        log.info("Click the link to verify your account : {}",url);
    }
}
