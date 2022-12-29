package com.mypost.todopost.dtos.todoDto;

import com.mypost.todopost.entity.todoEntity.Todo;
import com.mypost.todopost.persistence.TodoRepository;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TodoResponseDto {

    Long id;

    @Column(nullable = false)
    public String content;

    public TodoResponseDto (Todo todo){
        this.id = todo.getId();
        this.content = todo.getContent();
    }
}
