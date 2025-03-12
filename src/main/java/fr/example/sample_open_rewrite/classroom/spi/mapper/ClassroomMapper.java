package fr.example.sample_open_rewrite.classroom.spi.mapper;

import fr.example.sample_open_rewrite.classroom.internal.entity.Classroom;
import fr.example.sample_open_rewrite.classroom.spi.dto.ClassroomDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClassroomMapper {

    @Mapping(target = "plannings", ignore = true)
    Classroom toEntity(ClassroomDTO classroomDTO);

    ClassroomDTO toDto(Classroom classroom);

    List<ClassroomDTO> toDtos(List<Classroom> classrooms);
}
