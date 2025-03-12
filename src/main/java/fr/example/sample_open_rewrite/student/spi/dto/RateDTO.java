package fr.example.sample_open_rewrite.student.spi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.util.UUID;

@Builder(toBuilder = true)
@AllArgsConstructor
@Getter
public class RateDTO {
    private UUID id;

    @NotBlank(message = "Le champ 'studentId' est obligatoire")
    private UUID studentId;

    @NotBlank(message = "Le subject 'subject' est obligatoire")
    @Size(max = 255, message = "La taille du champ 'subject' doit être inférieure ou égale à 255 caractères")
    private String subject;

    @NotBlank(message = "Le champ 'date' est obligatoire")
    private String date;

    @NotBlank(message = "Le champ 'Value' est obligatoire")
    @PositiveOrZero(message = "La valeur du champ 'value' doit être supérieure ou égale à 0")
    private Float value;
}
