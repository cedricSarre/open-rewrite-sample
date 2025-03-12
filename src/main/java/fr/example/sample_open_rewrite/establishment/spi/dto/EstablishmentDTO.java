package fr.example.sample_open_rewrite.establishment.spi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.*;
import java.util.UUID;

@Builder(toBuilder = true)
@AllArgsConstructor
@Getter
public class EstablishmentDTO {
    private UUID id;

    @NotBlank(message = "Le champ 'nom' est obligatoire")
    @Size(max = 255, message = "La taille du champ 'nom' doit être inférieure ou égale à 255 caractères")
    private String name;

    @Size(max = 255, message = "La taille du champ 'address' doit être inférieure ou égale à 255 caractères")
    private String address;

    @Size(max = 15, message = "La taille du champ 'phoneNumber' doit être inférieure ou égale à 15 caractères")
    private String phoneNumber;

    @Email
    @Size(max = 255, message = "La taille du champ 'email' doit être inférieure ou égale à 255 caractères")
    private String email;

    @NotNull(message = "Le champ 'nbMaxClassroom' est obligatoire")
    @Min(value = 1, message = "La valeur du champ 'nbMaxClassroom' doit être supérieure ou égale à 1")
    @Max(value = 99, message = "La valeur du champ 'nbMaxClassroom' doit être inférieure ou égale à 99")
    private Integer nbMaxClassroom;
}
