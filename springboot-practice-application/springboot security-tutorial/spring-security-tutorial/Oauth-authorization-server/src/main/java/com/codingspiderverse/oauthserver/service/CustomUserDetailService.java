package com.codingspiderverse.oauthserver.service;

import com.codingspiderverse.oauthserver.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class CustomUserService implements UserDetailsService {

    private static final Logger log = LoggerFactory.getLogger(CustomUserService.class);

    @Autowired
    UserRepository userRepository;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(11);
    }

    /**
     * Retrieves user details by username (email) to authenticate and authorize the user.
     *
     * @param email The email address of the user to load details for.
     * @return UserDetails object representing the authenticated user.
     * @throws UsernameNotFoundException Thrown if the user is not found.
     */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Retrieve the user from the repository based on the provided email.
        com.codingspiderverse.oauthserver.entity.User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new NoSuchElementException("User not found! Email: " + email));

        // Build and return a UserDetails object for the authenticated user.
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                user.isEnabled(),
                true,
                true,
                true,
                getAuthorities(List.of(user.getRole()))
        );
    }

    /**
     * Converts a list of roles to a collection of GrantedAuthority objects.
     *
     * @param roles The list of roles assigned to the user.
     * @return Collection of GrantedAuthority objects representing the user's roles.
     */
    private Collection<? extends GrantedAuthority> getAuthorities(List<String> roles) {
        List<GrantedAuthority> authorities = new ArrayList<>();

        // Convert each role to a GrantedAuthority and add to the list of authorities.
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }

        return authorities;
    }



}
