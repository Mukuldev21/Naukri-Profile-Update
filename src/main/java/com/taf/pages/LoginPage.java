package com.taf.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage extends BasePage{

    //locators
    @FindBy(id="login_Layer")
    private WebElement loginButton;

    @FindBy(xpath = "//input[contains(@placeholder, 'Email ID')]")
    private WebElement emailInputField;

    @FindBy(xpath = "//input[contains(@placeholder, 'password')]")
    private WebElement passwordInputField;

    @FindBy(xpath = "//div[text()='Please enter your Email ID / Username']")
    private WebElement emailErrorMessage;

    @FindBy(xpath = "//div[text()='Please enter your Password']")
    private WebElement passwordErrorMessage;

    @FindBy(xpath = "//div[contains(text(),'Invalid details')]")
    private WebElement errorMessage;

    @FindBy(css = "button.btn-primary.loginButton")
    private WebElement clickOnLogin;

    @FindBy(xpath = "//div[text()='Jobs']")
    private WebElement jobsButton;
    //private final String pageTitle = "Home | Mynaukri";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void verifyLoginPage(){
        Assert.assertTrue(loginButton.isDisplayed(),"Button is not displayed");
    }

    public void validLoginIntoNaukri(String username, String password){

        isElementDisplayed(loginButton);
        loginButton.click();
        isElementDisplayed(emailInputField);
        emailInputField.sendKeys(username);
        passwordInputField.sendKeys(password);
        clickOnLogin.click();
        //waitForVisibility(jobsButton);
        isElementDisplayed(jobsButton);
       
    }

    public void invalidLoginIntoNaukri(String username, String password) {

        loginButton.click();
        emailInputField.sendKeys(username);
        passwordInputField.sendKeys(password);
        clickOnLogin.click();
        Assert.assertTrue(errorMessage.isDisplayed(),"Element not displayed");
    }




}
