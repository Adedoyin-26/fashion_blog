package com.example.fashion_blog.services;

import com.example.fashion_blog.dtos.ApiResponse;
import com.example.fashion_blog.dtos.PostRequestDto;

public interface PostService {
    public ApiResponse createPost(PostRequestDto postRequestDto);
}
