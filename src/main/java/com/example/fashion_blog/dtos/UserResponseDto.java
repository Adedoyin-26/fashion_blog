package com.example.fashion_blog.dtos;

import com.example.fashion_blog.enums.Role;

public record UserResponseDto(String username, String email, Role role) {
}
