package com.mypost.todopost.service;

import com.mypost.todopost.dtos.PostCreateDto;
import com.mypost.todopost.dtos.PostResponseDto;
import com.mypost.todopost.entity.Post;
import com.mypost.todopost.persistence.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;


    @Transactional
    public Long createPost(PostCreateDto postCreateDto){//게시글 저장 메서드
      return postRepository.save(postCreateDto.toPostEntity()).getId();
    }
    @Transactional
    public PostResponseDto postFindById(Long id){
        Post post = postRepository.findById(id).get();
        PostResponseDto responseDto = new PostResponseDto(post);
        return responseDto;
    }


}
