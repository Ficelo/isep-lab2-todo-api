package org.isep.cleancode.application;

import org.isep.cleancode.Todo;
import org.isep.cleancode.persistence.TodoRepository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TodoManager {

    public final ITodoRepository repository;
    private static final String DATE_FORMAT = "dd-MM-yyyy";

    public TodoManager(ITodoRepository repository) {
        this.repository = repository;
    }

    public List<Todo> getAllTodos() {
        return repository.getAllTodos();
    }

    public Todo createTodo(Todo todo) {
        if (todo.getName().isEmpty() || todo.getName().length() > 64) {
            throw new IllegalArgumentException("Todo name is required and must be under 64 characters");
        }

        // Business rule 2
        if(repository.existsByName(todo.getName())) {
            throw new IllegalArgumentException("Todo name already exists");
        }

        // Business rule 3
        Date parsedDate = null;
        if(todo.getDueDate() != null){
            try {
                SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
                sdf.setLenient(false);
                parsedDate = sdf.parse(todo.getDueDate());
            } catch (Exception e) {
                throw new IllegalArgumentException("Invalid date format");
            }
        }

        repository.addTodo(todo);
        return todo;
    }
}
