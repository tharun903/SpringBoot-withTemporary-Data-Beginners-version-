package com.example.todoapplication;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class TodoController {
    private final TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    @GetMapping("/todos")
    public ArrayList<Todo> getTodo(){
        return service.getTodo();
    }

    @PostMapping("/todos")
    public Todo addTodo(@RequestBody Todo Id){
        return service.addTodo(Id);
    }

    @GetMapping("/todos/{id}")
    public Todo getbyId(@PathVariable("id") int id){
        return service.getbyId(id);
    }

    @PutMapping("/todos/{id}")
    public Todo updateId(@PathVariable("id") int id,@RequestBody Todo todo){
        return service.updateId(id,todo);
    }

    @DeleteMapping("/todos/{id}")
    public void DeleteId(@PathVariable("id") int id){
        service.DeleteId(id);
    }



}
