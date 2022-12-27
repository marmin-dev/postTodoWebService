package com.mypost.todopost.persistence;

import com.mypost.todopost.entity.todoEntity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo,Long> {

}
