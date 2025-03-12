package fr.example.sample_open_rewrite.classroom.spi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Builder(toBuilder = true)
@AllArgsConstructor
@Getter
public class PlanningDTO {
    private UUID id;

    @NotBlank(message = "Le champ 'day' est obligatoire")
    @Size(max = 10, message = "La taille du champ 'day' doit être inférieure ou égale à 10 caractères")
    private String day;

    @NotNull(message = "Le champ 'beginHour' est obligatoire")
    @Size(max = 5, message = "La taille du champ 'beginHour' doit être inférieure ou égale à 5 caractères")
    private String beginHour;

    @NotBlank(message = "Le champ 'endHour' est obligatoire")
    @Size(max = 5, message = "La taille du champ 'endHour' doit être inférieure ou égale à 5 caractères")
    private String endHour;

    @NotBlank(message = "Le champ 'subject' est obligatoire")
    @Size(max = 255, message = "La taille du champ 'subject' doit être inférieure ou égale à 255 caractères")
    private String subject;

    @NotNull(message = "Le champ 'teacherId' est obligatoire")
    private UUID teacherId;

    @NotBlank(message = "Le champ 'location' est obligatoire")
    @Size(max = 255, message = "La taille du champ 'location' doit être inférieure ou égale à 255 caractères")
    private String location;

    @NotNull(message = "Le champ 'classroomId' est obligatoire")
    private UUID classroomId;
}
