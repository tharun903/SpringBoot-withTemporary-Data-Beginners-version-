package com.example.todoapplication;

import java.util.ArrayList;

public interface TodoRepository {
    ArrayList<Todo> getTodo();

    Todo addTodo(Todo id);

    Todo getbyId(int id);

    Todo updateId(int id, Todo todo);

    void DeleteId(int id);
}
