package ru.praktikum.utils;

import java.util.Random;

public class RandomData {

    public static String generateEmail() {
        Random random = new Random();
        int number = random.nextInt(10000);
        return "test" + number + "@mail.com";
    }
}