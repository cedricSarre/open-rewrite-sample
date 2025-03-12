package fr.example.sample_open_rewrite.classroom.internal.repository;

import fr.example.sample_open_rewrite.classroom.internal.entity.Planning;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PlanningRepository extends JpaRepository<Planning, UUID> {
    List<Planning> findAllByClassroomId(UUID classroomId);
}
