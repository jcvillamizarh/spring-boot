package com.platzi.springboot.fundamentals.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

import java.time.LocalDate;

@ConstructorBinding
@ConfigurationProperties(prefix = "user")
@Data
@AllArgsConstructor
public class User {

    private String email;
    private String password;
    private int age;
}
