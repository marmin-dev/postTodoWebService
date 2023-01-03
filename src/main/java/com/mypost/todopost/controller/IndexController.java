package com.mypost.todopost.controller;

import com.mypost.todopost.dtos.SessionUser;
import com.mypost.todopost.dtos.postDto.PostResponseDto;
import com.mypost.todopost.service.PostService;
import com.mypost.todopost.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class IndexController {
    private final PostService postService;
    private final TodoService todoService;
    private final HttpSession httpSession;

    @GetMapping("/") //메인화면
    public String index(Model model){//메인화면 반환
        model.addAttribute("post",postService.findRecent());
        SessionUser user =(SessionUser) httpSession.getAttribute("user");
        if(user != null){
            model.addAttribute("userName",user.getName());
            model.addAttribute("todo", todoService.getAllByAuthor(user.getName()));
        }
        return "index";
    }
    @GetMapping("/post/all") //전체 게시물
    public String allPosts(Model model){ //전체 포스트 조회 화면 반환
        model.addAttribute("post",postService.findAllByDesc());
        SessionUser user =(SessionUser) httpSession.getAttribute("user");
        if(user != null){
            model.addAttribute("userName",user.getName());
        }
        return "allposts";
    }
    @GetMapping("/post/find/{id}") //내 게시물 보기
    public String postById(@PathVariable Long id, Model model){
        PostResponseDto dto = postService.postFindById(id);
        model.addAttribute("post",dto);
        SessionUser user =(SessionUser) httpSession.getAttribute("user");
        if(user != null){
            model.addAttribute("userName",user.getName());
        }
        return "postby";
    }
    @GetMapping("post/{author}")
    public String postByAuthor(@PathVariable String author,Model model){
        model.addAttribute("post",postService.findByAuthor(author));
        SessionUser user =(SessionUser) httpSession.getAttribute("user");
        if(user != null){
            model.addAttribute("userName",user.getName());
        }
        return "mypost";
    }
    @GetMapping("/post/update/{id}")  // 내 게시물 수정
    public String postUpdateById(@PathVariable Long id, Model model){
        model.addAttribute("post",postService.postFindById(id));
        SessionUser user =(SessionUser) httpSession.getAttribute("user");
        if(user != null){
            model.addAttribute("userName",user.getName());
        }
        return "postUpdate";
    }
    @GetMapping("/post/create") // 내 게시물 생성
    public String postCreate(Model model){
        SessionUser user =(SessionUser) httpSession.getAttribute("user");
        if(user != null){
            model.addAttribute("userName",user.getName());
        }
        return "postcreate";
    }
    @GetMapping("/todo/create") // 내 할일 생성
    public String todoCreate(Model model){
        SessionUser user =(SessionUser) httpSession.getAttribute("user");
        if(user != null){
            model.addAttribute("userName",user.getName());
        }
        return "todoCreate";
    }
    @GetMapping("todo/update/{id}") // 내 할일 업뎃
    public String todoUpdate(@PathVariable Long id, Model model){
        model.addAttribute("todo",todoService.getById(id));
        SessionUser user =(SessionUser) httpSession.getAttribute("user");
        if(user != null){
            model.addAttribute("userName",user.getName());
        }
        return "todoUpdate";
    }
}
