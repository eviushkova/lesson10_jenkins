package com.demoqa;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class WebSteps extends TestBase {

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

    @Step("Check modal form appears")
    public void checkModalForm() {
        $(".modal-content").shouldBe(Condition.visible);
    }

    @Step("Check name")
    public void checkStudentName(String firstName, String lastName) {
        $(".modal-content").shouldHave(Condition.text(firstName + " " + lastName));
    }

    @Step("Check email")
    public void checkStudentEmail(String email) {
        $(".modal-content").shouldHave(Condition.text(email));
    }

    @Step("Check gender")
    public void checkStudentGender(String gender) {
        $(".modal-content").shouldHave(Condition.text(gender));
    }

    @Step("Check phone number")
    public void checkStudentNumber(String phoneNumber) {
        $(".modal-content").shouldHave(Condition.text(phoneNumber));
    }

    @Step("Check date of birth")
    public void checkDateOfBirth(String day, String month, String year) {
        $(".modal-content").shouldHave(Condition.text(day + " " + month + "," + year));
    }

    @Step("Check subject")
    public void checkSubject(String subject) {
        $(".modal-content").shouldHave(Condition.text(subject));
    }

    @Step("Check hobby")
    public void checkHobby(String hobby) {
        $(".modal-content").shouldHave(Condition.text(hobby));
    }

    @Step("Check picture")
    public void checkPicture(String picture) {
        $(".modal-content").shouldHave(Condition.text(picture));
    }

    @Step("Check address")
    public void checkAddress(String address) {
        $(".modal-content").shouldHave(Condition.text(address));
    }

    @Step("Check state and city")
    public void checkStateAndCity(String state, String city) {
        $(".modal-content").shouldHave(Condition.text(state + " " + city));
    }

    @Step("Close modal form")
    public void closeModalForm() {
        $("#closeLargeModal").click();
    }
}
