package fr.example.sample_open_rewrite.classroom.internal.entity;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

import static javax.persistence.FetchType.LAZY;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "classrooms.planning")
@Table(name = "planning", schema = "classrooms")
public class Planning {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "classroom_id")
    private Classroom classroom;

    private int day;

    private int beginHour;

    private int endHour;

    private String subject;

    private UUID teacherId;

    private String location;
}
