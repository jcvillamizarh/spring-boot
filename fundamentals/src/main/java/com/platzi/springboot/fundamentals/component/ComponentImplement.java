package com.platzi.springboot.fundamentals.component;

import org.springframework.stereotype.Component;

@Component
public class ComponentImplement implements ComponentDependency {

    @Override
    public void greeting() {
        System.out.println("Hello Platzi");
    }
}
