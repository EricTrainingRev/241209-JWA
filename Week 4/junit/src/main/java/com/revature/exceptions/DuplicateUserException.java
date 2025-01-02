package com.revature.exceptions;

public class DuplicateUserException extends RuntimeException {
    public DuplicateUserException(String message){
        super(message);
    }
}
