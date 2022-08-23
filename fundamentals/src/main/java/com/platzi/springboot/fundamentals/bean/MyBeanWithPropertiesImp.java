package com.platzi.springboot.fundamentals.bean;

public class MyBeanWithPropertiesImp implements MyBeanWithProperties {

    private String name;
    private String lastname;

    public MyBeanWithPropertiesImp(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    @Override
    public String function() {
        return name +" - " + lastname;
    }
}
