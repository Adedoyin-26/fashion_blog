package com.example.fashion_blog.controllers;


import com.example.fashion_blog.dtos.ApiResponse;
import com.example.fashion_blog.dtos.UserRequestDto;
import com.example.fashion_blog.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;

    @PostMapping("/signup")
    public ApiResponse signup(@Valid @RequestBody UserRequestDto userRequestDto){
        return userService.signup(userRequestDto);
    }

    @PostMapping("/login")
    public ApiResponse login(@RequestBody UserRequestDto userRequestDto) {
        return userService.login(userRequestDto);

    }
}
