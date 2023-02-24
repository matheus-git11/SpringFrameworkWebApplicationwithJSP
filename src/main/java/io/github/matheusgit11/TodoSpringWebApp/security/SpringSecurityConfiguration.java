package io.github.matheusgit11.TodoSpringWebApp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.function.Function;

@Configuration
public class SpringSecurityConfiguration {
    //LDAP or Database or in memory
    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager(){
        UserDetails userDetails1 = createNewUser("matheus", "123");
        UserDetails userDetails2 = createNewUser("ranga", "456");
        return new InMemoryUserDetailsManager(userDetails1,userDetails2);
    }

    private UserDetails createNewUser(String username, String password) {
        //lambda function that accept string as input and return string as output
        Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);
        // we're using a builder of UserDetails class to using as constructor for InMemoryUserDetailsManager
        UserDetails userDetails = User
                .builder()
                .passwordEncoder(passwordEncoder) // calling the lambda function
                .username(username)
                .password(password)
                .roles("USER", "ADMIN")
                .build();
        return userDetails;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
