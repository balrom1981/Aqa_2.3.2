package ru.netology.web;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.Locale;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


class AuthTest {
    Faker faker = new Faker(new Locale("en"));
    NewUser newUser = new NewUser();

    @BeforeEach
    void shouldOpenWeb() {
        open("http://localhost:9999");
    }

    @Test
    void shouldAccept() {
        RegistrationDto.setNewActiveUser();
        $("[data-test-id='login'] input]").setValue(newUser.getLogin());
        $("[data-test-id=password] [class = input__control]").setValue(newUser.getPassword());
        $(byText("Продолжить")).click();
        $(withText("Личный кабинет")).shouldBe(Condition.visible, Duration.ofSeconds(15));
    }
}