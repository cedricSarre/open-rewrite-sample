package fr.example.sample_open_rewrite.student.internal.domain;

import fr.example.sample_open_rewrite.student.internal.entity.Student;
import fr.example.sample_open_rewrite.student.internal.repository.StudentRepository;
import fr.example.sample_open_rewrite.student.spi.exception.StudentNotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    private Student student;
    private UUID studentId;

    @Before
    public void setUp() {
        studentId = UUID.randomUUID();
        student = Student.builder().id(studentId).firstname("John").lastname("Doe").build();
    }

    @Test
    public void testCreateStudent() {
        when(studentRepository.save(any(Student.class))).thenReturn(student);

        Student createdStudent = studentService.createStudent(student);

        assertNotNull("createdStudent should not be null", createdStudent);
        assertEquals("createdStudent id should be equal to '" + studentId + "'", studentId, createdStudent.getId());
        assertEquals("createdStudent firstname should be equal to 'John'", "John",
                createdStudent.getFirstname());
        assertEquals("createdStudent lastname should be equal to 'Doe'", "Doe", createdStudent.getLastname());
        verify(studentRepository, times(1)).save(student);
    }

    @Test
    public void testFindStudentById_existingId() {
        when(studentRepository.findById(studentId)).thenReturn(Optional.of(student));

        Student foundStudent = studentService.findStudentById(studentId);

        assertNotNull(foundStudent);
        assertEquals(studentId, foundStudent.getId());
        verify(studentRepository, times(1)).findById(studentId);
    }

    @Test(expected = StudentNotFoundException.class)
    public void testFindStudentById_nonExistingId() {
        when(studentRepository.findById(studentId)).thenReturn(Optional.empty());

        studentService.findStudentById(studentId);
    }

    @Test
    public void testFindAllStudents() {
        List<Student> students = Collections.singletonList(student);
        UUID establishmentId = UUID.randomUUID();
        when(studentRepository.findAllByEstablishmentId(eq(establishmentId))).thenReturn(students);

        List<Student> foundStudents = studentService.findAllByEstablishmentId(establishmentId);

        assertNotNull(foundStudents);
        assertEquals(1, foundStudents.size());
        verify(studentRepository, times(1)).findAllByEstablishmentId(eq(establishmentId));
    }

    @Test
    public void testDeleteStudentById() {
        doNothing().when(studentRepository).deleteById(studentId);

        studentService.deleteStudent(studentId);

        verify(studentRepository, times(1)).deleteById(studentId);
    }

    @Test
    public void testUnlinkStudentToEstablishment() {
        studentService.unlinkStudentToEstablishment(student);

        verify(studentRepository, times(1)).save(student);
    }

}
