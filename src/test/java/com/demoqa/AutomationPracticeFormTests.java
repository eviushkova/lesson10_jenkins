package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AutomationPracticeFormTests {

    private static final String FORM = "https://demoqa.com/automation-practice-form";
    private static final String NAME = "Ivan";
    private static final String SURNAME = "Ivanov";
    private static final String EMAIL = "ivanov.ivan@test.com";
    private static final String GENDER = "Male";
    private static final String PHONE = "8800900909";
    private static final String MONTH = "April";
    private static final String YEAR = "1995";
    private static final String DAY = "14";
    private static final String SUBJECT = "Economics";
    private static final String HOBBY = "Reading";
    private static final String PICTURE = "src/test/resources/Screenshot 2022-11-17 at 16.11.13.png";
    private static final String ADDRESS = "London, UK";
    private static final String STATE = "NCR";
    private static final String CITY = "Gurgaon";
    private static final String UPLAODEDFILE = "Screenshot 2022-11-17 at 16.11.13.png";


    @BeforeAll
    static void beforeAll() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1792x1015";
        Configuration.baseUrl = "https ://demoqa.com";
        Configuration.timeout = 10000;
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
    }

    @Test
    public void testAnnotatedStep() {
        WebSteps steps = new WebSteps();

        steps.openMainPage(FORM);
        steps.hideJavaScriptCode();
        steps.fillFirstName(NAME);
        steps.fillSurname(SURNAME);
        steps.fillUserEmail(EMAIL);
        steps.setGender(GENDER);
        steps.fillUserNumber(PHONE);
        steps.setDateOfBirth(MONTH, YEAR, DAY);
        steps.chooseSubject(SUBJECT);
        steps.chooseHobbies(HOBBY);
        steps.uploadPicture(PICTURE);
        steps.setAddress(ADDRESS);
        steps.setState(STATE);
        steps.setCity(CITY);
        steps.clickSubmit();
        steps.checkModalForm();
        steps.checkStudentName(NAME, SURNAME);
        steps.checkStudentEmail(EMAIL);
        steps.checkStudentGender(GENDER);
        steps.checkStudentNumber(PHONE);
        steps.checkDateOfBirth(DAY, MONTH, YEAR);
        steps.checkSubject(SUBJECT);
        steps.checkHobby(HOBBY);
        steps.checkPicture(UPLAODEDFILE);
        steps.checkAddress(ADDRESS);
        steps.checkStateAndCity(STATE, CITY);
        steps.closeModalForm();
    }
}
