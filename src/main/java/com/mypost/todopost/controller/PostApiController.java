package com.mypost.todopost.controller;

import com.mypost.todopost.dtos.postDto.PostCreateDto;
import com.mypost.todopost.dtos.postDto.PostUpdateRequestDto;
import com.mypost.todopost.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PostApiController {

    private final PostService postService;

    @PostMapping("/api/v1/post")
    public ResponseEntity<Long> postSave(@RequestBody PostCreateDto dto){ //save method
        return ResponseEntity.status(HttpStatus.OK).body(postService.createPost(dto));
    }

    @GetMapping("/api/v1/post/{id}")
    public ResponseEntity<String> postGetById(@RequestParam Long id) { //update.mustache
        return ResponseEntity.status(HttpStatus.OK).body(postService.postFindById(id).toString());
    }

    @PutMapping("/api/v1/post/{id}")
    public ResponseEntity<Long> postUpdate(@PathVariable Long id, @RequestBody PostUpdateRequestDto dto){
        return ResponseEntity.status(HttpStatus.OK).body(postService.updatePost(id,dto));
    }

    @DeleteMapping("/api/v1/post/{id}")
    public ResponseEntity<Long> postDelete(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(postService.deletePost(id));
    }

}
