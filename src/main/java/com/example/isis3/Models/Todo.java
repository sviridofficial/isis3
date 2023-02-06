package com.example.isis3.Models;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "todos")
@Data
@Getter
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long todoId;

    @Column(name = "title")
    private String title;

    @Column(name = "todo_text")
    private String todoText;
}
