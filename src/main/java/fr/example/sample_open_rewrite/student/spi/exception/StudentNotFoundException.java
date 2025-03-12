package fr.example.sample_open_rewrite.student.spi.exception;

import fr.example.sample_open_rewrite.core.exception.InternalNotFoundException;

import java.util.UUID;

public class StudentNotFoundException extends InternalNotFoundException {
    public StudentNotFoundException(UUID id) {
        super("Student not found: " + id);
    }

}
