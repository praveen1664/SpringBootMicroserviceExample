package com.jat.HotelService.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String s) {
        super(s);
    }

    public ResourceNotFoundException() {

        super("Resource you are searching is not available");
    }

}
