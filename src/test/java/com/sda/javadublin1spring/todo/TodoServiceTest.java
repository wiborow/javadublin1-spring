package com.sda.javadublin1spring.todo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class TodoServiceTest {
    private TodoService todoService;

    @Before
    public void init() {
        this.todoService = new TodoService(new InMemoryTodoRepository(Arrays.asList(
                new Todo(1L,"wyjsc z psem", "Lorem ipsum", TodoStatus.DONE),
                new Todo(2L,"wyniesc smieci", "Lorem ipsum", TodoStatus.DONE),
                new Todo(3L, "ugotowac obiad", "Lorem ipsum", TodoStatus.NEW),
                new Todo(4L, "napisac cv", "Lorem ipsum", TodoStatus.IN_PROGRESS)
        )));
    }

    @Test(expected = IllegalArgumentException.class)
    public void findById_ShouldThrowIllegalArgumentExceptionWhenPassingNull() {
        // given
        Long id = null;

        // when
        todoService.findById(id);

        // then
        // exception is thrown
    }

    @Test(expected = IllegalArgumentException.class)
    public void findById_ShouldThrowIllegalArgumentExceptionWhenPassingNonPositiveValue() {
        // given
        Long id = -5L;

        //when
        todoService.findById(id);
    }

    @Test(expected = TodoNotFoundException.class)
    public void findById_ShouldThrowTodoNotFoundExceptionWhenPassingNonExistingId() {
        // given
        Long id = 10L;

        // when
        todoService.findById(id);
    }

    @Test
    public void findById_ShouldReturnExpectedTodoForExistingId() {
        // given
        Long id = 3L;
        Todo expectedTodo = new Todo(3L, "ugotowac obiad", "Lorem ipsum", TodoStatus.NEW);

        // when
        Todo actual = todoService.findById(id);

        // then
        Assert.assertEquals(expectedTodo, actual);
    }

    @Test
    public void findByStatus_ShouldReturnListOfTodoForGivenStatus() {
        // given
        TodoStatus todoStatus = TodoStatus.NEW;
        Todo expected = new Todo(3L, "ugotowac obiad", "Lorem ipsum", TodoStatus.NEW);

        // when
        List<Todo> actual = todoService.findByStatus(todoStatus);

        // then
        Assert.assertEquals("List should have exactly one todo", 1, actual.size());
        Assert.assertEquals("Todo should be equal the expected one", expected, actual.get(0));
    }
}