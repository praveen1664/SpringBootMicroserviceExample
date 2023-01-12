package com.jat.UserService.exception;

public class ResourceNotFoundException extends RuntimeException{
//    Extra properties we want to manage

    public ResourceNotFoundException() {
        super("Resource Not found on server");
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
