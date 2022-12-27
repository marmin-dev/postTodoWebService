package com.mypost.todopost.service;

import com.mypost.todopost.dtos.postDto.PostCreateDto;
import com.mypost.todopost.dtos.postDto.PostResponseDto;
import com.mypost.todopost.dtos.postDto.PostUpdateRequestDto;
import com.mypost.todopost.entity.postEntity.Post;
import com.mypost.todopost.persistence.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;


    @Transactional
    public Long createPost(PostCreateDto postCreateDto){//게시글 저장 메서드
      return postRepository.save(postCreateDto.toPostEntity()).getId();
    }

    @Transactional
    public PostResponseDto postFindById(Long id) {//글 조회하는 메서드
        Post post = postRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 글이 존재하지 않습니다"));
        PostResponseDto responseDto = new PostResponseDto(post);
        return responseDto;
    }

    @Transactional
    public List<Post> findByAuthor(String author) { //내가 쓴 글 조회하기
        List<Post> authorList = postRepository.findByAuthor(author, Sort.by(Sort.Order.desc("id")));
        return authorList;
    }

    @Transactional
    public Long updatePost(Long id,PostUpdateRequestDto dto){ //업데이트 메서드
        Post post = postRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 아이디없음"));
        post.update(dto);
        return id;
    }

    @Transactional
    public Long deletePost(Long id){//삭제하는 메서드
        postRepository.deleteById(id);
        return id;
    }

    @Transactional
    public List<Post> findAllByDesc(){ //전체 조회메서드
      List<Post> posts = postRepository.findAll(Sort.by(Sort.Order.desc("createdAt")));
      return posts;
    }


}
