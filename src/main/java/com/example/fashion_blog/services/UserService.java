package com.example.fashion_blog.services;

import com.example.fashion_blog.dtos.ApiResponse;
import com.example.fashion_blog.dtos.UserRequestDto;

public interface UserService {
    ApiResponse signup(UserRequestDto userRequestDto);

    ApiResponse login(UserRequestDto userRequestDto);
}
