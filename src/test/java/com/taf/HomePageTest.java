package com.taf;

import com.taf.pages.HomePage;
import com.taf.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HomePageTest extends BaseTest{

    private String username;
    private String password;
    private String pageTitle;

    @BeforeMethod(dependsOnMethods = "setUp")
    public void initCredentials(){

        //Load valid credentials from JSON File
        username = validLoginData.get("username").getAsString();
        password = validLoginData.get("password").getAsString();
    }

    @Test(priority = 1,description = "Verify resume is updated successfully in Naukri ")
    public void testSuccessfulLogin(){

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.verifyLoginPage();
        loginPage.validLoginIntoNaukri(username,password);
        homePage.updateResume();

        String resumePath = Paths.get(System.getProperty("user.dir"), "src", "test", "resources",
                "test-data", "resume", "MukulDevMahato_SDET.pdf").toString();
        homePage.uploadResumeFile(resumePath);

    }
}
