package com.mypost.todopost.service;

import com.mypost.todopost.dtos.PostCreateDto;
import com.mypost.todopost.entity.Post;
import com.mypost.todopost.persistence.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;
    @Transactional
    public void createPost(PostCreateDto postCreateDto){//게시글 저장 메서드
       postRepository.save(postCreateDto.toPostEntity());
    }


}
