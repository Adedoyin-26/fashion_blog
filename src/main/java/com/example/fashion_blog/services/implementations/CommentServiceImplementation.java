package com.example.fashion_blog.services.implementations;


import com.example.fashion_blog.dtos.ApiResponse;
import com.example.fashion_blog.dtos.CommentRequestDto;
import com.example.fashion_blog.dtos.CommentResponseDto;
import com.example.fashion_blog.entities.Comment;
import com.example.fashion_blog.entities.Post;
import com.example.fashion_blog.entities.User;
import com.example.fashion_blog.exceptions.InvalidPostException;
import com.example.fashion_blog.repositories.CommentRepository;
import com.example.fashion_blog.repositories.PostRepository;
import com.example.fashion_blog.repositories.UserRepository;
import com.example.fashion_blog.services.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CommentServiceImplementation implements CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Override
    public ApiResponse createComment(CommentRequestDto commentRequestDto, String username, Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new InvalidPostException("Post doesn't exist"));
        User user1 = userRepository.findByUsername(username);
        Comment comment = Comment.builder()
                .comments(commentRequestDto.comments())
                .post(post)
                .user(user1)
                .build();
        commentRepository.save(comment);
        CommentResponseDto commentResponseDto = CommentResponseDto.builder()
                .id(comment.getId())
                .comments(commentRequestDto.comments())
                .build();
        return new ApiResponse("Comment successful",commentResponseDto);
    }
}
