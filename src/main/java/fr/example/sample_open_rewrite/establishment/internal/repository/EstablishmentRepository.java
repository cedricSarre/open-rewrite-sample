package fr.example.sample_open_rewrite.establishment.internal.repository;

import fr.example.sample_open_rewrite.establishment.internal.entity.Establishment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EstablishmentRepository extends JpaRepository<Establishment, UUID> {
}
