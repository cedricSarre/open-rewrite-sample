package fr.example.sample_open_rewrite.student.spi;

import java.util.UUID;

public interface ExternalInterface {

    void findEstablishmentById(UUID establishmentId);

    void findClassroomById(UUID classroomId);
}
