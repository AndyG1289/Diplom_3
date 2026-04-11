package ru.praktikum.tests;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import ru.praktikum.pages.LoginPage;
import ru.praktikum.pages.MainPage;
import ru.praktikum.utils.RandomData;
import ru.praktikum.utils.UserApi;

import static org.junit.Assert.assertTrue;

public class LoginTest extends BaseTest {

    private String email;
    private String password;
    private String accessToken;

    @Before
    public void createUser() {
        email = RandomData.generateEmail();
        password = "123456";
        accessToken = UserApi.createUser(email, password, "Test User");
    }

    @Test
    public void loginFromMainPageTest() {

        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(email, password);

        assertTrue(driver.getPageSource().contains("Личный Кабинет"));
    }

    @Test
    public void loginFromPersonalAccountTest() {

        MainPage mainPage = new MainPage(driver);
        mainPage.clickPersonalAccount();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(email, password);

        assertTrue(driver.getPageSource().contains("Личный Кабинет"));
    }

    @Test
    public void loginFromForgotPasswordTest() {

        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickForgotPassword();

        driver.get("https://stellarburgers.education-services.ru/login");

        loginPage.login(email, password);

        assertTrue(driver.getPageSource().contains("Личный Кабинет"));
    }

    @After
    public void deleteUser() {
        if (accessToken != null) {
            UserApi.deleteUser(accessToken);
        }
    }
}