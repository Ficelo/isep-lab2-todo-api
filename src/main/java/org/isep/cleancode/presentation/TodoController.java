package org.isep.cleancode.presentation;

import com.google.gson.Gson;
import org.isep.cleancode.Todo;
import org.isep.cleancode.application.TodoManager;
import spark.Request;
import spark.Response;

import java.util.List;

public class TodoController {

    private static final Gson gson = new Gson();
    private final TodoManager todoManager;

    public TodoController(TodoManager todoManager) {
        this.todoManager = todoManager;
    }

    public Object getAllTodos(Request req, Response res) {
        res.type("application/json");
        List<Todo> todos = todoManager.getAllTodos();
        return gson.toJson(todos);
    }

    public Object createTodo(Request req, Response res) {

        Todo newTodo = gson.fromJson(req.body(), Todo.class);

        try {
            Todo createdTodo = todoManager.createTodo(newTodo);
            res.status(201);
            res.type("application/json");
            return gson.toJson(createdTodo);
        } catch (IllegalArgumentException e) {
            res.status(400);
            return e.getMessage();
        }

    }

}
