package fr.example.sample_open_rewrite.establishment.spi.exception;

import fr.example.sample_open_rewrite.core.exception.InternalNotFoundException;

import java.util.UUID;

public class EmployeeNotFoundException extends InternalNotFoundException {
    public EmployeeNotFoundException(UUID establishmentId, UUID employeeId) {
        super("Employee " + employeeId + " of establishment " + establishmentId + " not found");
    }

    public EmployeeNotFoundException(UUID employeeId) {
        super("Employee " + employeeId + " not found");
    }
}
