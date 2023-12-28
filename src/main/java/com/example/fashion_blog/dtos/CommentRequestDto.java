package com.example.fashion_blog.dtos;

import com.example.fashion_blog.entities.Post;
import com.example.fashion_blog.entities.User;

public record CommentRequestDto (String comments, User user, Post post, String username) {
}

