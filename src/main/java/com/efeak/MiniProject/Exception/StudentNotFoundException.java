package com.efeak.MiniProject.Exception;

import com.efeak.MiniProject.repository.entity.Student;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(String message) {
        super(message);
    }
}
