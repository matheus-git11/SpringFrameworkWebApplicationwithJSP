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

        //lambda function that accept string as input and return string as output
        Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);

        UserDetails userDetails = User // we're using a builder of UserDetails class to using as constructor for InMemoryUserDetailsManager
                .builder()
                .passwordEncoder(passwordEncoder) // calling the lambda function
                .username("matheus")
                .password("123")
                .roles("USER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(userDetails);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
