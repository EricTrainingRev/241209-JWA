package com.revature;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileUpload {
    public static void main(String[] args) {
        WebDriver driver = null;
        try{
            driver = new ChromeDriver();
            driver.get("C:\\Users\\EricSuminski\\Desktop\\241209-JWA\\Week 2\\selenium\\src\\main\\resources\\pages\\FIleUpload.html");
            /*
                Selenium only automates the browser: it does not have access to resources like your file system
                directly. Because of this, actions such as loading files to a web page are not as intuitive as
                other actions like clicking on an element on the web page. Fortunately, it is a relatively easy
                process to upload files: you only need the file path for the resource you want loaded
             */
            WebElement fileInput = driver.findElement(By.tagName("input"));
            // to provide a file to the input you use the "sendKeys" method
            fileInput.sendKeys("C:\\Users\\EricSuminski\\Desktop\\241209-JWA\\Week 2\\selenium\\src\\main\\resources\\moon-5.jpg");

            /*
                To take a screenshot (of the current content in the browser viewport) you do the following:
                - cast the driver as a TakesScreenshot object and use the getScreenshotAs method to save the screenshot
                  data as a File object
                - Use the Paths.get method to save the location where you want to save your screenshot as a Path object
                - Use the Files.copy method to save your screenshot. Make sure to set the StandardCopyOptions
                  if you know you will be taking multiple screenshots and saving them in the same location
             */
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Path screenshotPath = Paths.get("src/main/resources/screenshot/moon-capture.jpeg");
            Files.copy(scrFile.toPath(),screenshotPath, StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (driver != null){
                driver.quit();
            }
        }
    }
}
