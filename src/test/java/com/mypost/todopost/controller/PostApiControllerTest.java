package com.mypost.todopost.controller;

import com.mypost.todopost.dtos.PostCreateDto;
import com.mypost.todopost.entity.Post;
import com.mypost.todopost.service.PostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;


import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willReturn;

@WebMvcTest(PostApiController.class)
public class PostApiControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    PostService postService;

    @Test
    void post_저장된다() throws Exception{


    }

}
