package com.mypost.todopost.service;

import com.mypost.todopost.dtos.SessionUser;
import com.mypost.todopost.dtos.todoDto.TodoCreateDto;
import com.mypost.todopost.dtos.todoDto.TodoResponseDto;
import com.mypost.todopost.entity.todoEntity.Todo;
import com.mypost.todopost.persistence.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;
    private final HttpSession httpSession;
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
    public List<TodoResponseDto> getAllByAuthor(String name){
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        List<TodoResponseDto> todoList =
                todoRepository.findByAuthor(user.getName(), Sort.by(Sort.Order.desc("id")))
                        .stream().map(todo-> new TodoResponseDto()).collect(Collectors.toList());
        return todoList;
    }

    @Transactional
    public Long todoDelete(Long id){
        todoRepository.deleteById(id);
        return id;
    }

}
