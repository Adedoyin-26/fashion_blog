package com.example.fashion_blog.dtos;

import com.example.fashion_blog.entities.User;
import com.example.fashion_blog.enums.Categories;
import com.example.fashion_blog.enums.Role;

public record PostRequestDto (String postTitle, String description, String imageUrl,
                              Categories categories, Role role) {
}

