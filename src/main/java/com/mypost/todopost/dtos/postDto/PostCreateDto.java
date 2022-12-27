package com.mypost.todopost.dtos.postDto;

import com.mypost.todopost.entity.postEntity.Post;
import lombok.*;

import javax.persistence.Column;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostCreateDto {
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String author;
    @Column(nullable = false)
    private String content;

    public Post toPostEntity(){
        return Post.builder().title(title)
                .author(author)
                .content(content)
                .build();
    }
}
