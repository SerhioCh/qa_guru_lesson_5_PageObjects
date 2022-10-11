package com.demoqa.utils;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.RegistrationFormPage;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class RandomUtils {
    Faker faker = new Faker(new Locale("eng"));
   public String firstName = faker.name().firstName(),
     lastName = faker.name().lastName(),
    email = faker.internet().emailAddress(),
     gender = "Other",
     phoneNumber = faker.phoneNumber().subscriberNumber(10),
     BirthdayDay = String.valueOf(faker.number().numberBetween(10, 27)),
     BirthdayMonth = getRandomMonth(),
     BirthdayYear = String.valueOf(faker.number().numberBetween(1999, 2005)),
     subjects = "Math",
     hobbies = "Sports",
     currentAddress = faker.address().fullAddress(),
     state = "NCR",
     city = "Delhi";
    public static String getRandomMonth() {
        List<String> months = Arrays.asList(
                "January", "February", "March", "April",
                "May", "June", "July", "August",
                "September", "October", "November", "December");

        int index = new Random().nextInt(months.size());
        return months.get(index);
    }
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
    }
}


