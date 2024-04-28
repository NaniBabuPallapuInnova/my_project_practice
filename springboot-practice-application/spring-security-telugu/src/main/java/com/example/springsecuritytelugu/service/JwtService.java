package com.example.springsecuritytelugu.service;

import com.example.springsecuritytelugu.entity.JwtRequest;
import com.example.springsecuritytelugu.entity.JwtResponse;
import com.example.springsecuritytelugu.entity.User;
import com.example.springsecuritytelugu.repository.UserRepository;
import com.example.springsecuritytelugu.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Service class responsible for JWT operations and user authentication.
 */
@Service
@Lazy
public class JwtService implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private JwtUtil jwtUtil;

  @Autowired
  @Lazy
  private AuthenticationManager authenticationManager;

  /**
   * Generates a JWT token for the given JWT request.
   *
   * @param jwtRequest The JWT request containing user credentials
   * @return The JWT response containing the user details and generated token
   * @throws Exception If an error occurs during token generation or user authentication
   */
  public JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception {
    String userName = jwtRequest.getUserName();
    String userPassword = jwtRequest.getUserPassword();

    // Authenticate the user
    authenticate(userName, userPassword);

    // Load user details and generate token
    final UserDetails userDetails = loadUserByUsername(userName);
    String generatedToken =  jwtUtil.generateToken(userDetails);

    // Fetch user details from repository
    User user = userRepository.findByUserName(userName);
    return new JwtResponse(user, generatedToken);
  }

  /**
   * Authenticates a user with the provided username and password.
   *
   * @param userName The username of the user to authenticate
   * @param userPassword The password of the user to authenticate
   * @throws Exception If the user is disabled or invalid credentials are provided
   */
  private void authenticate(String userName , String userPassword) throws Exception {
    try {
      authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, userPassword));
    } catch (DisabledException e) {
      throw new Exception("User is disabled");
    } catch (BadCredentialsException e){
      throw new Exception("Bad Credentials Exception");
    }
  }

  /**
   * Retrieves authorities (roles) for a user.
   *
   * @param user The user for whom authorities need to be retrieved
   * @return A set of authorities (roles)
   */
  private Set<SimpleGrantedAuthority> getAuthorities(User user){
    Set<SimpleGrantedAuthority> authorities = new HashSet<>();
    user.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName())));

    return authorities;
  }

  /**
   * Loads user details by username.
   *
   * @param username The username of the user to load details for
   * @return UserDetails object containing user details
   * @throws UsernameNotFoundException If the username is not found
   */
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    User user = userRepository.findByUserName(username);
    if(user != null){
      return new org.springframework.security.core.userdetails.User(
        user.getUserName(),
        user.getUserPassword(),
        getAuthorities(user)
      );
    } else{
      throw new UsernameNotFoundException("Username is not valid");
    }
  }
}
