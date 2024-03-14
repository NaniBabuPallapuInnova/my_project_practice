package com.example.springsecuritytelugu.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
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

//
//  @Autowired
//  private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
//
//
//  private JwtRequestFilter jwtRequestFilter;
//
//  @Autowired
//  public void setJwtRequestFilter(JwtRequestFilter jwtRequestFilter) {
//    this.jwtRequestFilter = jwtRequestFilter;
//  }
//
//  @Autowired
//  private UserDetailsService jwtService;

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

  @Bean
  @Override
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {

    http.cors();
    http.csrf().disable()
//      .authorizeRequests().antMatchers("/**").permitAll()
      .authorizeRequests().antMatchers("/dummyData","/registerNewUser","/authenticate").permitAll()
        .antMatchers(HttpHeaders.ALLOW).permitAll()
        .anyRequest().authenticated()
        .and()
          .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
        .and()
          .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
      ;
    http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
  }

  @Bean
  public PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder(11);
  }

  public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
    authenticationManagerBuilder.userDetailsService(jwtService).passwordEncoder(passwordEncoder());
  }
}
