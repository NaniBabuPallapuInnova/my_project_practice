package com.example.springsecuritytelugu.configuration;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * This class handles unauthorized access to secured resources and sends an unauthorized error response.
 */
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
  // Handling unauthorized access
  @Override
  public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
    // Send unauthorized error response
    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized" );

  }
}
