package ru.praktikum.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserApi {

    private static final String BASE_URL = "https://stellarburgers.education-services.ru";

    public static String createUser(String email, String password, String name) {
        RestAssured.baseURI = BASE_URL;

        Response response = given()
                .header("Content-type", "application/json")
                .body(new User(email, password, name))
                .post("/api/auth/register");

        return response.then().extract().path("accessToken");
    }

    public static void deleteUser(String accessToken) {
        RestAssured.baseURI = BASE_URL;

        given()
                .header("Authorization", accessToken)
                .delete("/api/auth/user");
    }
}
