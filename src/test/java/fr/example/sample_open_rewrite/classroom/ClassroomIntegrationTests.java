package fr.example.sample_open_rewrite.classroom;

import com.google.gson.Gson;
import fr.example.sample_open_rewrite.SampleOpenRewriteApplication;
import fr.example.sample_open_rewrite.classroom.spi.dto.ClassroomDTO;
import fr.example.sample_open_rewrite.establishment.EstablishmentServiceInterface;
import fr.example.sample_open_rewrite.establishment.internal.entity.Establishment;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@SpringBootTest(classes = SampleOpenRewriteApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ClassroomIntegrationTests {

    private final static UUID establishmentId = UUID.fromString("b8c115bd-57e7-4b15-b4ab-c05076179171");

    static PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>("postgres:13");

    @Value("${local.server.port}")
    public Integer serverPort;

    @MockBean
    private EstablishmentServiceInterface establishmentServiceInterface;

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
    public void testClassroomCreation() {
        when(establishmentServiceInterface.findEstablishmentById(eq(establishmentId)))
                .thenReturn(new Establishment());
        when(establishmentServiceInterface.getMaxNumberOfClassroomByEstablishmentId(eq(establishmentId)))
                .thenReturn(1);

        Gson gson = new Gson();

        ClassroomDTO classroomDTO = ClassroomDTO.builder()
                .name("Classe X")
                .establishmentId(establishmentId)
                .level("6ème")
                .maxStudentsCapacity(35)
                .build();

        System.out.println(RestAssured.baseURI);

        ClassroomDTO classroomCreated = given()
                .contentType(APPLICATION_JSON_VALUE)
                .body(gson.toJson(classroomDTO))
                .when()
                .post("/classrooms")
                .then()
                .statusCode(CREATED.value())
                .extract()
                .as(ClassroomDTO.class);

        ClassroomDTO classroomFound = given()
                .contentType(APPLICATION_JSON_VALUE)
                .when()
                .get("/classrooms/" + classroomCreated.getId())
                .then()
                .statusCode(OK.value())
                .extract()
                .as(ClassroomDTO.class);

        assertNotNull(classroomFound, "classroomFound should not be null");
        assertNotNull(classroomCreated, "classroomCreated should not be null");

        assertNotNull(classroomCreated.getId(), "classroomFound id should not be null");
        assertNotNull(classroomFound.getId(), "classroomCreated id should not be null");
        assertEquals(classroomCreated.getId(),
                classroomFound.getId(),
                "classroomCreated id should be equal to classroomFound id");

        assertEquals("Classe X", classroomCreated.getName(), "classroomCreated name should be equal to 'Classe X'");
        assertEquals("Classe X", classroomFound.getName(), "classroomFound name should be equal to 'Classe X'");

        assertNotNull(classroomCreated.getEstablishmentId(), "classroomCreated Establishment id should not be null");
        assertNotNull(classroomFound.getEstablishmentId(), "classroomFound Establishment id should not be null");
        assertEquals(classroomCreated.getEstablishmentId()
                , classroomFound.getEstablishmentId(), "classroomCreated Establishment id should be equal to classroomFound Establishment id");

        assertNotNull(classroomCreated.getLevel(), "classroomCreated Level should not be null");
        assertNotNull(classroomFound.getLevel(), "classroomFound Level should not be null");
        assertEquals(classroomCreated.getLevel(),
                classroomFound.getLevel(),
                "classroomCreated Level should be equal to classroomFound Level");

        assertEquals(35, (int) classroomCreated.getMaxStudentsCapacity(), "classroomCreated MaxStudentsCapacity should be equal to '35'");
        assertEquals(35, (int) classroomFound.getMaxStudentsCapacity(), "classroomFound MaxStudentsCapacity should be equal to '35'");
    }
}
