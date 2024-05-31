package com.example.springsecuritytelugu.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

  private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
  private final JwtRequestFilter jwtRequestFilter;
  private final UserDetailsService jwtService;

  @Autowired
  public WebSecurityConfiguration(
    JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint,
    JwtRequestFilter jwtRequestFilter,
    UserDetailsService jwtService
  ) {
    this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
    this.jwtRequestFilter = jwtRequestFilter;
    this.jwtService = jwtService;
  }

  /**
   * Bean definition for AuthenticationManager.
   *
   * @return The authentication manager bean
   * @throws Exception If an error occurs while creating the bean
   */
  @Bean
  @Override
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }

  /**
   * Configures security settings for HTTP requests.
   *
   * @param http The HttpSecurity object to configure
   * @throws Exception If an error occurs while configuring security
   */
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    // Enable Cross-Origin Resource Sharing (CORS)
    http.cors();
    // Disable Cross-Site Request Forgery (CSRF) protection
    http.csrf().disable()
      // Allow access to certain endpoints without authentication
      .authorizeRequests().antMatchers("/dummyData","/registerNewUser","/actuator/**","/api/**","/authenticate").permitAll()
//      .authorizeRequests().antMatchers("/dummyData","/registerNewUser","/authenticate").permitAll()
      // Allow all methods specified in HttpHeaders
      .antMatchers(HttpHeaders.ALLOW).permitAll()
      // Authenticate all other requests
      .anyRequest().authenticated()
      // Handle authentication errors with custom entry point
      .and().exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
      // Set session creation policy to STATELESS (no sessions)
      .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    // Add JWT request filter before UsernamePasswordAuthenticationFilter
    http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
  }

  /**
   * Bean definition for PasswordEncoder.
   *
   * @return The password encoder bean
   */
  @Bean
  public PasswordEncoder passwordEncoder(){
    // Use BCryptPasswordEncoder with strength of 11
    return new BCryptPasswordEncoder(11);
  }

  /**
   * Configures global authentication manager.
   *
   * @param authenticationManagerBuilder The AuthenticationManagerBuilder to configure
   * @throws Exception If an error occurs while configuring authentication manager
   */
  public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
    // Configure user details service and password encoder
    authenticationManagerBuilder.userDetailsService(jwtService).passwordEncoder(passwordEncoder());
  }
}


/**
 * Explanation:
 *
 * Purpose: This class is a configuration class responsible for configuring Spring Security settings for web applications. It extends WebSecurityConfigurerAdapter to customize security settings.
 *
 * Usage: The class is used to define authentication and authorization rules for HTTP requests, configure authentication manager, password encoder, and specify exception handling for authentication errors.
 *
 * @EnableWebSecurity: Annotation indicating that Spring Security features are enabled.
 *
 * @EnableGlobalMethodSecurity(prePostEnabled = true): Annotation enabling global method security with pre- and post-authorization checks.
 *
 * authenticationManagerBean(): Bean definition method for providing an authentication manager bean. Used for authentication purposes.
 *
 * configure(HttpSecurity http): Method to configure security settings for HTTP requests. It defines rules for endpoint access, CSRF protection, exception handling, session management, and adds custom filters.
 *
 * passwordEncoder(): Bean definition method for providing a password encoder bean. Used to encode passwords securely.
 *
 * configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder): Method to configure global authentication manager. It configures the user details service and password encoder for authentication.
 *
 * Overall, this class and its methods are used to configure Spring Security settings, define authentication rules, handle authentication errors, and provide security features for web applications.
 */
