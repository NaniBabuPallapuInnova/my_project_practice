package com.codingspiderverse.springsecurityclient.event;

import com.codingspiderverse.springsecurityclient.entity.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;

@Getter
@Setter
public class RegistrationCompleteEvent extends ApplicationEvent {


    private User user;
    private String applicationUrl;

    /**
     * Constructor for RegistrationCompleteEvent.
     * @param user User entity for which registration is completed.
     * @param applicationUrl Application URL for creating verification link.
     */

    public RegistrationCompleteEvent(User user, String applicationUrl){
        super(user);
        this.user = user;
        this.applicationUrl = applicationUrl;
    }
}
