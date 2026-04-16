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

        assertTrue(mainPage.isBunsTabActive());
    }

    @Test
    public void switchToSaucesTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSauces();
        assertTrue(mainPage.isSaucesTabActive());
    }

    @Test
    public void switchToFillingsTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickFillings();
        assertTrue(mainPage.isFillingsTabActive());
    }
}
