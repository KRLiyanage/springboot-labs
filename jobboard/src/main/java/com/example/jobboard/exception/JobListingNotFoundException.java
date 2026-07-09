package com.example.jobboard.exception;

public class JobListingNotFoundException extends RuntimeException{

    public JobListingNotFoundException() {
        super("Job Listing Not found");
    }

    public JobListingNotFoundException(String message) {
        super(message);
    }
}
