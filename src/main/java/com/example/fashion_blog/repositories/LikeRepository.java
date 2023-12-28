package com.example.fashion_blog.repositories;

import com.example.fashion_blog.entities.Like;
import com.example.fashion_blog.entities.Post;
import io.micrometer.common.lang.NonNull;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
    @Query("select l from Like l where l.post.id = ?1")
    boolean findByPostId(@NonNull Long id);
    @Transactional
    @Modifying
    @Query("delete from Like l where l.post = ?1")
    int deleteByPost(@NonNull Post post);

    @Query("select l from Like l where l.post.postTitle = ?1")
    boolean findByPostTitle(@NonNull String postTitle);
}
