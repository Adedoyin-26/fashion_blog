package com.example.fashion_blog.controllers;


import com.example.fashion_blog.dtos.ApiResponse;
import com.example.fashion_blog.dtos.CommentRequestDto;
import com.example.fashion_blog.services.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/")
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/{id}/comment")
    public ApiResponse createComment(@RequestBody CommentRequestDto commentRequestDto, String username, @Param("postId"+"username") Long postId){
        return commentService.createComment(commentRequestDto,username ,postId);
    }
}
