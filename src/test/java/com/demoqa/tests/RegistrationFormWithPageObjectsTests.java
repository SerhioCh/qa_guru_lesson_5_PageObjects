package com.demoqa.tests;

import com.demoqa.pages.RegistrationFormPage;
import com.demoqa.utils.RandomUtils;
import org.junit.jupiter.api.Test;

public class RegistrationFormWithPageObjectsTests extends RandomUtils {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    @Test
    void fillFormTest() {
        registrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setNumber(phoneNumber)
                .setBirthDate(String.valueOf(BirthdayDay), String.valueOf(BirthdayMonth), BirthdayYear)               //.setBirthDate("30", "July", "2008")
                .setSubjects(subjects)
                .setHobbiesInTheCheckbox(hobbies);
        registrationFormPage.uploadFile("img1.png")
                .setCurrentAddress(currentAddress)
                .setStateOnTheSelect(state)
                .setCityOnTheSelect(city)
                .clickOnButtonSubmit();
            registrationFormPage.checkResultsTableVisible()
                .checkResult("Student Name", firstName+" "+lastName)
                .checkResult("Student Email", email)
                .checkResult("Gender", gender)
                .checkResult("Mobile", phoneNumber )
                .checkResult("Date of Birth", BirthdayDay+" "+BirthdayMonth+","+BirthdayYear)
                .checkResult("Subjects", subjects)
                .checkResult("Hobbies", hobbies)
                .checkResult("Picture", "img1.png")
                .checkResult("Address", currentAddress)
                .checkResult("State and City", state+" "+city);
    }
}