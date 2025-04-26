package com.taf.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class HomePage extends BasePage{

    //Locators
    @FindBy(xpath = "//div[text()='Jobs']")
    private WebElement jobsButton;

    @FindBy(xpath = "//a[contains(@href, 'profile') or contains(text(), 'Profile')]")
    private WebElement viewProfileButton;

    @FindBy(xpath = "//a[text()='Update']")
    private WebElement uploadButton;

    // Add the file input locator
    @FindBy(id = "attachCV")
    private WebElement fileInput;

    //@FindBy(xpath = "//span[text()='Update resume']")
    //private WebElement updateResumeButton;
    // Get the absolute path of the file
    //String filePath = Paths.get("src/test/resources/test-data", "Mukul DevMahato_SDET.pdf").toAbsolutePath().toString();
    //String filePath = System.getProperty("user.dir") + "/resources/test-data/Mukul Dev Mahato_SDET.pdf"";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void updateResume(){

        isElementDisplayed(viewProfileButton);
        viewProfileButton.click();
        isElementDisplayed(uploadButton);
        uploadButton.click();
    }

    public void uploadResumeFile(String filePath) {
        try {
            // Create a File object to verify the file exists
            File resumeFile = new File(filePath);

            // Check if file exists and is readable
            if (!resumeFile.exists()) {
                System.err.println("File does not exist: " + resumeFile.getAbsolutePath());
                throw new RuntimeException("Resume file not found at: " + resumeFile.getAbsolutePath());
            }

            // Get the absolute canonical path with correct separators
            String absolutePath = resumeFile.getCanonicalPath();

            // Wait for the file input to be available
            isElementDisplayed(fileInput);

            // Send the file path to the input element
            fileInput.sendKeys(absolutePath);

        } catch (IOException e) {
            throw new RuntimeException("Error handling file path: " + e.getMessage(), e);
        }
    }
}
