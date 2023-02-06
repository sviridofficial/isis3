package com.example.isis3.Services;

import com.example.isis3.Models.Todo;

import java.util.List;

public interface TodoService {
    public List<Todo> getAllTodos();

    public Todo addNewTodo(Todo todo);

    public Todo deleteTodo(long id);

    public Todo updateTodo(Todo todo);
}
