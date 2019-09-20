package com.sda.javadublin1spring.todo;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class InMemoryTodoRepository implements TodoRepository {

    private List<Todo> todoList;

    public InMemoryTodoRepository() {
        this.todoList = new ArrayList<>();
    }

    InMemoryTodoRepository(List<Todo> todos) {
        this.todoList = new ArrayList<>(todos);
    }

    @Override
    public List<Todo> findAll() {
        return new ArrayList<>(todoList);
    }

    @Override
    public Optional<Todo> findById(Long id) {
        return todoList.stream()
                .filter(todo -> id.equals(todo.getId()))
                .findFirst();
    }

    @Override
    public List<Todo> findByStatus(TodoStatus status) {
        return todoList.stream()
                .filter(todo -> status.equals(todo.getStatus()))
                .collect(Collectors.toList());
    }
}