package fr.example.sample_open_rewrite.classroom.spi.exception;

import fr.example.sample_open_rewrite.core.exception.InternalNotFoundException;

import java.util.UUID;

public class PlanningNotFoundException extends InternalNotFoundException {
    public PlanningNotFoundException(UUID classroomId, UUID planningId) {
        super("Planning " + planningId + " of classroom " + classroomId + " not found");
    }

}
