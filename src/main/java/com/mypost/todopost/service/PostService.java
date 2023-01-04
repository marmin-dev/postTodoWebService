package com.mypost.todopost.service;

import com.mypost.todopost.dtos.SessionUser;
import com.mypost.todopost.dtos.postDto.PostCreateDto;
import com.mypost.todopost.dtos.postDto.PostResponseDto;
import com.mypost.todopost.dtos.postDto.PostUpdateRequestDto;
import com.mypost.todopost.entity.postEntity.Post;
import com.mypost.todopost.persistence.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    private final HttpSession httpSession;
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
    public List<PostResponseDto> findAllByDesc(){ //전체 조회메서드
      List<PostResponseDto> posts =
              postRepository.findAllByDesc().stream().
                      map(post -> new PostResponseDto(post)).collect(Collectors.toList());
      return posts;
    }

    @Transactional
    public List<PostResponseDto> findRecent(){//최근 글 조회메서드
        List<PostResponseDto> recentDto =
                postRepository.findByRecent().stream().map(post ->
                        new PostResponseDto(post)).collect(Collectors.toList());
        return recentDto;
    }

    @Transactional
    public List<PostResponseDto> findByAuthor(String author){ //내가 쓴 글 조회하기
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        List<PostResponseDto> dto =
                postRepository.findByAuthor(user.getName(),Sort.by(Sort.Order.desc("id")))
                        .stream().map(post->new PostResponseDto(post))
                        .collect(Collectors.toList());
        return dto;
    }


}
