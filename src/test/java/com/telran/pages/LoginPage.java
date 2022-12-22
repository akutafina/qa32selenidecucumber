package com.telran.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    public static final By LOGIN_BTN_LOCATOR = By.id("login");
    public static final By PWD_LOCATOR = By.id("password");
    public static final By LOGIN_LOCATOR = By.id("user");
    public static final By ERROR_MSG_LOCATOR = By.id("message");
    public void enterCredentials(String email, String pwd) {
        $(LOGIN_LOCATOR).val(email);
        $(PWD_LOCATOR).val(pwd);
    }

    public void clickOnLoginBtn() {
        $(LOGIN_BTN_LOCATOR).click();
    }

    public SelenideElement getErrorMessageElement() {
        return $(ERROR_MSG_LOCATOR);
    }
}
