package com.fitforge.fitforge_ai.exception;


public class UserNotFoundException extends RuntimeException
{
    public UserNotFoundException(String message){
        super(message);
    }
}
