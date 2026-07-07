package com.example.jobboard.exception;

public class DuplicateEmailException extends RuntimeException{

    public DuplicateEmailException() {
        super("An applicant with this email already exists.");
    }

    public DuplicateEmailException(String message) {
        super(message);
    }
}
