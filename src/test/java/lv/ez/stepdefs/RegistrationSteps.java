package lv.ez.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lv.ez.pages.register.RegisterPage;

import static com.codeborne.selenide.Selenide.page;

public class RegistrationSteps {

    private RegisterPage registerPage = page(RegisterPage.class);

    @Given("user is in registration page")
    public void userIsInRegistrationPage() {
        registerPage.openPage();
    }

    @And("prepare ID pop-up is displayed")
    public void prepareIDPopUpIsDisplayed() {
        registerPage.prepareIdPopUpIsDisplayed();
    }

    @And("users fills in first form with {string} data")
    public void usersFillsInFirstFormWithData(String form) {
        registerPage.populateFormWithData(form);
    }

    @Then("errors should be displayed for all inputs")
    public void errorsShouldBeDisplayedForAllInputs() {
        registerPage.verifyAllErrorMessagesAreDisplayed();
    }

    @Then("no errors should be displayed for inputs")
    public void noErrorsShouldBeDisplayedForInputs() {
        registerPage.verifyAllErrorMessagesAreNotDisplayed();
    }
}
