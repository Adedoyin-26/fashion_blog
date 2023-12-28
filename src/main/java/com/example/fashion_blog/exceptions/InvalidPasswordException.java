package com.example.fashion_blog.exceptions;

public class InvalidPasswordException extends RuntimeException{
    public InvalidPasswordException(String s) {
        super(s);
    }
}
