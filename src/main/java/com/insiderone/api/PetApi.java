package com.insiderone.api;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class PetApi {

    private static final String BASE_URL = "https://petstore.swagger.io/v2";

    //post
    public Response createPet(String body) {
        return given()
                .contentType(JSON)
                .body(body)
                .when()
                .post(BASE_URL + "/pet");
    }

    //get
    public Response getPet(long petId) {
        return given()
                .when()
                .get(BASE_URL + "/pet/" + petId);
    }

    public Response getPet(String petId) {
        return given()
                .when()
                .get(BASE_URL + "/pet/" + petId);
    }

    //put
    public Response updatePet(String body) {
        return given()
                .contentType(JSON)
                .body(body)
                .when()
                .put(BASE_URL + "/pet");
    }

    //delete
    public Response deletePet(long petId) {
        return given()
                .when()
                .delete(BASE_URL + "/pet/" + petId);
    }
}
