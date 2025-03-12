package fr.example.sample_open_rewrite.establishment.spi.exception;

import fr.example.sample_open_rewrite.core.exception.InternalNotFoundException;

import java.util.UUID;

public class EstablishmentEmptyException extends InternalNotFoundException {

    public EstablishmentEmptyException(UUID establishmentId, String type) {
        super("Establishment " + establishmentId + " does not have " + type);
    }
}
