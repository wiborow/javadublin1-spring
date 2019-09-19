package com.sda.javadublin1spring.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Primary
@Repository
public class InMemoryUserRepository implements UserRepository {

    private List<User> users;

    public InMemoryUserRepository() {

        this.users = new ArrayList<>();
    }

    InMemoryUserRepository(List<User> users) {
        this.users = users;
    }

    @Override
    public Optional<User> findById(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException();
        }

        return users.stream()
                .filter(user -> id.equals(user.getId()))
                .findFirst();
    }
    @Override
    public List<User> findAll() {

        return new ArrayList<>(users);
    }

    @PostConstruct
    public void init() {
        if (this.users.size() == 0) {
            this.users.add(new User(1L, "Szymon", "Nowak", Gender.MALE));
            this.users.add(new User(2L, "Jan", "Kowalski", Gender.MALE));
            this.users.add(new User(3L, "Anna", "Wisniewska", Gender.FEMALE));
            this.users.add(new User(4L, "Karolina", "Nowak", Gender.FEMALE));
        }
    }
}
