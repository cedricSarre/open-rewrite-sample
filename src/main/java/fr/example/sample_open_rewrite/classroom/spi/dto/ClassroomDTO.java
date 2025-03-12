package fr.example.sample_open_rewrite.classroom.spi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.*;
import java.util.UUID;

@Builder(toBuilder = true)
@AllArgsConstructor
@Getter
public class ClassroomDTO {

    private UUID id;

    @NotBlank(message = "Le champ 'classroomName' est obligatoire")
    @Size(max = 255, message = "La taille du champ 'classroomName' doit être inférieure ou égale à 255 caractères")
    private String name;

    @NotNull(message = "Le champ 'establishmentId' est obligatoire")
    private UUID establishmentId;

    @NotBlank(message = "Le champ 'level' est obligatoire")
    @Size(max = 255, message = "La taille du champ 'level' doit être inférieure ou égale à 255 caractères")
    private String level;

    @NotNull(message = "Le champ 'maxStudentsCapacity' est obligatoire")
    @Min(value = 1, message = "La valeur du champ 'maxStudentsCapacity' doit être supérieure ou égale à 1")
    @Max(value = 35, message = "La valeur du champ 'maxStudentsCapacity' doit être inférieure ou égale à 35")
    private Integer maxStudentsCapacity;

}
