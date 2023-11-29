package com.mysecurity.springboot_security.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends SecurityConfigurerAdapter {

    @Bean
    protected UserDetailsService userDetailsService(){

        List<UserDetails> userDetailsList = new ArrayList<>();
        userDetailsList.add(User.withDefaultPasswordEncoder().username("NPallapu").password("Hyderabad@369").roles("USER").build());

        return new InMemoryUserDetailsManager(userDetailsList);
    }
}

