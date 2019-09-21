package com.sda.javadublin1spring.user;


import com.sda.javadublin1spring.user.exceptions.UserNotFoundException;
import org.springframework.stereotype.Service;
import com.sda.javadublin1spring.user.exceptions.InvalidParameterException;
import com.sda.javadublin1spring.user.exceptions.UserNotFoundException;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public List<User> findByGender(String gender) {
        try {
            Gender enumGender = Gender.valueOf(gender);
            return userRepository.findByGender(enumGender);
        } catch (IllegalArgumentException e) {
            throw new InvalidParameterException("gender");
        }
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }
}