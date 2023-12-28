package com.example.fashion_blog.exceptions;

public class PostNotAllowedException extends RuntimeException{
    public PostNotAllowedException(String s) {
        super(s);
    }
}
