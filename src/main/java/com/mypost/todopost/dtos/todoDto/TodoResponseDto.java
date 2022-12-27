package com.mypost.todopost.dtos.todoDto;

import com.mypost.todopost.entity.todoEntity.Todo;
import com.mypost.todopost.persistence.TodoRepository;
import lombok.*;

import javax.persistence.Column;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TodoResponseDto {
    public boolean check;

    @Column(nullable = false)
    public String content;

    public TodoResponseDto (Todo todo){
        this.check = todo.isDone();
        this.content = todo.getContent();
    }
}
