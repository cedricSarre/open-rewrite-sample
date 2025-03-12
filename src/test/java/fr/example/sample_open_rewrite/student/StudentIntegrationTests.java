package fr.example.sample_open_rewrite.student;

import com.google.gson.Gson;
import fr.example.sample_open_rewrite.SampleOpenRewriteApplication;
import fr.example.sample_open_rewrite.classroom.ClassroomServiceInterface;
import fr.example.sample_open_rewrite.classroom.internal.entity.Classroom;
import fr.example.sample_open_rewrite.establishment.EstablishmentServiceInterface;
import fr.example.sample_open_rewrite.establishment.internal.entity.Establishment;
import fr.example.sample_open_rewrite.student.spi.dto.StudentDTO;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;

import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@SpringBootTest(classes = SampleOpenRewriteApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentIntegrationTests {

    private final static UUID establishmentId = UUID.fromString("b8c115bd-57e7-4b15-b4ab-c05076179171");

    private final static UUID classroomId = UUID.fromString("c8c115bd-57e7-4b15-b4ab-c05076179171");

    static PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>("postgres:13");

    @Value("${local.server.port}")
    public Integer serverPort;

    @MockBean
    EstablishmentServiceInterface establishmentServiceInterface;

    @MockBean
    ClassroomServiceInterface classroomServiceInterface;

    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgreSQLContainer::getJdbcUrl);
        registry.add("spring.datasource.username", postgreSQLContainer::getUsername);
        registry.add("spring.datasource.password", postgreSQLContainer::getPassword);
        registry.add("spring.sql.init.mode", () -> "always");
    }

    @BeforeAll
    public static void beforeClass() {
        postgreSQLContainer.start();
    }

    @AfterAll
    public static void afterClass() {
        postgreSQLContainer.stop();
    }

    @BeforeEach
    public void setUp() {
        RestAssured.baseURI = "http://localhost:" + serverPort;
    }

    @Test
    public void testStudentCreation() {
        Mockito.when(establishmentServiceInterface.findEstablishmentById(establishmentId))
                .thenReturn(new Establishment());
        Mockito.when(classroomServiceInterface.findClassroomById(classroomId))
                .thenReturn(new Classroom());

        Gson gson = new Gson();

        StudentDTO studentDTO = StudentDTO.builder()
                .classroomId(classroomId)
                .establishmentId(establishmentId)
                .firstname("John")
                .lastname("Doe")
                .birthdate("2000-01-01")
                .build();

        StudentDTO studentCreated = given().port(serverPort)
                .contentType(APPLICATION_JSON_VALUE)
                .body(gson.toJson(studentDTO))
                .when()
                .post("/students")
                .then()
                .statusCode(CREATED.value())
                .extract()
                .as(StudentDTO.class);

        StudentDTO studentFound = given().port(serverPort)
                .contentType(APPLICATION_JSON_VALUE)
                .when()
                .get("/students/" + studentCreated.getId())
                .then()
                .statusCode(OK.value())
                .extract()
                .as(StudentDTO.class);

        assertNotNull(studentCreated, "studentCreated should not be null");
        assertNotNull(studentFound, "studentFound should not be null");

        assertNotNull(studentCreated.getId(), "studentCreated id should not be null");
        assertNotNull(studentFound.getId(), "studentFound id should not be null");
        assertEquals(studentCreated.getId(),
                studentFound.getId(),
                "studentCreated id should be equal to studentFound id");

        assertEquals("John", studentCreated.getFirstname(), "studentCreated firstname should be equal to 'John'");
        assertEquals("John", studentFound.getFirstname(), "studentFound firstname should be equal to 'John'");

        assertEquals("Doe", studentCreated.getLastname(), "studentCreated lastname should be equal to 'Doe'");
        assertEquals("Doe", studentFound.getLastname(), "studentFound lastname should be equal to 'Doe'");

        assertNotNull(studentCreated.getBirthdate(), "studentCreated birthdate should not be null");
        assertNotNull(studentFound.getBirthdate(), "studentFound birthdate should not be null");
        assertEquals(studentCreated.getBirthdate(),
                studentFound.getBirthdate(),
                "studentCreated birthdate should be equal to studentFound birthdate");

        assertEquals(classroomId, studentCreated.getClassroomId(), "studentCreated classroomId should be equal to '" + classroomId + "'");
        assertEquals(classroomId, studentFound.getClassroomId(), "studentFound classroomId should be equal to '" + classroomId + "'");

        assertEquals(establishmentId, studentCreated.getEstablishmentId(), "studentCreated establishmentId should be equal to '" + establishmentId + "'");
        assertEquals(establishmentId,
                studentFound.getEstablishmentId(),
                "studentFound establishmentId should be equal to '" + establishmentId + "'");

    }
}
