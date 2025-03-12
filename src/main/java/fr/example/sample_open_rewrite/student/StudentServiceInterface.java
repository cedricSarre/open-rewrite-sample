package fr.example.sample_open_rewrite.student;

import fr.example.sample_open_rewrite.student.internal.entity.Student;

import java.util.List;
import java.util.UUID;

public interface StudentServiceInterface {

    Student createStudent(Student student);

    void deleteStudent(UUID studentId);

    void unlinkStudentToEstablishment(Student student);

    List<Student> findAllByEstablishmentId(UUID establishmentId);

    Student findStudentById(UUID studentId);
}
