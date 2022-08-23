package com.platzi.springboot.fundamentals.bean;

public class OperationImplement implements Operation {
    @Override
    public int sum(int number) {
        return number + 1;
    }
}
