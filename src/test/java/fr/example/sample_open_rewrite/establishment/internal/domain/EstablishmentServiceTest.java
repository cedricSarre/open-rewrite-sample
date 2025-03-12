package fr.example.sample_open_rewrite.establishment.internal.domain;

import fr.example.sample_open_rewrite.establishment.internal.entity.Activity;
import fr.example.sample_open_rewrite.establishment.internal.entity.Employee;
import fr.example.sample_open_rewrite.establishment.internal.entity.Establishment;
import fr.example.sample_open_rewrite.establishment.internal.repository.ActivityRepository;
import fr.example.sample_open_rewrite.establishment.internal.repository.EmployeeRepository;
import fr.example.sample_open_rewrite.establishment.internal.repository.EstablishmentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class EstablishmentServiceTest {

    @Mock
    private EstablishmentRepository establishmentRepository;

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private ActivityRepository activityRepository;

    @InjectMocks
    private EstablishmentService establishmentService;

    @Test
    public void testCreateEstablishment_whenValidData() {
        UUID establishmentId = UUID.randomUUID();
        Establishment establishment = Establishment.builder().id(establishmentId).name("Establishment A").build();

        // Mock de save() pour simuler la persistance
        when(establishmentRepository.save(any(Establishment.class))).thenReturn(establishment);

        // Appel du service
        Establishment createdEstablishment = establishmentService.addEstablishment(establishment);

        // Vérification que l'établissement a bien été créé
        assertNotNull(createdEstablishment);
        assertEquals(establishment.getId(), createdEstablishment.getId());
    }

    @Test
    public void testGetMaxNumberOfClassroomByEstablishmentId() {
        UUID establishmentId = UUID.randomUUID();
        Establishment establishment = new Establishment();
        establishment.setNbMaxClassroom(10);

        when(establishmentRepository.findById(establishmentId)).thenReturn(Optional.of(establishment));

        int maxClassrooms = establishmentService.getMaxNumberOfClassroomByEstablishmentId(establishmentId);

        assertEquals(10, maxClassrooms);
    }

    @Test
    public void testFindEmployeeByEstablishmentIdAndEmployeeId_whenExists() {
        UUID establishmentId = UUID.randomUUID();
        UUID employeeId = UUID.randomUUID();
        Employee employee = new Employee();

        when(establishmentRepository.findById(establishmentId)).thenReturn(Optional.of(new Establishment()));
        when(employeeRepository.findById(employeeId))
                .thenReturn(Optional.of(employee));

        Employee result = establishmentService.findEmployeeByEstablishmentIdAndEmployeeId(establishmentId, employeeId);

        assertNotNull(result);
    }

    @Test
    public void testFindAllEmployeesByEstablishmentId() {
        UUID establishmentId = UUID.randomUUID();
        List<Employee> employees = Arrays.asList(new Employee(), new Employee());

        when(establishmentRepository.findById(establishmentId)).thenReturn(Optional.of(new Establishment()));
        when(employeeRepository.findAllByEstablishmentId(establishmentId)).thenReturn(employees);

        List<Employee> result = establishmentService.findAllEmployeesByEstablishmentId(establishmentId);

        assertEquals(2, result.size());
    }

    @Test
    public void testDeleteEmployee() {
        UUID establishmentId = UUID.randomUUID();
        UUID employeeId = UUID.randomUUID();

        when(establishmentRepository.findById(establishmentId)).thenReturn(Optional.of(new Establishment()));
        establishmentService.deleteEmployee(establishmentId, employeeId);

        verify(employeeRepository, times(1)).deleteById(employeeId);
    }

    @Test
    public void testAddActivity() {
        UUID establishmentId = UUID.randomUUID();
        Activity activity = new Activity();

        when(establishmentRepository.findById(establishmentId)).thenReturn(Optional.of(new Establishment()));
        when(activityRepository.save(any(Activity.class))).thenReturn(activity);

        Activity result = establishmentService.addActivity(establishmentId, activity);

        assertNotNull(result);
    }

    @Test
    public void testFindActivityByEstablishmentIdAndActivityId_whenExists() {
        UUID establishmentId = UUID.randomUUID();
        UUID activityId = UUID.randomUUID();
        Activity activity = new Activity();

        when(establishmentRepository.findById(establishmentId)).thenReturn(Optional.of(new Establishment()));
        when(activityRepository.findById(activityId)).thenReturn(Optional.of(activity));

        Activity result = establishmentService.findActivityByEstablishmentIdAndActivityId(establishmentId, activityId);

        assertNotNull(result);
    }

    @Test
    public void testFindAllActivitiesByEstablishmentId() {
        UUID establishmentId = UUID.randomUUID();
        List<Activity> activities = Arrays.asList(new Activity(), new Activity());

        when(establishmentRepository.findById(establishmentId)).thenReturn(Optional.of(new Establishment()));
        when(activityRepository.findAllByEstablishmentId(establishmentId)).thenReturn(activities);

        List<Activity> result = establishmentService.findAllActivitiesByEstablishmentId(establishmentId);

        assertEquals(2, result.size());
    }

    @Test
    public void testDeleteActivity() {
        UUID establishmentId = UUID.randomUUID();
        UUID activityId = UUID.randomUUID();

        when(establishmentRepository.findById(establishmentId)).thenReturn(Optional.of(new Establishment()));
        establishmentService.deleteActivity(establishmentId, activityId);

        verify(activityRepository, times(1)).deleteById(activityId);
    }
}
