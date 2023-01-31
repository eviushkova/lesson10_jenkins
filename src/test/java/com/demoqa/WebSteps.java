package com.demoqa;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class WebSteps {

    @Step("Open main page")
    public void openMainPage(String url) {
        open(url);
    }

    @Step("Hide banners")
    public void hideJavaScriptCode() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
    }

    @Step("Fill first name")
    public void fillFirstName(String name) {
        $("#firstName").setValue(name);
    }

    @Step("Fill last name")
    public void fillSurname(String lastName) {
        $("#lastName").setValue(lastName);
    }

    @Step("Fill email")
    public void fillUserEmail(String email) {
        $("#userEmail").setValue(email);
    }

    @Step("Set gender")
    public void setGender(String gender) {
        $("#genterWrapper").$(byText(gender)).click();
    }

    @Step("Fill phone number")
    public void fillUserNumber(String phoneNumber) {
        $("#userNumber").setValue(phoneNumber);
    }

    @Step("Set date of birth")
    public void setDateOfBirth(String month, String year, String day) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--0" + day).click();
    }

    @Step("Choose subject")
    public void chooseSubject(String subject) {
        $("#subjectsInput").setValue(subject).pressEnter();
    }

    @Step("Choose hobbies")
    public void chooseHobbies(String hobby) {
        $("#hobbiesWrapper").$(byText(hobby)).click();
    }

    @Step("Upload picture")
    public void uploadPicture(String picture) {
        $("#uploadPicture").uploadFile(new File(picture));
    }

    @Step("Set address")
    public void setAddress(String address) {
        $("#currentAddress").setValue(address);
    }

    @Step("Set state")
    public void setState(String state) {
        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();
    }

    @Step("Set city")
    public void setCity(String city) {
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();
    }

    @Step("Submit form")
    public void clickSubmit() {
        $("#submit").click();
    }

    @Step("Check form content")
    public void checkFormContent(String firstName, String lastName, String email,
                                 String gender, String phoneNumber, String day, String month,
                                 String year, String subject, String hobby, String picture,
                                 String address, String state, String city) {
        $(".modal-content").shouldBe(Condition.visible);
        $(".modal-content").shouldHave(Condition.text(firstName + " " + lastName));
        $(".modal-content").shouldHave(Condition.text(email));
        $(".modal-content").shouldHave(Condition.text(gender));
        $(".modal-content").shouldHave(Condition.text(phoneNumber));
        $(".modal-content").shouldHave(Condition.text(day + " " + month + "," + year));
        $(".modal-content").shouldHave(Condition.text(subject));
        $(".modal-content").shouldHave(Condition.text(hobby));
        $(".modal-content").shouldHave(Condition.text(picture));
        $(".modal-content").shouldHave(Condition.text(address));
        $(".modal-content").shouldHave(Condition.text(state + " " + city));
        $("#closeLargeModal").click();
    }
}
