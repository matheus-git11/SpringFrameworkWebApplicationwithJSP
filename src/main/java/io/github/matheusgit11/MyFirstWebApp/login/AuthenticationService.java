package io.github.matheusgit11.MyFirstWebApp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean authenticate(String username , String password){
       boolean isValidUserName = username.equalsIgnoreCase("matheus");
       boolean isValidPassword = password.equalsIgnoreCase("123456");

       return isValidUserName && isValidPassword;
    }
}
