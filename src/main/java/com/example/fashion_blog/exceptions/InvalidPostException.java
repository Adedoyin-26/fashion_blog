package com.example.fashion_blog.exceptions;

public class InvalidPostException extends RuntimeException {
    public InvalidPostException(String s){
        super(s);
    }
}
