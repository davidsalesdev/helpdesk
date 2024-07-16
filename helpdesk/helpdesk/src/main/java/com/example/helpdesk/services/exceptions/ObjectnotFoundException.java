package com.example.helpdesk.services.exceptions;

public class ObjectnotFoundException  extends RuntimeException {

    private static final long serialVersionUID = 1l;

    public ObjectnotFoundException(String message, Throwable cause){
        super(message, cause);

    }

    public ObjectnotFoundException(String message){
        super(message);
    }

}

