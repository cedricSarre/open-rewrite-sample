package fr.example.sample_open_rewrite.establishment.spi.exception;

import fr.example.sample_open_rewrite.core.exception.InternalNotFoundException;

import java.util.UUID;

public class ActivityNotFoundException extends InternalNotFoundException {
    public ActivityNotFoundException(UUID establishmentId, UUID activityId) {
        super("Activity " + activityId + " of establishment " + establishmentId + " not found");
    }

}
