package com.example.fashion_blog.services;

import com.example.fashion_blog.dtos.ApiResponse;

public interface LikeService {
    ApiResponse likePost(String postTitle);

    ApiResponse likeComment(Long commentId);
}
