package com.example.isis3.Services;

import com.example.isis3.Errors.TodoNotFoundException;
import com.example.isis3.Models.Todo;
import com.example.isis3.Repositories.TodoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService {
    private TodoDAO todoRepo;

    @Autowired
    public TodoServiceImpl(TodoDAO todoDAO) {
        this.todoRepo = todoDAO;
    }

    @Override
    public List<Todo> getAllTodos() {
        return todoRepo.findAll();
    }

    @Override
    public Todo addNewTodo(Todo todo) {
        Todo newTodo = todoRepo.saveAndFlush(todo);
        return newTodo;
    }

    @Override
    public Todo deleteTodo(long id) {
        Optional<Todo> todo = todoRepo.findById(id);
        if (todo.isEmpty()) {
            throw new TodoNotFoundException("Todo with id " + id + " not found!");
        }
        todoRepo.delete(todo.get());
        return todo.get();
    }

    @Override
    public Todo updateTodo(Todo todo) {
        long todoId = todo.getTodoId();
        Optional<Todo> todoToUpdate = todoRepo.findById(todoId);
        if (todoToUpdate.isEmpty()) {
            throw new TodoNotFoundException("Todo with id " + todoId + " not found!");
        }
        todo = todoRepo.save(todo);
        return todo;
    }
}
