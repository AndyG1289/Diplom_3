package ru.praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private WebDriver driver;

    // Конструктор
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    // Локаторы
    private By loginButton = By.xpath("//button[text()='Войти в аккаунт']");
    private By personalAccountButton = By.xpath("//p[text()='Личный Кабинет']");
    private By constructorButton = By.xpath("//p[text()='Конструктор']");
    private By bunsTab = By.xpath("//span[text()='Булки']");
    private By saucesTab = By.xpath("//span[text()='Соусы']");
    private By fillingsTab = By.xpath("//span[text()='Начинки']");

    // Методы (действия)
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void clickPersonalAccount() {
        driver.findElement(personalAccountButton).click();
    }

    public void clickConstructor() {
        driver.findElement(constructorButton).click();
    }

    public void clickBuns() {
        driver.findElement(bunsTab).click();
    }

    public void clickSauces() {
        driver.findElement(saucesTab).click();
    }

    public void clickFillings() {
        driver.findElement(fillingsTab).click();
    }
}