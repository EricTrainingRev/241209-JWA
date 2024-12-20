package com.revature;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

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
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            //TODO: add non-FileUtils screenshot code here
        } finally {
            if (driver != null){
                driver.quit();
            }
        }
    }
}
