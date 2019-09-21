package com.sda.javadublin1spring.user;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JpaUserRepository extends CrudRepository<User, Long> {
    List<User> findByGender(Gender gender);
}
