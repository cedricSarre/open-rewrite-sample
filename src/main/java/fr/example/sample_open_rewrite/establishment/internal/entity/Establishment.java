package fr.example.sample_open_rewrite.establishment.internal.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "establishment", schema = "establishments")
public class Establishment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;

    private String address;

    private String phoneNumber;

    private String email;

    private Integer nbMaxClassroom;

    @OneToMany(mappedBy = "establishment")
    private Set<Employee> employees;

    @OneToMany(mappedBy = "establishment")
    private Set<Activity> activities;
}
