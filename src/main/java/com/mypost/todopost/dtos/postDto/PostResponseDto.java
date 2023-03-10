package com.mypost.todopost.dtos.postDto;

import com.mypost.todopost.entity.postEntity.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;


@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PostResponseDto {
    private Long id;

    private String title;

    private String author;

    private String content;

    private LocalDateTime modifiedAt;
    public PostResponseDto (Post post){
        this.id = post.getId();
        this.title = post.getTitle();
        this.author = post.getAuthor();
        this.content = post.getContent();
        this.modifiedAt = post.getModifiedAt();
    }
}
