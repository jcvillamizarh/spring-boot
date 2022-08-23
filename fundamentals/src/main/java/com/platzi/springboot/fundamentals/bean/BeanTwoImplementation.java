package com.platzi.springboot.fundamentals.bean;

public class BeanTwoImplementation implements MyBean {
    @Override
    public void print() {
        System.out.println("Hi from my implementation two");
    }
}
