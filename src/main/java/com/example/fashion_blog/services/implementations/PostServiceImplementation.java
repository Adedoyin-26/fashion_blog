package com.example.fashion_blog.services.implementations;

import com.example.fashion_blog.dtos.ApiResponse;
import com.example.fashion_blog.dtos.PostRequestDto;
import com.example.fashion_blog.dtos.PostResponseDto;
import com.example.fashion_blog.entities.Post;
import com.example.fashion_blog.entities.User;
import com.example.fashion_blog.enums.Role;
import com.example.fashion_blog.exceptions.IllegalPostException;
import com.example.fashion_blog.exceptions.PostNotAllowedException;
import com.example.fashion_blog.repositories.PostRepository;
import com.example.fashion_blog.repositories.UserRepository;
import com.example.fashion_blog.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostServiceImplementation implements PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Override
    public ApiResponse createPost(PostRequestDto postRequestDto) {
        if (postRequestDto.role() == Role.ADMIN) {
            User user = userRepository.findByRole(postRequestDto.role()).orElseThrow(
                    () -> new IllegalPostException("No Admin assigned yet")
            );
            Post post = Post.builder()
                    .postTitle(postRequestDto.postTitle())
                    .description(postRequestDto.description())
                    .categories(postRequestDto.categories())
                    .user(user)
                    .imageUrl(postRequestDto.imageUrl())
                    .build();
            postRepository.save(post);
            PostResponseDto postResponseDto = new PostResponseDto(post.getPostTitle(), post.getDescription());
            return new ApiResponse("Post created", postResponseDto, HttpStatus.CREATED);
        } else {
            throw new PostNotAllowedException("Customer can't create posts");
        }
    }

}
