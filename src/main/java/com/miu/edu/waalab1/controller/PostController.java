package com.miu.edu.waalab1.controller;

import com.miu.edu.waalab1.domain.Post;
import com.miu.edu.waalab1.domain.dto.PostDto;
import com.miu.edu.waalab1.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping
    public List<PostDto> getPost(){
        return postService.findAll();
    }

    @GetMapping("/{id}") // /api/v1/posts/{id}
    public PostDto getPost(@PathVariable("id") long id){

        return postService.getById(id);
    }

    @GetMapping("/some")
    public String printSomething(@RequestParam("filter") String author){

        return ""+author;
    }

    @PostMapping
    public void savePost( @RequestBody Post p){

        postService.save(p);
    }
}
