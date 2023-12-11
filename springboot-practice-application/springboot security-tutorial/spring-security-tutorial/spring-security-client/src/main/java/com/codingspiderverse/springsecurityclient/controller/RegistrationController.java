package com.codingspiderverse.springsecurityclient.controller;

import com.codingspiderverse.springsecurityclient.dto.UserDTO;
import com.codingspiderverse.springsecurityclient.entity.User;
import com.codingspiderverse.springsecurityclient.entity.VerificationToken;
import com.codingspiderverse.springsecurityclient.event.RegistrationCompleteEvent;
import com.codingspiderverse.springsecurityclient.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RegistrationController {

    private static final Logger log = LoggerFactory.getLogger(RegistrationController.class);

    @Autowired
    private UserService userService;

    // we are creating an event and that particular event will handle to create particular email and send email to the user.

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;


    /**
     * Sample endpoint to test if the application is running.
     * @return Welcome message.
     */

    @GetMapping("/hello")
    public String getMessage(){
        return "Welcome to my company";
    }

    /**
     * Register a new user.
     * @param userDTO UserDTO object containing user details.
     * @param httpServletRequest HttpServletRequest to get application URL.
     * @return ResponseEntity containing UserDTO details and HTTP status.
     */

    @PostMapping("/register")
    public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO userDTO, final HttpServletRequest httpServletRequest){
        User user = userService.registeringUser(userDTO);
        log.info("user has been created successfully {} : ", userDTO);

        applicationEventPublisher.publishEvent(new RegistrationCompleteEvent(
                user,
                applicationUrl(httpServletRequest)
        ));
        return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
    }

    private String applicationUrl(HttpServletRequest httpServletRequest) {
        return "http://"+httpServletRequest.getServerName()+":"+httpServletRequest.getServerPort()+httpServletRequest.getContextPath();
    }

    /**
     * Validate user registration using the provided token.
     * @param token Token for user verification.
     * @return String indicating the validation result.
     */

    @GetMapping("/verifyRegistration")
    public String validateVerifyUserRegistration(@RequestParam(name = "token") String token){
        String checkValidOrNot = userService.validateVerifyUser(token);
        if(checkValidOrNot.equals("valid")){
            return "User is verified successfully";
        }

        return "Invalid User";
    }

    /**
     * Controller method for resending the verification token.
     * Retrieves the old verification token, generates a new token, and sends a verification email.
     *
     * @param oldToken             The old verification token.
     * @param httpServletRequest   The HTTP servlet request.
     * @return                     A confirmation message indicating that the verification link has been resent.
     */
    @GetMapping("/resendVerificationToken")
    public String resendVerificationToken(@RequestParam(name = "token") String oldToken, HttpServletRequest httpServletRequest) {
        // Generate a new verification token using the provided old token.
        VerificationToken verificationToken = userService.generateNewVerificationToken(oldToken);

        // Retrieve the user associated with the verification token.
        User user = verificationToken.getUser();

        // Resend the verification email to the user with the new token.
        resendVerificationMail(user, applicationUrl(httpServletRequest), verificationToken.getToken());

        // Return a confirmation message.
        return "Verification link has been resent";
    }


    // Private method to resend the verification email to the user.
    private void resendVerificationMail(User user, String applicationUrl, String newToken) {
        // Build the verification URL using the application URL and the new token.
        String url = applicationUrl + "/api/verifyRegistration?token=" + newToken;

        // TODO: Create a method to send a verification email to the user.

        // Log the verification URL (you might want to send an email with this URL).
        log.info("Click the link to verify your account: {}", url);
    }


    /**
     * Endpoint for initiating the password reset process.
     * Checks if the user with the provided email is verified.
     *
     * @param email The email address of the user for password reset.
     * @return ResponseEntity<String> indicating if the user is verified or not.
     */
    @PostMapping("/resetPassword")
    public ResponseEntity<String> resetPassword(@RequestParam("email") String email) {
        // Check if the user is present and verified
        boolean verifiedUser = userService.verifiedUserByEmail(email);
        if (verifiedUser) {
            return ResponseEntity.ok("Verified User");
        }
        return ResponseEntity.ok("User is not verified");
    }

    /**
     * Endpoint for saving the updated password during the password reset process.
     * Updates the password for the user with the provided email.
     *
     * @param email The email address of the user for whom the password is being reset.
     * @param password The new password.
     * @param matchingPassword The confirmation of the new password for validation.
     * @return ResponseEntity<String> indicating the success or failure of the password update.
     */
    @PostMapping("/saveResetPassword")
    public ResponseEntity<String> saveResetPassword(@RequestParam("email") String email,
                                                    @RequestParam("password") String password,
                                                    @RequestParam("matchingPassword") String matchingPassword) {
        // Update the password for the user
        boolean updated = userService.updatePasswordForUser(email, password, matchingPassword);
        if (!updated) {
            return ResponseEntity.ok("Unable to update password due to mismatching");
        }
        return ResponseEntity.ok("Password has been updated");
    }


    @PostMapping("/changePassword")
    public ResponseEntity<String> changePasswordForUser(@RequestParam("email") String email, @RequestParam("oldPassword") String oldPassword, @RequestParam("newPassword") String newPassword){

            if(!userService.checkOldPasswordMatchedOrNot(email, oldPassword ,newPassword)){
                log.info("Failed to change password for email : {}",email);
                return ResponseEntity.ok("Old password did not match");
            }
        log.info(" New Password has been updated successfully  for email : {}",email);
        return ResponseEntity.ok("Password has been changed");
    }


}
