package com.example.jobboard.exception;

public class ApplicantNotFoundException extends RuntimeException{

    public ApplicantNotFoundException() {
        super("Applicatin not found");
    }

    public ApplicantNotFoundException(String message) {
        super(message);
    }
}
