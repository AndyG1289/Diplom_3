package ru.praktikum.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

    private WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    // Локаторы
    private By nameField = By.xpath("(//input[@name='name'])[1]");
    private By emailField = By.xpath("(//input[@name='name'])[2]");
    private By passwordField = By.xpath("//input[@type='password']");
    private By registerButton = By.xpath("//button[text()='Зарегистрироваться']");
    private By loginLink = By.xpath("//a[text()='Войти']");
    private By errorText = By.xpath("//p[contains(@class, 'input__error')]");

    @Step("Ввести имя")
    public void enterName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    @Step("Ввести email при регистрации")
    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    @Step("Ввести пароль при регистрации")
    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Нажать кнопку Зарегистрироваться")
    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    @Step("Получить текст ошибки")
    public String getErrorText() {
        return driver.findElement(errorText).getText();
    }

    @Step("Перейти на страницу логина")
    public void clickLoginLink() {
        driver.findElement(loginLink).click();
    }

    @Step("Выполнить регистрацию")
    public void register(String name, String email, String password) {
        enterName(name);
        enterEmail(email);
        enterPassword(password);
        clickRegisterButton();
    }
}
