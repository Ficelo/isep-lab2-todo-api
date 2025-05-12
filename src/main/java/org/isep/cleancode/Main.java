package org.isep.cleancode;

import org.isep.cleancode.application.TodoManager;
import org.isep.cleancode.persistence.TodoRepository;
import org.isep.cleancode.presentation.TodoController;

import static spark.Spark.*;

public class Main {

    public static void main(String[] args) {
        port(4567);

        TodoRepository todoRepository = new TodoRepository();
        TodoManager todoManager = new TodoManager(todoRepository);
        TodoController todoController = new TodoController(todoManager);

        get("/todos", todoController::getAllTodos);

        post("/todos", todoController::createTodo);
    }
}

