package fr.example.sample_open_rewrite.classroom.spi.mapper;

import fr.example.sample_open_rewrite.classroom.internal.entity.Planning;
import fr.example.sample_open_rewrite.classroom.spi.dto.PlanningDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PlanningMapper {

    @Mapping(target = "classroom", ignore = true)
    Planning toEntity(PlanningDTO planningDTO);

    @Mapping(target = "classroomId", ignore = true)
    PlanningDTO toDto(Planning planning);

    List<PlanningDTO> toDtos(List<Planning> plannings);
}
