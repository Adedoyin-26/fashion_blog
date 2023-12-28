package com.example.fashion_blog.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Comment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String comments;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private User user;

    @ManyToOne
    private Post post;
}
