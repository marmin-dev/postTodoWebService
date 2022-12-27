package com.mypost.todopost.controller;

import com.mypost.todopost.service.PostService;
import com.mypost.todopost.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class IndexController {
    private final PostService postService;
    private final TodoService todoService;
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("todo",todoService.getAllByDesc());
        return "index";
    }
}
