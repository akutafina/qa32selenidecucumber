package com.telran.glue;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.telran.pages.LoginPage;
import com.telran.utils.PropertiesLoader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Selenide.*;

public class LoginPageSteps {
    static final String ERROR_MESSAGE_TEXT = "Incorrect username or password. Try again!!";
    LoginPage loginPage;

    String invalidEmail = PropertiesLoader.loadProperty("invalid.email");
    String invalidPwd = PropertiesLoader.loadProperty("invalid.password");

    final String URL = PropertiesLoader.loadProperty("url");

    @Given("Login Page is opened")
    public void openLoginPage(){
        open(URL);
        loginPage = page(LoginPage.class);
    }

    @When("invalid login credentials are entered")
    public void enterInvalidCredentials(){
        loginPage.enterCredentials(invalidEmail,invalidPwd);
    }

    @And("Login button is clicked")
    public void clickOnLoginBtn(){
        loginPage.clickOnLoginBtn();
    }

    @Then("correct error message appears")
    public void checkErrorMsg(){
        SelenideElement actualErrorElem = loginPage.getErrorMessageElement();
        actualErrorElem.shouldHave(Condition.text(ERROR_MESSAGE_TEXT));
        screenshot("invalidLoginScreenshot");
    }

}
