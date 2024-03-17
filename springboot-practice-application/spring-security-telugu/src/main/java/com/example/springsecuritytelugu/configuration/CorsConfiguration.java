package com.example.springsecuritytelugu.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * This class configures Cross-Origin Resource Sharing (CORS) settings for the application.
 * It allows specified HTTP methods, headers, origins, and credentials for CORS requests.
 */
@Configuration
public class CorsConfiguration {

  private static final String GET = "GET";
  private static final String POST = "POST";
  private static final String DELETE = "DELETE";
  private static final String PUT = "PUT";

  // Configuring CORS settings
  @Bean
  public WebMvcConfigurer webMvcConfigurer(){
    return new WebMvcConfigurer() {
      @Override
      public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
          .allowedMethods(GET, POST, PUT, DELETE)  // Allowing specific HTTP methods
          .allowedHeaders("*")  // Allowing all headers
          .allowedOriginPatterns("*")  // Allowing requests from any origin
          .allowCredentials(true);  // Allowing credentials to be included in CORS requests
      }
    };
  }
}
