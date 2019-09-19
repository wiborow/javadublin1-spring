package com.sda.javadublin1spring.user;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Scope(value = "prototype")
public class RepositoryHelper {

    @PostConstruct
    public void init() {
        System.out.println("Hello from RepositoryHelper");
    }
}