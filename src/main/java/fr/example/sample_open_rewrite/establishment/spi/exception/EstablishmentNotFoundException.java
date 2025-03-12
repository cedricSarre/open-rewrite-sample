package fr.example.sample_open_rewrite.establishment.spi.exception;

import fr.example.sample_open_rewrite.core.exception.InternalNotFoundException;

import java.util.UUID;

public class EstablishmentNotFoundException extends InternalNotFoundException {
    public EstablishmentNotFoundException(UUID establishmentId) {
        super("Establishment not found: " + establishmentId);
    }

}
