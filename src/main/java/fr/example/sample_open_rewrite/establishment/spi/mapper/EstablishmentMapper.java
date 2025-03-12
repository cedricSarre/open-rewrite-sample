package fr.example.sample_open_rewrite.establishment.spi.mapper;

import fr.example.sample_open_rewrite.establishment.internal.entity.Establishment;
import fr.example.sample_open_rewrite.establishment.spi.dto.EstablishmentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EstablishmentMapper {

    @Mapping(target = "employees", ignore = true)
    @Mapping(target = "activities", ignore = true)
    Establishment toEntity(EstablishmentDTO establishmentDTO);

    EstablishmentDTO toDto(Establishment establishment);

    List<EstablishmentDTO> toDtos(List<Establishment> establishments);
}
