package fr.example.sample_open_rewrite.classroom.spi.external;

import fr.example.sample_open_rewrite.classroom.spi.ExternalInterface;
import fr.example.sample_open_rewrite.establishment.EstablishmentServiceInterface;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service(value = "classroomExternalService")
@RequiredArgsConstructor
@Slf4j
public class ExternalService implements ExternalInterface {

    private final EstablishmentServiceInterface establishmentServiceInterface;

    @Override
    public void findEstablishmentById(UUID establishmentId) {
        establishmentServiceInterface.findEstablishmentById(establishmentId);
    }

    @Override
    public int getMaxNumberOfClassroomByEstablishmentId(UUID establishmentId) {
        return establishmentServiceInterface.getMaxNumberOfClassroomByEstablishmentId(establishmentId);
    }

}
