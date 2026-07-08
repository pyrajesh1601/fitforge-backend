package com.fitforge.fitforge_ai.exception;

public class EmailAlreadyExistsException extends RuntimeException
{
    public EmailAlreadyExistsException(String message){
        super(message);
    }
}
