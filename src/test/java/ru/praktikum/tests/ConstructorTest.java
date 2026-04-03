package ru.praktikum.tests;

import org.junit.Test;
import ru.praktikum.pages.MainPage;

import static org.junit.Assert.assertTrue;

public class ConstructorTest extends BaseTest {

    @Test
    public void switchToBunsTest() {

        MainPage mainPage = new MainPage(driver);

        // сначала переключаемся
        mainPage.clickSauces();

        // потом возвращаемся на булки
        mainPage.clickBuns();

        assertTrue(driver.getPageSource().contains("Булки"));
    }

    @Test
    public void switchToSaucesTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSauces();
        assertTrue(driver.getPageSource().contains("Соусы"));
    }

    @Test
    public void switchToFillingsTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickFillings();
        assertTrue(driver.getPageSource().contains("Начинки"));
    }
}
