package com.mypost.todopost.service;

import com.mypost.todopost.dtos.todoDto.TodoCreateDto;
import com.mypost.todopost.entity.todoEntity.Todo;
import com.mypost.todopost.persistence.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    @Transactional
    public Long createTodo(TodoCreateDto todoCreateDto){
        return todoRepository.save(todoCreateDto.toTodoEntity(todoCreateDto)).getId();
    }
    @Transactional
    public Long updateTodo(Long id, String content){
        Todo todo = todoRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 할일 없음"));
        todo.setContent(content);
        return id;
    }

}
