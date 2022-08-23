package com.platzi.springboot.fundamentals.usecase;

import com.platzi.springboot.fundamentals.entity.User;
import com.platzi.springboot.fundamentals.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class CreateUser {

    private UserService userService;

    public CreateUser(UserService userService) {
        this.userService = userService;
    }

    public User save(User user) {
        return userService.save(user);
    }
}
