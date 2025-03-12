package fr.example.sample_open_rewrite.student.spi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.UUID;

@Builder(toBuilder = true)
@AllArgsConstructor
@Getter
public class StudentDTO {
    private UUID id;

    @NotBlank(message = "Le champ 'firstname' est obligatoire")
    @Size(max = 255, message = "La taille du champ 'firstname' doit être inférieure ou égale à 255 caractères")
    private String firstname;

    @NotBlank(message = "Le champ 'lastname' est obligatoire")
    @Size(max = 255, message = "La taille du champ 'lastname' doit être inférieure ou égale à 255 caractères")
    private String lastname;

    @NotBlank(message = "Le champ 'birthdate' est obligatoire")
    private String birthdate;

    private UUID classroomId;

    private UUID establishmentId;
}
