package com.example.fashion_blog.exceptions;

public class UserExistsException extends RuntimeException{
    public UserExistsException(String s){
        super(s);
    }
}
