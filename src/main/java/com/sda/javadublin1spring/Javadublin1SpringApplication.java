package com.sda.javadublin1spring;

import com.sda.javadublin1spring.user.FileBasedUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Javadublin1SpringApplication {

    @Autowired
    private HelloBean helloBean;

    @Autowired
    private FileBasedUserRepository fileBasedUserRepository;

    public static void main(String[] args) {

        SpringApplication.run(Javadublin1SpringApplication.class, args);
        System.out.println("blabla");
    }

    @PostConstruct
    public void run() {
        helloBean.hello();
    }
}
