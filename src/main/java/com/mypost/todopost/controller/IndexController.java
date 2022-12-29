package com.mypost.todopost.controller;

import com.mypost.todopost.dtos.postDto.PostResponseDto;
import com.mypost.todopost.service.PostService;
import com.mypost.todopost.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class IndexController {
    private final PostService postService;
    private final TodoService todoService;
    @GetMapping("/")
    public String index(Model model){//메인화면 반환
        model.addAttribute("todo",todoService.getAllByDesc());
        model.addAttribute("post",postService.findRecent());
        return "index";
    }
    @GetMapping("/post/all")
    public String allPosts(Model model){ //전체 포스트 조회 화면 반환
        model.addAttribute("post",postService.findAllByDesc());
        return "allposts";
    }
    @GetMapping("/post/find/{id}")
    public String postById(@PathVariable Long id, Model model){
        PostResponseDto dto = postService.postFindById(id);
        model.addAttribute("post",dto);
        return "postby";
    }
    @GetMapping("/post/update/{id}")
    public String postUpdateById(@PathVariable Long id, Model model){
        model.addAttribute("post",postService.postFindById(id));
        return "postUpdate";
    }
    @GetMapping("/post/create")
    public String postCreate(){
        return "postcreate";
    }
}
