package fr.example.sample_open_rewrite.student.spi.external;

import fr.example.sample_open_rewrite.classroom.ClassroomServiceInterface;
import fr.example.sample_open_rewrite.establishment.EstablishmentServiceInterface;
import fr.example.sample_open_rewrite.student.spi.ExternalInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service(value = "studentExternalService")
@RequiredArgsConstructor
public class ExternalService implements ExternalInterface {

    private final EstablishmentServiceInterface establishmentServiceInterface;
    private final ClassroomServiceInterface classroomServiceInterface;

    @Override
    public void findEstablishmentById(UUID establishmentId) {
        establishmentServiceInterface.findEstablishmentById(establishmentId);
    }

    @Override
    public void findClassroomById(UUID classroomId) {
        classroomServiceInterface.findClassroomById(classroomId);
    }
}
