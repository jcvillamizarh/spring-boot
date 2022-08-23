package com.platzi.springboot.fundamentals.component;

import org.springframework.stereotype.Component;

@Component
public class ComponentTwoImplement implements ComponentDependency {

    @Override
    public void greeting() {
        System.out.println("Second implementation from component two");
    }
}
