package com.platzi.springboot.fundamentals.configuration;

import com.platzi.springboot.fundamentals.service.UserService;
import com.platzi.springboot.fundamentals.usecase.GetUser;
import com.platzi.springboot.fundamentals.usecase.GetUserImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfiguration {

    @Bean
    GetUser getUser(UserService userService) {
        return new GetUserImpl(userService);
    }
}
