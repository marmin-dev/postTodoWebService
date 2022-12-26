package com.mypost.todopost.dtos;

import com.mypost.todopost.entity.Post;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Builder
public class PostUpdateRequestDto {
    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Builder
    public PostUpdateRequestDto(String title,String content){
        this.title = title;
        this.content = content;
    }




}
