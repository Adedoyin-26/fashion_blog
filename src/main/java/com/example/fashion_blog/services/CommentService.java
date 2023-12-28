package com.example.fashion_blog.services;

import com.example.fashion_blog.dtos.ApiResponse;
import com.example.fashion_blog.dtos.CommentRequestDto;

public interface CommentService {
    ApiResponse createComment(CommentRequestDto commentRequestDto, String username , Long postId);
}
