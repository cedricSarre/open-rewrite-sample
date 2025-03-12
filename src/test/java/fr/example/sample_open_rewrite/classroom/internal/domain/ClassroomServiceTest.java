package fr.example.sample_open_rewrite.classroom.internal.domain;

import fr.example.sample_open_rewrite.classroom.internal.entity.Classroom;
import fr.example.sample_open_rewrite.classroom.internal.entity.Planning;
import fr.example.sample_open_rewrite.classroom.internal.repository.ClassroomRepository;
import fr.example.sample_open_rewrite.classroom.internal.repository.PlanningRepository;
import fr.example.sample_open_rewrite.classroom.spi.ExternalInterface;
import fr.example.sample_open_rewrite.classroom.spi.exception.ClassroomEmptyException;
import fr.example.sample_open_rewrite.classroom.spi.exception.ClassroomFullException;
import fr.example.sample_open_rewrite.classroom.spi.exception.ClassroomNotFoundException;
import fr.example.sample_open_rewrite.classroom.spi.exception.PlanningNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ClassroomServiceTest {

    @Mock
    private ClassroomRepository classroomRepository;

    @Mock
    private PlanningRepository planningRepository;

    @Mock
    private ExternalInterface externalInterface;

    @InjectMocks
    private ClassroomService classroomService;

    @Test
    public void testCreateClassroom_whenMaxClassroomsReached() {
        assertThrows(ClassroomFullException.class, () -> {
            UUID establishmentId = UUID.randomUUID();
            Classroom classroom = Classroom.builder().establishmentId(establishmentId).name("Classroom A").build();

            doNothing().when(externalInterface).findEstablishmentById(eq(establishmentId));
            when(classroomRepository.findByEstablishmentId(establishmentId)).thenReturn(Arrays.asList(new Classroom(), new Classroom()));
            when(externalInterface.getMaxNumberOfClassroomByEstablishmentId(establishmentId)).thenReturn(2);

            classroomService.createClassroom(classroom);
        });
    }

    @Test
    public void testCreateClassroom_whenSpaceAvailable() {
        UUID establishmentId = UUID.randomUUID();
        UUID classroomtId = UUID.randomUUID();
        String classroomName = "Classroom A";
        Classroom classroom = Classroom.builder().id(classroomtId).establishmentId(establishmentId).name(classroomName).build();

        doNothing().when(externalInterface).findEstablishmentById(eq(establishmentId));
        when(classroomRepository.findByEstablishmentId(establishmentId)).thenReturn(Collections.singletonList(new Classroom()));
        when(externalInterface.getMaxNumberOfClassroomByEstablishmentId(establishmentId)).thenReturn(3);
        when(classroomRepository.save(any(Classroom.class))).thenReturn(classroom);

        Classroom createdClassroom = classroomService.createClassroom(classroom);

        assertNotNull(createdClassroom, "Create classroom should not be null");
        assertEquals(classroomtId,
                createdClassroom.getId(),
                "Classroom created id should be equal to '" + classroomtId + "'");
        assertEquals(establishmentId,
                createdClassroom.getEstablishmentId(),
                "Created Classroom establishment id should be equal to '" + establishmentId + "'");
        assertEquals(classroomName,
                createdClassroom.getName(),
                "Created Classroom name should be equal to '" + classroomName + "'");
    }

    @Test
    public void testFindClassroomById_whenClassroomNotFound() {
        assertThrows(ClassroomNotFoundException.class, () -> {
            UUID classroomId = UUID.randomUUID();

            when(classroomRepository.findById(classroomId)).thenReturn(Optional.empty());

            classroomService.findClassroomById(classroomId);
        });
    }

    @Test
    public void testGetMaxNumberOfStudentByClassroomId() {
        UUID classroomId = UUID.randomUUID();
        Classroom classroom = Classroom.builder().id(classroomId).name("Classroom A").build();
        classroom.setMaxStudentsCapacity(30);

        when(classroomRepository.findById(classroomId)).thenReturn(Optional.of(classroom));

        int capacity = classroomService.getMaxNumberOfStudentByClassroomId(classroomId);
        assertEquals(30, capacity);
    }

    @Test
    public void testAddPlanning() {
        UUID classroomId = UUID.randomUUID();
        UUID planningId = UUID.randomUUID();
        Classroom classroom = Classroom.builder().id(classroomId).name("Classroom A").build();
        Planning planning =
                Planning.builder().id(planningId).classroom(Classroom.builder().name("Math Class").build()).build();

        when(classroomRepository.findById(classroomId)).thenReturn(Optional.of(classroom));
        when(planningRepository.save(any(Planning.class))).thenReturn(planning);

        Planning addedPlanning = classroomService.addPlanning(classroomId, planning);

        assertNotNull(addedPlanning);
        assertEquals(planningId, addedPlanning.getId());
    }

    @Test
    public void testFindAllPlanningsByClassroomId_whenNoPlannings() {
        assertThrows(ClassroomEmptyException.class, () -> {
            UUID classroomId = UUID.randomUUID();

            when(classroomRepository.findById(classroomId)).thenReturn(Optional.of(new Classroom()));
            when(planningRepository.findAllByClassroomId(classroomId)).thenReturn(Collections.emptyList());

            classroomService.findAllPlanningsByClassroomId(classroomId);
        });
    }

    @Test
    public void testDeletePlanningById() {
        UUID classroomId = UUID.randomUUID();
        UUID planningId = UUID.randomUUID();

        when(classroomRepository.findById(classroomId)).thenReturn(Optional.of(new Classroom()));

        classroomService.deletePlanningById(classroomId, planningId);

        verify(planningRepository, times(1)).deleteById(planningId);
    }

    @Test
    public void testFindByEstablishmentId_whenClassroomsExist() {
        UUID establishmentId = UUID.randomUUID();
        List<Classroom> classrooms = Arrays.asList(new Classroom(), new Classroom());

        when(classroomRepository.findByEstablishmentId(establishmentId)).thenReturn(classrooms);

        List<Classroom> result = classroomService.findByEstablishmentId(establishmentId);

        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    public void testFindByEstablishmentId_whenNoClassrooms() {
        assertThrows(ClassroomNotFoundException.class, () -> {
            UUID establishmentId = UUID.randomUUID();

            when(classroomRepository.findByEstablishmentId(establishmentId)).thenReturn(Collections.emptyList());

            classroomService.findByEstablishmentId(establishmentId);
        });
    }

    @Test
    public void testFindPlanningById_whenExists() {
        UUID classroomId = UUID.randomUUID();
        UUID planningId = UUID.randomUUID();
        Planning planning = new Planning();

        when(classroomRepository.findById(classroomId)).thenReturn(Optional.of(new Classroom()));
        when(planningRepository.findById(planningId)).thenReturn(Optional.of(planning));

        Planning result = classroomService.findPlanningById(classroomId, planningId);

        assertNotNull(result);
    }

    @Test
    public void testFindPlanningById_whenNotFound() {
        assertThrows(PlanningNotFoundException.class, () -> {
            UUID classroomId = UUID.randomUUID();
            UUID planningId = UUID.randomUUID();

            when(classroomRepository.findById(classroomId)).thenReturn(Optional.of(new Classroom()));
            when(planningRepository.findById(planningId)).thenReturn(Optional.empty());

            classroomService.findPlanningById(classroomId, planningId);
        });
    }

}
