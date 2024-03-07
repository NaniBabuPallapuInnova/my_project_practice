package com.example.springsecuritytelugu.config;

import com.example.springsecuritytelugu.authentication.CustomAuthenticationProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Collections;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public AuthenticationManager authenticationManagerBean(CustomAuthenticationProvider authenticationProvider) throws Exception {
    return new ProviderManager(Collections.singletonList(authenticationProvider));
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder(11);
  }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
      .cors() // Enable CORS
      .and()
      .csrf().disable()
      .authorizeRequests()
      .antMatchers("/api/login", "/api/logout").permitAll()
//      .antMatchers("/api/**").permitAll()
//      .antMatchers("/save/employee").permitAll() // Adjust URL based on your requirement
      .anyRequest().authenticated()
      .and()
      .formLogin()
      .loginPage("/api/login")
      .permitAll()
      .and()
      .logout()
      .invalidateHttpSession(true)
      .clearAuthentication(true)
      .permitAll();

    return http.build();
  }

  @Bean
  public CorsFilter corsFilter() {
    CorsConfiguration corsConfig = new CorsConfiguration();
    corsConfig.addAllowedOrigin("http://localhost:4200"); // Replace with the actual URL of your Angular app
    corsConfig.addAllowedMethod("*"); // Allow all HTTP methods
    corsConfig.addAllowedHeader("*"); // Allow all headers
    corsConfig.addAllowedMethod("OPTIONS");
    corsConfig.addAllowedMethod("GET");
    corsConfig.addAllowedMethod("POST");
    corsConfig.addAllowedMethod("PUT");
    corsConfig.addAllowedMethod("DELETE");
    corsConfig.setAllowCredentials(true); // Allow credentials (e.g., cookies)

    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", corsConfig);

    return new CorsFilter(source);
  }
}

