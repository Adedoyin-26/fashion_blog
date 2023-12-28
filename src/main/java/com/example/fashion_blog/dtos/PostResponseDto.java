package com.example.fashion_blog.dtos;

import java.io.Serializable;

public record PostResponseDto (String postTitle, String description) implements Serializable {
}
