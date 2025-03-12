package fr.example.sample_open_rewrite.classroom;

import fr.example.sample_open_rewrite.classroom.internal.entity.Classroom;
import fr.example.sample_open_rewrite.classroom.internal.entity.Planning;
import fr.example.sample_open_rewrite.classroom.spi.dto.ClassroomDTO;
import fr.example.sample_open_rewrite.classroom.spi.dto.PlanningDTO;
import fr.example.sample_open_rewrite.classroom.spi.mapper.ClassroomMapper;
import fr.example.sample_open_rewrite.classroom.spi.mapper.PlanningMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/classrooms", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class ClassroomController {

    private final ClassroomServiceInterface classroomServiceInterface;
    private final ClassroomMapper classroomMapper;
    private final PlanningMapper planningMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClassroomDTO createClassroom(@Valid @RequestBody ClassroomDTO classroomDTO) {
        Classroom response = classroomServiceInterface.createClassroom(classroomMapper.toEntity(classroomDTO));
        return classroomMapper.toDto(response);
    }

    @GetMapping("/{classroomId}")
    public ClassroomDTO findById(@PathVariable UUID classroomId) {
        Classroom response = classroomServiceInterface.findClassroomById(classroomId);
        return classroomMapper.toDto(response);
    }

    @GetMapping
    public List<ClassroomDTO> findByEstablishmentId(@RequestParam UUID establishmentId) {
        List<Classroom> response = classroomServiceInterface.findByEstablishmentId(establishmentId);
        return classroomMapper.toDtos(response);
    }

    @DeleteMapping("/{classroomId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClassroom(@PathVariable UUID classroomId) {
        classroomServiceInterface.deleteById(classroomId);
    }

    @PostMapping("/{classroomId}/plannings")
    @ResponseStatus(HttpStatus.CREATED)
    public PlanningDTO addPlanning(@PathVariable UUID classroomId, @Valid @RequestBody PlanningDTO planningDTO) {
        Planning response = classroomServiceInterface.addPlanning(classroomId, planningMapper.toEntity(planningDTO));
        return planningMapper.toDto(response);
    }

    @GetMapping("/{classroomId}/plannings/{planningId}")
    public PlanningDTO findEmployeeById(@PathVariable UUID classroomId, @PathVariable UUID planningId) {
        Planning response = classroomServiceInterface.findPlanningById(classroomId, planningId);
        return planningMapper.toDto(response);
    }

    @GetMapping("/{classroomId}/plannings")
    public List<PlanningDTO> findAllEmployeeByEstablishmentId(@PathVariable UUID classroomId) {
        List<Planning> response = classroomServiceInterface.findAllPlanningsByClassroomId(classroomId);
        return planningMapper.toDtos(response);
    }

    @DeleteMapping("/{classroomId}/plannings/{planningId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployeeById(@PathVariable UUID classroomId, @PathVariable UUID planningId) {
        classroomServiceInterface.deletePlanningById(classroomId, planningId);
    }

}
