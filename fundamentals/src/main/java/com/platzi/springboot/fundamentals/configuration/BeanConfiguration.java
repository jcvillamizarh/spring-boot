package com.platzi.springboot.fundamentals.configuration;

import com.platzi.springboot.fundamentals.bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public MyBean beanOperation() {
        return new BeanTwoImplementation();
    }

    @Bean
    public Operation beanSumOperation() {
        return new OperationImplement();
    }

    @Bean
    public BeanWithDependency beanWithDependency(Operation operation) {
        return new PrintWithDependencyImplement(operation);
    }
}
