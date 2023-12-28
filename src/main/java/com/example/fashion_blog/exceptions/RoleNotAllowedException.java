package com.example.fashion_blog.exceptions;

public class RoleNotAllowedException extends RuntimeException{
    public RoleNotAllowedException(String s) {
        super(s);
    }
}
