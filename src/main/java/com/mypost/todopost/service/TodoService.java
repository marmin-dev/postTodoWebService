package com.mypost.todopost.service;

import com.mypost.todopost.dtos.todoDto.TodoCreateDto;
import com.mypost.todopost.dtos.todoDto.TodoResponseDto;
import com.mypost.todopost.entity.todoEntity.Todo;
import com.mypost.todopost.persistence.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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

    @Transactional
    public TodoResponseDto getById(Long id){
        Todo todo = todoRepository.findById(id).orElseThrow(()->
               new IllegalArgumentException("해당 게시글이 존재하지 않음"));
        TodoResponseDto dto = new TodoResponseDto(todo);
        return dto;
    }

    @Transactional(readOnly = true)
    public List<TodoResponseDto> getAllByDesc(){
        List<TodoResponseDto> todoList =
                todoRepository.findAll().stream().map(todo->new TodoResponseDto(todo)).collect(Collectors.toList());
        return todoList;
    }

    @Transactional
    public Long todoDelete(Long id){
        todoRepository.deleteById(id);
        return id;
    }

}
