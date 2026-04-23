package com.example.todoapplication;

public class Todo {
    private Integer id;
    private String todo;
    private String priority;
    private String  status;

    public Todo(Integer id,String todo,String priority,String  status) {
        this.id = id;
        this.todo = todo;
        this.priority = priority;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
