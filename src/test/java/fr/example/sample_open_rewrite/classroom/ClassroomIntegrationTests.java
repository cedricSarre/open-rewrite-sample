package fr.example.sample_open_rewrite.classroom;

import com.google.gson.Gson;
import fr.example.sample_open_rewrite.SampleOpenRewriteApplication;
import fr.example.sample_open_rewrite.classroom.spi.dto.ClassroomDTO;
import fr.example.sample_open_rewrite.establishment.EstablishmentServiceInterface;
import fr.example.sample_open_rewrite.establishment.internal.entity.Establishment;
import io.restassured.RestAssured;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.PostgreSQLContainer;

import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RunWith(SpringRunner.class)
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

    @BeforeClass
    public static void beforeClass() {
        postgreSQLContainer.start();
    }

    @AfterClass
    public static void afterClass() {
        postgreSQLContainer.stop();
    }

    @Before
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

        assertNotNull("classroomFound should not be null", classroomFound);
        assertNotNull("classroomCreated should not be null", classroomCreated);

        assertNotNull("classroomFound id should not be null", classroomCreated.getId());
        assertNotNull("classroomCreated id should not be null", classroomFound.getId());
        assertEquals("classroomCreated id should be equal to classroomFound id", classroomCreated.getId(),
                classroomFound.getId());

        assertEquals("classroomCreated name should be equal to 'Classe X'", "Classe X", classroomCreated.getName());
        assertEquals("classroomFound name should be equal to 'Classe X'", "Classe X", classroomFound.getName());

        assertNotNull("classroomCreated Establishment id should not be null", classroomCreated.getEstablishmentId());
        assertNotNull("classroomFound Establishment id should not be null", classroomFound.getEstablishmentId());
        assertEquals("classroomCreated Establishment id should be equal to classroomFound Establishment id",
                classroomCreated.getEstablishmentId()
                , classroomFound.getEstablishmentId());

        assertNotNull("classroomCreated Level should not be null", classroomCreated.getLevel());
        assertNotNull("classroomFound Level should not be null", classroomFound.getLevel());
        assertEquals("classroomCreated Level should be equal to classroomFound Level", classroomCreated.getLevel(),
                classroomFound.getLevel());

        assertEquals("classroomCreated MaxStudentsCapacity should be equal to '35'", 35, (int) classroomCreated.getMaxStudentsCapacity());
        assertEquals("classroomFound MaxStudentsCapacity should be equal to '35'", 35, (int) classroomFound.getMaxStudentsCapacity());
    }
}
