package com.platzi.springboot.fundamentals.bean;

public class BeanImplement implements MyBean {

    @Override
    public void print() {
        System.out.println("Hi from my bean implementation");
    }
}
