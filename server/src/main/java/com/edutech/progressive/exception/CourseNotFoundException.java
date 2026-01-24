package com.edutech.progressive.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

public class CourseNotFoundException extends RuntimeException{

    public CourseNotFoundException(String message) {
        super(message);
    }

}
