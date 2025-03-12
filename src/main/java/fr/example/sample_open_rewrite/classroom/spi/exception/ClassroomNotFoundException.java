package fr.example.sample_open_rewrite.classroom.spi.exception;


import fr.example.sample_open_rewrite.core.exception.InternalNotFoundException;

import java.util.UUID;

public class ClassroomNotFoundException extends InternalNotFoundException {
    public ClassroomNotFoundException(UUID id, String type) {
        super(type + " not found: " + id);
    }

}
