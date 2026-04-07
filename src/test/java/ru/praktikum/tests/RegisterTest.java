package ru.praktikum.tests;

import org.junit.Test;
import ru.praktikum.pages.LoginPage;
import ru.praktikum.pages.MainPage;
import ru.praktikum.pages.RegisterPage;
import ru.praktikum.utils.RandomData;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

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

    @Test
    public void loginFromMainPageTest() {

        String email = RandomData.generateEmail();
        String password = "123456";

        // регистрация
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegisterLink();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.register("Test User", email, password);

        registerPage.clickLoginLink();

        LoginPage loginPageAfterRegister = new LoginPage(driver);
        loginPageAfterRegister.login(email, password);
    }

    @Test
    public void loginFromPersonalAccountTest() {

        String email = RandomData.generateEmail();
        String password = "123456";

        // регистрация
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegisterLink();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.register("Test User", email, password);

        driver.get("https://stellarburgers.education-services.ru/");

        mainPage.clickPersonalAccount();

        LoginPage loginPageAfter = new LoginPage(driver);
        loginPageAfter.login(email, password);

        assertTrue(driver.getPageSource().contains("Личный Кабинет"));
    }

    @Test
    public void loginFromForgotPasswordTest() {

        String email = RandomData.generateEmail();
        String password = "123456";

        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegisterLink();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.register("Test User", email, password);

        // возвращаемся на логин
        registerPage.clickLoginLink();

        // переходим в восстановление пароля
        LoginPage loginPageAfter = new LoginPage(driver);
        loginPageAfter.clickForgotPassword();

        // возвращаемся обратно на логин
        driver.get("https://stellarburgers.education-services.ru/login");

        // логинимся
        loginPageAfter.login(email, password);

        assertTrue(driver.getPageSource().contains("Личный Кабинет"));
    }
}
