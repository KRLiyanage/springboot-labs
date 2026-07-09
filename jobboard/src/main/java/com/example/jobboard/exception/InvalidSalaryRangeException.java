package com.example.jobboard.exception;

public class InvalidSalaryRangeException extends RuntimeException{

    public InvalidSalaryRangeException() {
        super("Salary Max cannot be less than Salary Min.");
    }

    public InvalidSalaryRangeException(String message) {
        super(message);
    }
}
