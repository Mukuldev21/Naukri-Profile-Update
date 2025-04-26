package com.taf;

import com.google.gson.JsonObject;
import com.taf.utils.configReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Properties;

public class BaseTest {

    protected WebDriver driver;
    protected Properties config;
    protected JsonObject validLoginData;

    @BeforeMethod
    public void setUp() {
        //load the properties file
        config = configReader.loadProperties("src/test/resources/config/config.properties");
        validLoginData = configReader.loadJsonConfig("src/test/resources/test-data/loginDetails.json");

        //Initialize the driver
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Navigate to the url
        driver.get(config.getProperty("url"));
    }

    @AfterMethod
    public void tearDown(){

        if (driver != null) {
            driver.quit();
        }
    }
}
