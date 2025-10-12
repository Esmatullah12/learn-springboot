package com.library.library.springboot;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    public boolean AuthenticationService(String username, String password){
        boolean isUsernameValid = username.equalsIgnoreCase("esmat");
        boolean isPasswordValid = password.equalsIgnoreCase("password");

        return (isUsernameValid && isPasswordValid);
    }
}
