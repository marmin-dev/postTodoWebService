package com.mypost.todopost.controller;

import com.mypost.todopost.dtos.PostCreateDto;
import com.mypost.todopost.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostApiController {

    @Autowired
    PostService postService;

    @PostMapping("/api/v1/post-post")
    public ResponseEntity<String> postSave(@RequestBody PostCreateDto dto){
        postService.createPost(dto);
        return ResponseEntity.status(HttpStatus.OK).body(dto.toString());
    }

}
