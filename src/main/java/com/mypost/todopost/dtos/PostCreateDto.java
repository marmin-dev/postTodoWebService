package com.mypost.todopost.dtos;

import com.mypost.todopost.entity.Post;
import lombok.*;

import javax.persistence.Column;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostCreateDto {
    @Column(nullable = false)
    String title;
    @Column(nullable = false)
    String author;
    @Column(nullable = false)
    String content;

    public Post toPostEntity(){
        return Post.builder().title(title)
                .author(author)
                .content(content)
                .build();
    }
}
