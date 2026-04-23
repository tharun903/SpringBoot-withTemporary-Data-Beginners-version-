package com.example.todoapplication;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
@Service
public class TodoService implements TodoRepository {

    private static HashMap<Integer, Todo> todoList = new HashMap<>();
    int unique = 6;

    public TodoService() {
        todoList.put(1, new Todo(1, "Watch Movie", "LOW", "TO DO"));
        todoList.put(2, new Todo(2, "Finish Project", "HIGH", "IN PROGRESS"));
        todoList.put(3, new Todo(3, "Buy Groceries", "MEDIUM", "TO DO"));
        todoList.put(4, new Todo(4, "Learning from NxtWave", "HIGH", "IN PROGRESS"));
        todoList.put(5, new Todo(5, "Go for a Run", "MEDIUM", "DONE"));

    }

    @Override
    public ArrayList<Todo> getTodo() {
        Collection<Todo> todo = todoList.values();
        ArrayList<Todo> todoDetails = new ArrayList<>(todo);
        return todoDetails;
    }

    @Override
    public Todo addTodo(Todo id) {
        id.setId(unique);
        todoList.put(unique, id);
        return id;
    }

    @Override
    public Todo getbyId(int id) {
        Todo ids = todoList.get(id);
        if(ids == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return ids;
    }

    @Override
    public Todo updateId(int id, Todo todo) {
        Todo existing = todoList.get(id);
        if(existing == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        if(todo.getTodo() != null){
            existing.setTodo(todo.getTodo());
        }
        if(todo.getPriority() != null){
            existing.setPriority(todo.getPriority());
        }
        if(todo.getStatus() != null){
            existing.setStatus(todo.getStatus());
        }
        return existing;
    }

    @Override
    public void DeleteId(int id) {
        Todo existing = todoList.get(id);
        if(existing == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        todoList.remove(id);
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }
}
