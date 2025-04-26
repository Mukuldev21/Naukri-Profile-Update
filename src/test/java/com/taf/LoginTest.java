package com.taf;

import com.taf.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    private String username;
    private String password;
    private String pageTitle;

    @BeforeMethod(dependsOnMethods = "setUp")
    public void initCredentials(){

        //Load valid credentials from JSON File
        username = validLoginData.get("username").getAsString();
        password = validLoginData.get("password").getAsString();
    }

    @Test(priority=1,description = "Verify Login Page Accessibility")
    public void testLoginPageAccessibility(){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyLoginPage();
    }
    @Test(priority = 2,description = "Verify Successful Login into Naukri Profile")
    public void testSuccessfulLogin(){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyLoginPage();
        loginPage.validLoginIntoNaukri(username,password);

    }
}
