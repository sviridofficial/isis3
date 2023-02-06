package com.example.isis3.Controllers;

import com.example.isis3.Models.Todo;
import com.example.isis3.Services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {
    private TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public ResponseEntity getAllTodos() {
        List<Todo> result = todoService.getAllTodos();
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity addTodo(@RequestBody Todo todo) {
        Todo createdTodo = todoService.addNewTodo(todo);
        return new ResponseEntity(createdTodo, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteTodo/{id}")
    public ResponseEntity deleteTodo(@PathVariable long id) {
        Todo deletedTodo = todoService.deleteTodo(id);
        return new ResponseEntity(deletedTodo, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity updateTodo(@RequestBody Todo todo) {
        Todo updatedTodo = todoService.updateTodo(todo);
        return new ResponseEntity(updatedTodo, HttpStatus.OK);
    }
}
