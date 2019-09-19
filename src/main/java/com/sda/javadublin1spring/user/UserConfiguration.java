package com.sda.javadublin1spring.user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("prod")
public class UserConfiguration {

    @Bean
    public UserRepository preInitializedInMemoryUserRepository() {
        return new InMemoryUserRepository(Arrays.asList(
                new User(1L, "Jan", "Kowalski", Gender.MALE)
        ));
    }
}
