package com.mypost.todopost.entity.postEntity;

import com.mypost.todopost.dtos.postDto.PostUpdateRequestDto;
import com.mypost.todopost.entity.BaseEntity;
import lombok.*;

import javax.persistence.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table(name = "post")
public class Post extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false)
    String title;
    @Column(nullable = false)
    String author;
    @Column(nullable = false)
    String content;

    public void update(PostUpdateRequestDto dto){
        this.title = dto.getTitle();
        this.content = dto.getContent();
    }

}
