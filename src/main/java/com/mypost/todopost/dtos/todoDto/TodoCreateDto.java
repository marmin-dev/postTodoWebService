package com.mypost.todopost.dtos.todoDto;

import com.mypost.todopost.entity.postEntity.Post;
import com.mypost.todopost.entity.todoEntity.Todo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TodoCreateDto {

    public boolean check;

    @Column(nullable = false)
    public String author;

    @Column(nullable = false)
    public String content;

    public Todo toTodoEntity(TodoCreateDto todoCreateDto){
        return Todo.builder()
                .done(todoCreateDto.isCheck())
                .author(todoCreateDto.getAuthor())
                .content(todoCreateDto.getContent())
                .build();
    }
}
