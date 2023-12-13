package com.codingspiderverse.springsecurityclient.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // it provides getters and setters
@NoArgsConstructor // it provides constructor without arguments
@AllArgsConstructor // it provides constructor with Arguments
public class UserDTO {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String matchingPassword;


}
