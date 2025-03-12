package fr.example.sample_open_rewrite.classroom.spi.exception;


import fr.example.sample_open_rewrite.core.exception.InternalNotFoundException;

import java.util.UUID;

public class ClassroomFullException extends InternalNotFoundException {

    public ClassroomFullException(int maxNumber, UUID establishmentId) {
        super("Max number of classrooms of establishment " + establishmentId + " has been reached ( " + maxNumber + ")");
    }
}
