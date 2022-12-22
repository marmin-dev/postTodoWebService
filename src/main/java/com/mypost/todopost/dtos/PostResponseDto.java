package com.mypost.todopost.dtos;

import com.mypost.todopost.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PostResponseDto {
    private Long id;

    private String title;

    private String author;

    private String content;

    public PostResponseDto (Post post){
        this.id = post.getId();
        this.title = post.getTitle();
        this.author = post.getAuthor();
        this.content = post.getContent();

    }
}
