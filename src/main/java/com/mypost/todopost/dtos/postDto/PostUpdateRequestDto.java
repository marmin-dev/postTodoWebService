package com.mypost.todopost.dtos.postDto;

import lombok.*;

import javax.persistence.Column;

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
