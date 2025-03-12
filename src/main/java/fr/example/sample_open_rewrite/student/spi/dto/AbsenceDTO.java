package fr.example.sample_open_rewrite.student.spi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Builder(toBuilder = true)
@AllArgsConstructor
@Getter
public class AbsenceDTO {
    private UUID id;

    @NotBlank(message = "Le champ 'studentId' est obligatoire")
    private UUID studentId;

    @NotBlank(message = "Le champ 'date' est obligatoire")
    private String date;
}
