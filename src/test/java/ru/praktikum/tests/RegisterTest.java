package ru.praktikum.tests;

import org.junit.Test;
import ru.praktikum.pages.LoginPage;
import ru.praktikum.pages.MainPage;
import ru.praktikum.pages.RegisterPage;
import ru.praktikum.utils.RandomData;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.praktikum.utils.UserApi;

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

        String accessToken = UserApi.createUser(email, password, "Test User");

        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(email, password);

        assertTrue(driver.getPageSource().contains("Личный Кабинет"));

        UserApi.deleteUser(accessToken);
    }

    @Test
    public void loginFromPersonalAccountTest() {

        String email = RandomData.generateEmail();
        String password = "123456";

        String accessToken = UserApi.createUser(email, password, "Test User");

        MainPage mainPage = new MainPage(driver);
        mainPage.clickPersonalAccount();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(email, password);

        assertTrue(driver.getPageSource().contains("Личный Кабинет"));

        UserApi.deleteUser(accessToken);
    }

    @Test
    public void loginFromForgotPasswordTest() {

        String email = RandomData.generateEmail();
        String password = "123456";

        String accessToken = UserApi.createUser(email, password, "Test User");

        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickForgotPassword();

        driver.get("https://stellarburgers.education-services.ru/login");

        loginPage.login(email, password);

        assertTrue(driver.getPageSource().contains("Личный Кабинет"));

        UserApi.deleteUser(accessToken);
    }
}
