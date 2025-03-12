package fr.example.sample_open_rewrite.establishment.internal.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

import static javax.persistence.FetchType.LAZY;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "establishments.employee")
@Table(name = "employee", schema = "establishments")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "establishment_id")
    private Establishment establishment;

    private String firstname;

    private String lastname;

    private String role;

    private String email;
}
