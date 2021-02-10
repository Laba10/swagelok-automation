package com.swagelok.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class RandomUtil {

    private static java.util.Random random = new java.util.Random();

    public static String generateRandomPassword(int max) {

        String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Small_chars = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String symbols = "!@#$%^&*_=+-/.?<>)";

        String values = Capital_chars + Small_chars + numbers + symbols;



        char[] password = new char[max];

        for (int i = 0; i < max; i++) {
            password[i] = values.charAt(random.nextInt(values.length()));

        }

        return String.valueOf(password);
    }

    public static String getCurrentDate() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
    }

    public static String generateName(){
        String nickName = "automation";

        int a = random.nextInt(10);
        String number = ""+a;
        String name = nickName + a;
        System.out.println("Triggered name:" + name);

        return name;
    }

    public static String generatePhone(){
        int max = 9;
        char[] phone = new char[max];

        for (int i = 0; i < max; i++) {
            phone[i] = (char) random.nextInt(10);
        }
        String phoneNumber = "+" + String.valueOf(phone);

        System.out.println(phoneNumber);
        return phoneNumber;
    }
}
