package com.example.fashion_blog.controllers;


import com.example.fashion_blog.dtos.ApiResponse;
import com.example.fashion_blog.dtos.PostRequestDto;
import com.example.fashion_blog.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/")
public class PostController {

    private final PostService postService;

    @PostMapping("/post")
    public ApiResponse createPost(@RequestBody PostRequestDto postRequestDto){
        return postService.createPost(postRequestDto);
    }
}
