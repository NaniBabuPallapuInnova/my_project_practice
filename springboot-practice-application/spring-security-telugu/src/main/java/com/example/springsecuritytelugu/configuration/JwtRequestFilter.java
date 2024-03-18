package com.example.springsecuritytelugu.configuration;

import com.example.springsecuritytelugu.service.JwtService;
import com.example.springsecuritytelugu.util.JwtUtil;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

  @Autowired
  private JwtUtil jwtUtil;

  @Autowired
  @Lazy
  private JwtService jwtService;


  /**
   * Filters each incoming request to extract JWT token and authenticate the user.
   *
   * @param request The HTTP servlet request
   * @param response The HTTP servlet response
   * @param filterChain The filter chain for the request
   * @throws ServletException If there's an error in the servlet
   * @throws IOException If there's an I/O error
   */
  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
    // Extracting JWT token from the Authorization header
    final String header = request.getHeader("Authorization");
    String jwtToken = null;
    String userName = null;

     if(header != null && header.startsWith("Bearer ")){
        jwtToken= header.substring(7);

       try{

         // Extracting username from the JWT token
         userName = jwtUtil.getUserNameFromToken(jwtToken);

       }catch (IllegalArgumentException illegalArgumentException){
         // Handling error when unable to get JWT token
         System.out.println("Unable to get JWT token");
       } catch (ExpiredJwtException expiredJwtException){
         // Handling error when JWT token is expired
         System.out.println("JWT token is expired");
       }
     } else {
       // Logging a message when JWT token is not present or doesn't start with "Bearer"
       System.out.println("JWT token does not start with bearer");
     }

    // Authenticating the user if username is extracted from JWT token and user is not already authenticated
    if(userName != null && SecurityContextHolder.getContext().getAuthentication() == null){
       UserDetails userDetails = jwtService.loadUserByUsername(userName);

      // Validating the JWT token against user details
      if(jwtUtil.validateToken(jwtToken, userDetails)){
        // Creating authentication token for the user
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =  new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        // Setting authentication token details
        usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        // Setting authentication token in security context holder
         SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
       }
     }
    // Proceeding to the next filter in the chain
     filterChain.doFilter(request, response);
  }
}


/**
 * CODE EXPLANATION
 * Certainly! Here's an explanation of why each parameter in the `doFilterInternal` method is used:
 *
 * 1. `request`: The HTTP servlet request represents the incoming HTTP request. It contains information about the request such as headers, parameters, and body content. In this method, we need the request to extract the Authorization header, which contains the JWT token.
 *
 * 2. `response`: The HTTP servlet response represents the response that will be sent back to the client. In this method, we may use the response to send error messages or to set response headers, although we don't do so directly in this particular implementation.
 *
 * 3. `filterChain`: The FilterChain is used to pass the request and response to the next filter in the chain. Filters are typically chained together to perform multiple operations on the request and response. In this method, after processing the request, we call `filterChain.doFilter(request, response)` to pass the request and response to the next filter in the chain.
 *
 * 4. `throws ServletException`: This method throws a ServletException if there's an error while processing the servlet. A ServletException is a general exception that indicates a servlet-related problem. In this method, we may throw a ServletException if there's an error during JWT token extraction or validation.
 *
 * 5. `throws IOException`: This method throws an IOException if there's an I/O error while processing the request or response. An IOException typically occurs when there's a problem with reading from or writing to the network, file system, or other I/O streams. In this method, we may throw an IOException if there's an error while reading the request or writing the response.
 *
 * In summary, these parameters are essential for processing incoming HTTP requests, handling responses, and passing requests along the filter chain. They allow the method to interact with the servlet environment and perform authentication based on the JWT token extracted from the request.
 */


/**
 * EXPLANATION: doFilterInternal() method
 *
 * Purpose: This method is used to intercept each incoming HTTP request and perform authentication based on the JWT token present in the Authorization header. It extracts the JWT token, validates it, and authenticates the user if the token is valid.
 *
 * Usage: This method is typically used in a servlet filter to enforce security measures such as authentication and authorization for incoming requests. It's used in web applications to ensure that only authenticated users can access protected resources.
 *
 * Functionality:
 *
 * It extracts the JWT token from the Authorization header of the HTTP request.
 * If the token is present and valid, it extracts the username from the token.
 * It loads user details based on the extracted username.
 * It validates the JWT token against the user details.
 * If the token is valid, it creates an authentication token for the user and sets it in the security context holder.
 * Finally, it proceeds to the next filter in the chain to continue processing the request.
 *
 * Overall, this method plays a crucial role in securing web applications by authenticating users based on JWT tokens, ensuring that only authorized users can access protected resources
 *
 */
