package ru.praktikum.pages;

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

    // Действия
    public void enterName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    public String getErrorText() {
        return driver.findElement(errorText).getText();
    }

    public void clickLoginLink() {
        driver.findElement(loginLink).click();
    }

    // Удобный метод
    public void register(String name, String email, String password) {
        enterName(name);
        enterEmail(email);
        enterPassword(password);
        clickRegisterButton();
    }
}
