package fr.example.sample_open_rewrite.student.internal.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "students.student")
@Table(name = "student", schema = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private UUID classroomId;

    private UUID establishmentId;

    private String firstname;

    private String lastname;

    private Date birthdate;

    @OneToMany(mappedBy = "student")
    private Set<Absence> absences;

    @OneToMany(mappedBy = "student")
    private Set<Rate> rates;
}
