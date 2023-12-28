package com.example.fashion_blog.services.implementations;

import com.example.fashion_blog.dtos.ApiResponse;
import com.example.fashion_blog.entities.Comment;
import com.example.fashion_blog.entities.Like;
import com.example.fashion_blog.entities.Post;
import com.example.fashion_blog.repositories.CommentRepository;
import com.example.fashion_blog.repositories.LikeRepository;
import com.example.fashion_blog.repositories.PostRepository;
import com.example.fashion_blog.services.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class LikeServiceImplementation implements LikeService {
    private final PostRepository postRepository;
    private final LikeRepository likeRepository;
    private final CommentRepository commentRepository;

    @Override
    public ApiResponse likePost(String postTitle) {
        Optional<Post> post = postRepository.findByPostTitle(postTitle);
        Post post1 = post.get();
        Like like = Like.builder()
                .post(post1)
                .build();
        likeRepository.save(like);
        return new ApiResponse("Like success", HttpStatus.OK);
    }

    @Override
    public ApiResponse likeComment(Long commentId) {
        Optional<Comment> comment = commentRepository.findById(commentId);
        Comment comment1 = comment.get();
        Like like = Like.builder()
                .comment(comment1)
                .build();
        likeRepository.save(like);
        return new ApiResponse("Comment like successful",  HttpStatus.OK);
    }
}
