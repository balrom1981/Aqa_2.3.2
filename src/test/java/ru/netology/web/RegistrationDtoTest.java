package ru.netology.web;


import com.codeborne.selenide.Condition;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.Locale;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


class RegistrationDtoTest {
    Faker faker = new Faker();
    NewUser newUser = new NewUser();

    @BeforeEach
    void shouldOpenWeb() {
        open("http://localhost:9999");
        faker = new Faker(new Locale("eng"));
        newUser = new NewUser();
    }


    @Test
    void shouldAccept() {
        RegistrationDto.setNewActiveUser(faker);
        $("[data-test-id=login] [class = input__control]").setValue(newUser.getLogin());
        $("[data-test-id=password] [class = input__control]")
                .setValue(newUser.getPassword());
        $(byText("Продолжить")).click();
        $(withText("  Личный кабинет")).shouldBe(Condition.visible, Duration.ofSeconds(15));

    }
}