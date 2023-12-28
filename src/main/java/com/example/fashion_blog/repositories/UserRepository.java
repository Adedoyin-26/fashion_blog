package com.example.fashion_blog.repositories;

import com.example.fashion_blog.entities.User;
import com.example.fashion_blog.enums.Role;
import io.micrometer.common.lang.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    @Query("select u from User u where u.role = ?1")
    Optional<User> findByRole(@NonNull Role role);

    @Query("select (count(u) > 0) from User u where u.role = ?1")
    boolean existsByRole(@NonNull Role role);

    @Query("select u from User u where u.username = ?1")
    User findByUsername(String username);

    @Query("select u from User u where upper(u.email) = upper(?1) and u.password = ?2")
    Optional<User> findByEmailAndPassword(@NonNull String email, @NonNull String password);

    @Query("select (count(u) > 0) from User u where upper(u.email) = upper(?1)")
    boolean checkIfEmailExists(@NonNull String email);
}
