package com.example.isis3.Repositories;

import com.example.isis3.Models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoDAO extends JpaRepository<Todo, Long> {
}
