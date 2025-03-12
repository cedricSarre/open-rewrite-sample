package fr.example.sample_open_rewrite.establishment.spi.mapper;

import fr.example.sample_open_rewrite.establishment.internal.entity.Employee;
import fr.example.sample_open_rewrite.establishment.spi.dto.EmployeeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    @Mapping(target = "establishment", ignore = true)
    Employee toEntity(EmployeeDTO employeeDTO);

    @Mapping(target = "establishmentId", ignore = true)
    EmployeeDTO toDto(Employee employee);

    List<EmployeeDTO> toDtos(List<Employee> employees);
}
