package com.sda.javadublin1spring.user;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.Optional;

public class InMemoryUserRepositoryTest {
    private InMemoryUserRepository inMemoryUserRepository;

    @Before
    public void init() {
        this.inMemoryUserRepository = new InMemoryUserRepository(Arrays.asList(
                new User(1L, "Szymon", "Nowak", Gender.MALE),
                new User(2L, "Jan", "Kowalski", Gender.MALE),
                new User(3L, "Anna", "Wisniewska", Gender.FEMALE),
                new User(4L, "Karolina", "Nowak", Gender.FEMALE)
        ));
    }

    @Test(expected = IllegalArgumentException.class)
    public void findById_ShouldThrowIllegalArgumentExceptionWhenPassingNull() {
        // given
        Long id = null;

        // when
        inMemoryUserRepository.findById(id);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findById_ShouldThrowIllegalArgumentExceptionWhenPassingNegativeValue() {
        // given
        Long id = -5L;

        // when
        inMemoryUserRepository.findById(id);
    }

    @Test
    public void findById_ShouldReturnEmptyOptionalForNonExistingId() {
        // given
        Long id = 5L;

        // when
        Optional<User> actual = inMemoryUserRepository.findById(id);

        // then
        Assert.assertFalse("Optional is not empty. User found", actual.isPresent());
    }

    @Test
    public void findById_ShouldReturnOptionalWithExpectedUserForGivenId() {
        // given
        Long id = 3L;
        User expectedUser = new User(3L, "Anna", "Wisniewska", Gender.FEMALE);

        // when
        Optional<User> actual = inMemoryUserRepository.findById(id);

        // then
        Assert.assertTrue("Optional is empty. User not found", actual.isPresent());
        Assert.assertEquals("Found user is not the correct one", expectedUser, actual.get());
    }
}
