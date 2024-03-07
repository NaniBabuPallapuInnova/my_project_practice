package com.codingspiderverse.springsecurityclient.config;

import org.springframework.context.annotation.Bean;


import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

//This annotation is used to enable Spring Security in a Spring Boot application.
// It indicates that the class provides configuration for Spring Security.
@EnableWebSecurity
public class WebSecurityConfig {

    private static final String[] WHITE_LIST_URLS = {
            "/hello",
            "/register",
            "/verifyRegistration*",
            "/resendVerificationToken"
    };

    /**
     * The PasswordEncoder is used for encoding and verifying passwords securely.
     * BCryptPasswordEncoder is a widely used password encoder that uses the BCrypt hashing algorithm with configurable strength (in this case, 11).
     */
    @Bean
   public PasswordEncoder passwordEncoder(){
       return new BCryptPasswordEncoder(11);
   }

    /**
     * Configures Spring Security to allow unrestricted access to the specified white-listed URLs.
     * If you have specific URLs that should be accessible without authentication, they should be added to the WHITE_LIST_URLS variable.
     * Disables Cross-Origin Resource Sharing (CORS) and Cross-Site Request Forgery (CSRF) protection.
     *
     * @param httpSecurity The HttpSecurity object to configure security settings.
     * @return The configured SecurityFilterChain instance.
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .cors().and()              // Enable Cross-Origin Resource Sharing (CORS)
                .csrf().disable()           // Disable Cross-Site Request Forgery (CSRF) protection
                .authorizeHttpRequests()    // Configure authorization for HTTP requests
                .antMatchers(WHITE_LIST_URLS).permitAll();  // Permit all requests to specified white-listed URLs

        return httpSecurity.build();   // Build and return the SecurityFilterChain
    }



}
