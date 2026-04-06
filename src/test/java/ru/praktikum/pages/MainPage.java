package ru.praktikum.pages;

import io.qameta.allure.Step;
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
    private By bunsTab = By.xpath("//span[text()='Булки']");
    private By saucesTab = By.xpath("//span[text()='Соусы']");
    private By fillingsTab = By.xpath("//span[text()='Начинки']");
    private By bunsTabActive = By.xpath("//div[contains(@class,'tab_tab_type_current')]/span[text()='Булки']");
    private By saucesTabActive = By.xpath("//div[contains(@class,'tab_tab_type_current')]/span[text()='Соусы']");
    private By fillingsTabActive = By.xpath("//div[contains(@class,'tab_tab_type_current')]/span[text()='Начинки']");

    @Step("Нажать кнопку Войти в аккаунт")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    @Step("Перейти в Личный кабинет")
    public void clickPersonalAccount() {
        driver.findElement(personalAccountButton).click();
    }

    @Step("Перейти в раздел Булки")
    public void clickBuns() {
        driver.findElement(bunsTab).click();
    }

    @Step("Перейти в раздел Соусы")
    public void clickSauces() {
        driver.findElement(saucesTab).click();
    }

    @Step("Перейти в раздел Начинки")
    public void clickFillings() {
        driver.findElement(fillingsTab).click();
    }

    @Step("Проверить, что выбран раздел Булки")
    public boolean isBunsTabActive() {
        return driver.findElement(bunsTabActive).isDisplayed();
    }

    @Step("Проверить, что выбран раздел Соусы")
    public boolean isSaucesTabActive() {
        return driver.findElement(saucesTabActive).isDisplayed();
    }

    @Step("Проверить, что выбран раздел Начинки")
    public boolean isFillingsTabActive() {
        return driver.findElement(fillingsTabActive).isDisplayed();
    }
}