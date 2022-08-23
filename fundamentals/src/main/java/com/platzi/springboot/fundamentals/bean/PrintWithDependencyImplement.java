package com.platzi.springboot.fundamentals.bean;

public class PrintWithDependencyImplement implements BeanWithDependency{

    private Operation operation;

    public PrintWithDependencyImplement(Operation operation) {
        this.operation = operation;
    }

    @Override
    public void printWithDependency() {
        System.out.println("Implementation inyected: " + operation.sum(1));
        System.out.println("Hi from implementation with Dependency");
    }
}
