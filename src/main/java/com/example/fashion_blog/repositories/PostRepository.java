package com.example.fashion_blog.repositories;

import com.example.fashion_blog.entities.Post;
import io.micrometer.common.lang.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    @Query("select p from Post p where p.postTitle = ?1")
    Optional<Post> findPostTitle(@NonNull String postTitle);

    @Query("select p from Post p where p.postTitle = ?1")
    Optional<Post> findByPostTitle(@NonNull String postTitle);

    @Override
    Optional<Post> findById(Long id);
}
