package ru.netology.web;

import com.github.javafaker.Faker;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;


import static io.restassured.RestAssured.given;


public class RegistrationDto {

    public static RequestSpecification requestSpecification = new RequestSpecBuilder()
            .setBaseUri("http://localhost")
            .setPort(9999)
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();


    public static void setNewUser(NewUser registration) {
        given()
                .spec(requestSpecification) // указываем, какую спецификацию используем
                .body(registration) // передаём в теле объект, который будет преобразован в JSON
                .when() // "когда"
                .post("/api/system/users") // на какой путь, относительно BaseUri отправляем запрос
                .then() // "тогда ожидаем"
                .statusCode(200);
    }

    public static NewUser setNewActiveUser() {
        Faker faker = new Faker();
        String login = faker.name().fullName();
        String password = faker.internet().password();
        String status = "active";
        NewUser registration = new NewUser(login, password, status);
        setNewUser(registration);
        return registration;
    }

    public static NewUser setNewBlockedUser() {
        Faker faker = new Faker();
        String login = faker.name().fullName();
        String password = faker.internet().password();
        String status = "blocked";
        NewUser registration = new NewUser(login, password, status);
        setNewUser(registration);
        return registration;
    }

}
