package com.mypost.todopost.dtos.todoDto;

import com.mypost.todopost.entity.todoEntity.Todo;
import lombok.*;

import javax.persistence.Column;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TodoResponseDto {

    private Long id;

    private String author;

    @Column(nullable = false)
    private String content;

    public TodoResponseDto (Todo todo){
        this.id = todo.getId();
        this.author = todo.getAuthor();
        this.content = todo.getContent();
    }
}
