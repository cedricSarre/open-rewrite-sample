package fr.example.sample_open_rewrite.establishment.spi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.UUID;

@Builder(toBuilder = true)
@AllArgsConstructor
@Getter
public class ActivityDTO {
    private UUID id;

    @NotBlank(message = "Le champ 'title' est obligatoire")
    @Size(max = 255, message = "La taille du champ 'title' doit être inférieure à 255 caractères")
    private String title;

    @NotBlank(message = "Le champ 'description' est obligatoire")
    @Size(max = 255, message = "La taille du champ 'description' doit être inférieure à 255 caractères")
    private String description;

    private Date date;

    @NotBlank(message = "Le champ 'establishmentId' est obligatoire")
    private UUID establishmentId;
}
