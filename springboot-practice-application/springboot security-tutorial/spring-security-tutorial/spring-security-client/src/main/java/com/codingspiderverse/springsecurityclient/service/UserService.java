package com.codingspiderverse.springsecurityclient.service;

import com.codingspiderverse.springsecurityclient.dto.UserDTO;
import com.codingspiderverse.springsecurityclient.entity.User;
import com.codingspiderverse.springsecurityclient.entity.VerificationToken;
import com.codingspiderverse.springsecurityclient.mapping.UserMapper;
import com.codingspiderverse.springsecurityclient.repository.UserRepository;
import com.codingspiderverse.springsecurityclient.repository.VerificationTokenRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Consumer;

@Service
public class UserService{

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private VerificationTokenRepository verificationTokenRepository;

    /**
     * Registering a new user.
     * @param userDTO UserDTO object containing user details.
     * @return User entity after registration.
     */
    public User registeringUser(UserDTO userDTO) {
        User user = userMapper.toEntity(userDTO);
        user.setPassword(passwordEncoder.encode(user.getPassword())); // getting password from same user and encoding it.
        return userRepository.save(user);
    }

    /**
     * Save verification token for a user.
     * @param token Verification token.
     * @param user User entity.
     */
    public void saveVerificationTokenForUser(String token, User user) {
        VerificationToken verificationToken = new VerificationToken(user, token);

        verificationTokenRepository.save(verificationToken);
    }

    /**
     * Validate user registration using the provided token.
     * @param token Token for user verification.
     * @return String indicating the validation result.
     */
    public String validateVerifyUser(String token){
        VerificationToken verificationToken = verificationTokenRepository.findByToken(token);

        if(verificationToken == null){
            return "Invalid Token";
        }

        User user = verificationToken.getUser();

        Calendar calendar = Calendar.getInstance();

        // Check if the verification token has expired by comparing the current time with the expiration time.
        if (verificationToken.getExpirationTime().getTime() - calendar.getTime().getTime() <= 0) {
            // If the token has expired, delete the verification_token(object) details from DB.
            verificationTokenRepository.delete(verificationToken);

            // Return a message indicating that the token has expired.
            return "Token Expired";
        }


        user.setEnabled(true);
        userRepository.save(user);
        return "valid";
    }

    public VerificationToken generateNewVerificationToken(String oldToken){
        VerificationToken verificationToken = verificationTokenRepository.findByToken(oldToken);
        verificationToken.setToken(UUID.randomUUID().toString());
        verificationTokenRepository.save(verificationToken);
        return verificationToken;
    }

    public boolean verifiedUserByEmail(String email){
        Optional<User> user =  userRepository.findByEmail(email);

        return user.map(User::isEnabled).orElse(false);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new NoSuchElementException("User not found"));
    }

    public boolean updatePasswordForUser(String email, String password, String matchingPassword){
        User user = findByEmail(email);
        if (user != null && user.isEnabled() && (password.equals(matchingPassword))) {
            user.setPassword(passwordEncoder.encode(password));
            userRepository.save(user);
            return true;
        }
        return false;
    }


    public boolean checkOldPasswordMatchedOrNot(String email, String oldPassword, String newPassword) {

        Optional<User> user = userRepository.findByEmail(email);

        if(user.isPresent() && (passwordEncoder.matches(oldPassword, user.get().getPassword()))) {
                user.get().setPassword(passwordEncoder.encode(newPassword));
                userRepository.save(user.get());
                return true;
        }
        return false;
    }
}
