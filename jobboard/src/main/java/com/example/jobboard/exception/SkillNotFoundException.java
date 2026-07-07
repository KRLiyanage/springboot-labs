package com.example.jobboard.exception;

public class SkillNotFoundException extends RuntimeException{

    public SkillNotFoundException() {
        super("Skill not found");
    }

    public SkillNotFoundException(String message) {
        super(message);
    }
}
