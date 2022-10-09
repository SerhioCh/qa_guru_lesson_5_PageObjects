package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class RegistrationFormWithPageObjectsTests {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;

    }
    @Test
    void fillFormTest() {
        registrationFormPage.openPage()
                .setFirstName("Serega")
                .setLastName("Romanovich")
                .setEmail("Serega@romanovich.com")
                .setGender("Other")
                .setNumber("1234567890")
                .setBirthDate("30", "July", "2008")
                .setSubjects("Math")
                .setHobbiesInTheCheckbox("Sports");
            registrationFormPage.uploadFile("img1.png")
                .setCurrentAddress("Some address 1")
                .setStateOnTheSelect("NCR")
                .setCityOnTheSelect("Delhi")
                .clickOnButtonSubmit();
            registrationFormPage.checkResultsTableVisible()
                .checkResult("Student Name", "Serega"+" "+"Romanovich")
                .checkResult("Student Email", "Serega@romanovich.com")
                .checkResult("Gender", "Other")
                .checkResult("Mobile", "1234567890" )
                .checkResult("Date of Birth", "30"+" "+"July,2008")
                .checkResult("Subjects", "Maths")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "img1.png")
                .checkResult("Address", "Some"+" "+"address"+" "+"1")
                .checkResult("State and City", "NCR"+" "+"Delhi");
    }
}