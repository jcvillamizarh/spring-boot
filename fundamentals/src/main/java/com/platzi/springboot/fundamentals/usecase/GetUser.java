package com.platzi.springboot.fundamentals.usecase;

import com.platzi.springboot.fundamentals.entity.User;

import java.util.List;

public interface GetUser {

    List<User> getAll();
}
