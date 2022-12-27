package com.mypost.todopost.controller;

import com.mypost.todopost.dtos.todoDto.TodoCreateDto;
import com.mypost.todopost.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class TodoApiController {
    private final TodoService todoService;

    @PostMapping("/api/v1/todo-post")
    public ResponseEntity<Long> createTodo(@RequestBody TodoCreateDto dto){
        return ResponseEntity.status(HttpStatus.OK).body(todoService.createTodo(dto));
    }
    @PutMapping("/api/v1/todo-update{id}")
    public ResponseEntity<Long> updateTodo(@PathVariable(name = "id") Long id, @RequestParam String content){
        return ResponseEntity.status(HttpStatus.OK).body(todoService.updateTodo(id,content));
    }
}
