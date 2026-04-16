package ru.praktikum.tests;

import org.junit.Test;
import ru.praktikum.pages.LoginPage;
import ru.praktikum.pages.MainPage;
import ru.praktikum.pages.RegisterPage;
import ru.praktikum.utils.RandomData;

import static org.junit.Assert.assertTrue;

public class RegisterTest extends BaseTest {

    @Test
    public void successfulRegistrationTest() {

        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegisterLink();

        RegisterPage registerPage = new RegisterPage(driver);

        String email = RandomData.generateEmail();

        registerPage.register(
                "Test User",
                email,
                "123456"
        );

        loginPage.waitForLoginPage();

        System.out.println(driver.getCurrentUrl());

        assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @Test
    public void registrationWithShortPasswordTest() {

        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegisterLink();

        RegisterPage registerPage = new RegisterPage(driver);

        String email = RandomData.generateEmail();

        registerPage.register(
                "Test User",
                email,
                "123"
        );

        assertTrue(registerPage.getErrorText().contains("Некорректный пароль"));
    }
}
