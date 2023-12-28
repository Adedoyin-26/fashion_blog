package com.example.fashion_blog.dtos;

import lombok.Builder;

@Builder
public record CommentResponseDto (Long id, String comments) {
}
