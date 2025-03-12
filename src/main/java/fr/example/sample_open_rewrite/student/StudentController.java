package fr.example.sample_open_rewrite.student;

import fr.example.sample_open_rewrite.student.internal.entity.Student;
import fr.example.sample_open_rewrite.student.spi.dto.StudentDTO;
import fr.example.sample_open_rewrite.student.spi.mapper.StudentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/students", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class StudentController {

    private final StudentServiceInterface studentServiceInterface;
    private final StudentMapper studentMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentDTO addStudent(@Valid @RequestBody StudentDTO studentDTO) {
        Student response = studentServiceInterface.createStudent(studentMapper.toEntity(studentDTO));
        return studentMapper.toDto(response);
    }

    @GetMapping("/{studentId}")
    public StudentDTO findStudentById(@PathVariable UUID studentId) {
        Student response = studentServiceInterface.findStudentById(studentId);
        return studentMapper.toDto(response);
    }

    @DeleteMapping("/{studentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable UUID studentId) {
        studentServiceInterface.deleteStudent(studentId);
    }

}
