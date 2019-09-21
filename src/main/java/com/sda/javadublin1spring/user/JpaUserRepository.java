package com.sda.javadublin1spring.user;

import net.bytebuddy.agent.builder.AgentBuilder;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JpaUserRepository extends CrudRepository<User, Long> {
    List<User> findByGender(Gender gender);
}
