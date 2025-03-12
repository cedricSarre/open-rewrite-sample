package fr.example.sample_open_rewrite.classroom.internal.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "classrooms.classroom")
@Table(name = "classroom", schema = "classrooms")
public class Classroom {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;

    private String level;

    private int maxStudentsCapacity;

    private UUID establishmentId;

    @OneToMany(mappedBy = "classroom")
    private Set<Planning> plannings;

}
