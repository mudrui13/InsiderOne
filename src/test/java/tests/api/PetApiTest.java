package tests.api;

import com.insiderone.api.PetApi;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.hamcrest.Matchers.equalTo;

@Epic("API")
@Feature("Pet API CRUD")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PetApiTest extends PetApi {

    private static final long PET_ID = 131313;

    //positive cases
    @Description("POST - create pet -> check status, body values are expected")
    @Test
    @Order(1)
    void createPet() {
        String body = """
                {
                    "id": %d,
                    "name": "Buddy",
                    "status": "available",
                    "photoUrls": ["https://imageblabla.com/test.jpg"]
                }
                """.formatted(PET_ID);

        createPet(body)
                .then()
                .statusCode(200)
                .body("id", equalTo((int) PET_ID))
                .body("name", equalTo("Buddy"))
                .body("status", equalTo("available"));
    }

    @Description("GET - get pet -> check status, body values are expected")
    @Test
    @Order(2)
    void getPet() {
        getPet(PET_ID)
                .then()
                .statusCode(200)
                .body("id", equalTo((int) PET_ID))
                .body("name", equalTo("Buddy"));
    }

    @Description("PUT - update pet -> update name and status -> check statusCode, new body values")
    @Test
    @Order(3)
    void updatePet() {
        String body = """
                {
                    "id": %d,
                    "name": "Buddy2",
                    "status": "new",
                    "photoUrls": ["https://imageblabla.com/test.jpg"]
                }
                """.formatted(PET_ID);

        updatePet(body)
                .then()
                .statusCode(200)
                .body("name", equalTo("Buddy2"))
                .body("status", equalTo("new"));
    }

    @Description("GET - get updated pet -> check statusCode, new body values")
    @Test
    @Order(4)
    void getUpdatedPet() {
        getPet(PET_ID)
                .then()
                .statusCode(200)
                .body("name", equalTo("Buddy2"))
                .body("status", equalTo("new"));
    }

    @Description("DELETE - delete the pet -> check statusCode")
    @Test
    @Order(5)
    void deletePet() {
        deletePet(PET_ID)
                .then()
                .statusCode(200);
    }

    @Description("GET - get deleted pet -> check statusCode")
    @Test
    @Order(6)
    void getDeletedPet() {
        getPet(PET_ID)
                .then()
                .statusCode(404);
    }


    //negative cases

    @Description("GET - get not pet which not present -> check statusCode")
    @Test
    void getPetInvalidId() {
        getPet("invalidIdghsajhbfsjaf")
                .then()
                .statusCode(404);
    }

    @Description("POST - create pet with empty body -> check statusCode")
    @Test
    void createPetEmptyBody() {
        createPet("{}")
                .then()
                .statusCode(200);
    }

    @Description("DELETE - delete not pet which not present -> check statusCode")
    @Test
    void deletePetNotFound() {
        deletePet(7356723657236L)
                .then()
                .statusCode(404);
    }
}
