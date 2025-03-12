package fr.example.sample_open_rewrite.establishment.spi.dto;

import fr.example.sample_open_rewrite.core.enumeration.ValueOfEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.UUID;

@Builder(toBuilder = true)
@AllArgsConstructor
@Getter
public class EmployeeDTO {
    private UUID id;

    @NotBlank(message = "Le champ 'firstname' est obligatoire")
    @Size(max = 255, message = "La taille du champ 'firstname' doit être inférieure ou égale à 255 caractères")
    private String firstname;

    @NotBlank(message = "Le champ 'lastname' est obligatoire")
    @Size(max = 255, message = "La taille du champ 'lastname' doit être inférieure ou égale à 255 caractères")
    private String lastname;

    @NotBlank(message = "Le champ 'role' est obligatoire")
    @ValueOfEnum(field = "role", enumClass = RoleDTO.class, regexp = "TEACHER|ADMINISTRATION")
    private String role;

    @Email
    private String email;

    @NotBlank(message = "Le champ 'establishmentId' est obligatoire")
    private UUID establishmentId;
}
