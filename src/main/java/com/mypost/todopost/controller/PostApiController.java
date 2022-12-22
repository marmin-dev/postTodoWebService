package com.mypost.todopost.controller;

import com.mypost.todopost.dtos.PostCreateDto;
import com.mypost.todopost.dtos.PostResponseDto;
import com.mypost.todopost.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PostApiController {

    private final PostService postService;

    @PostMapping("/api/v1/post-post")
    public ResponseEntity<Long> postSave(@RequestBody PostCreateDto dto){
        return ResponseEntity.status(HttpStatus.OK).body(postService.createPost(dto));
    }
    @GetMapping("/api/v1/post-getById")
    public ResponseEntity<String> postGetById(@RequestParam Long id){
        return ResponseEntity.status(HttpStatus.OK).body(postService.postFindById(id).toString());
    }


}
