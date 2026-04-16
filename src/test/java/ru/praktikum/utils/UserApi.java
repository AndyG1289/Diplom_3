package ru.praktikum.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.qameta.allure.Step;

import static io.restassured.RestAssured.given;

public class UserApi {

    private static final String BASE_URL = "https://stellarburgers.education-services.ru";

    @Step("Создать пользователя через API")
    public static String createUser(String email, String password, String name) {
        RestAssured.baseURI = BASE_URL;

        Response response = given()
                .header("Content-type", "application/json")
                .body(new User(email, password, name))
                .post("/api/auth/register");

        return response.then().extract().path("accessToken");
    }

    @Step("Удалить пользователя через API")
    public static void deleteUser(String accessToken) {
        RestAssured.baseURI = BASE_URL;

        given()
                .header("Authorization", accessToken)
                .delete("/api/auth/user");
    }
}
