package fr.example.sample_open_rewrite.establishment;

import com.google.gson.Gson;
import fr.example.sample_open_rewrite.SampleOpenRewriteApplication;
import fr.example.sample_open_rewrite.establishment.spi.dto.EstablishmentDTO;
import io.restassured.RestAssured;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.PostgreSQLContainer;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;
import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SampleOpenRewriteApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EstablishmentIntegrationTests {

    static PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>("postgres:13");

    @Value("${local.server.port}")
    public Integer serverPort;

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
    public void testEstablishmentCreationAndDeletion() {
        Gson gson = new Gson();

        // Création d'un établissement
        EstablishmentDTO establishmentDTO = EstablishmentDTO.builder()
                .name("College X")
                .nbMaxClassroom(35)
                .build();

        // Appel API de la création d'un établissement (DTO précédent)
        EstablishmentDTO establishmentCreated = given().port(serverPort)
                .contentType(APPLICATION_JSON_VALUE)
                .body(gson.toJson(establishmentDTO))
                .when()
                .post("/establishments")
                .then()
                .statusCode(CREATED.value())
                .extract()
                .as(EstablishmentDTO.class);

        // Appel API pour récupérer l'établissement créé en fonction de son Id
        EstablishmentDTO establishmentFound = given().port(serverPort)
                .contentType(APPLICATION_JSON_VALUE)
                .when()
                .get("/establishments/" + establishmentCreated.getId())
                .then()
                .statusCode(OK.value())
                .extract()
                .as(EstablishmentDTO.class);

        // Comparaison de l'établissement créé et de l'établissement récupéré
        assertNotNull("establishmentCreated should not be null", establishmentCreated);
        assertNotNull("establishmentFound should not be null", establishmentFound);

        assertNotNull("establishmentCreated id should not be null", establishmentCreated.getId());
        assertNotNull("establishmentFound id should not be null", establishmentFound.getId());
        assertEquals("establishmentCreated id should be equal to establishmentFound id", establishmentCreated.getId(),
                establishmentFound.getId());

        assertEquals("establishmentCreated name should be equal to 'College X'", "College X", establishmentCreated.getName());
        assertEquals("establishmentFound name should be equal to 'College X'", "College X", establishmentFound.getName());

        assertNull("establishmentCreated Address should be null", establishmentCreated.getAddress());
        assertNull("establishmentFound Address should be null", establishmentFound.getAddress());

        assertNull("establishmentCreated Email should be null", establishmentCreated.getEmail());
        assertNull("establishmentFound Email should be null", establishmentFound.getEmail());

        assertNull("establishmentCreated PhoneNumber should be null", establishmentCreated.getPhoneNumber());
        assertNull("establishmentFound PhoneNumber should be null", establishmentFound.getPhoneNumber());

        assertEquals("establishmentCreated NbMaxClassroom should be equal to '35'", 35,
                (int) establishmentCreated.getNbMaxClassroom());
        assertEquals("establishmentFound NbMaxClassroom should be equal to '35'", 35,
                (int) establishmentFound.getNbMaxClassroom());

        // On supprime l'établissement créé via l'API
        given().port(serverPort)
                .contentType(APPLICATION_JSON_VALUE)
                .when()
                .delete("/establishments/" + establishmentCreated.getId())
                .then()
                .statusCode(NO_CONTENT.value());

        // On vérifie via un call API que l'établissement n'existe plus
        given().port(serverPort)
                .contentType(APPLICATION_JSON_VALUE)
                .when()
                .get("/establishments/" + establishmentCreated.getId())
                .then()
                .statusCode(NOT_FOUND.value());
    }
}
