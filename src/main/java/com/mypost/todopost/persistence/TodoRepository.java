package com.mypost.todopost.persistence;

import com.mypost.todopost.entity.todoEntity.Todo;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo,Long> {
    List<Todo> findByAuthor(String author, Sort sort);
}