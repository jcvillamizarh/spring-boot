package com.platzi.springboot.fundamentals.usecase;

import com.platzi.springboot.fundamentals.entity.User;
import com.platzi.springboot.fundamentals.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class UpdateUser {

    private UserService userService;

    public UpdateUser(UserService userService) {
        this.userService = userService;
    }

    public User update(User user, Long id) {
        return userService.update(user, id);
    }
}
