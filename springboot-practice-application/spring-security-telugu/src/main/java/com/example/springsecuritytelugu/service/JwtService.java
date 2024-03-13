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

  public JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception {
    String userName = jwtRequest.getUserName();
    String userPassword = jwtRequest.getUserPassword();

    authenticate(userName, userPassword);
    final UserDetails userDetails = loadUserByUsername(userName);
    String generatedToken =  jwtUtil.generateToken(userDetails);

    User user = userRepository.findByUserName(userName);
    return new JwtResponse(user, generatedToken);
  }

  private void authenticate(String userName , String userPassword) throws Exception {
    try {
      authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, userPassword));
    } catch (DisabledException e) {
      throw new Exception("User is disabled");
    } catch (BadCredentialsException e){
      throw new Exception("Bad Credentials Exception");
    }
  }


  private Set<SimpleGrantedAuthority> getAuthorities(User user){
    Set<SimpleGrantedAuthority> authorities = new HashSet<>();
    user.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName())));

    return authorities;
  }
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
