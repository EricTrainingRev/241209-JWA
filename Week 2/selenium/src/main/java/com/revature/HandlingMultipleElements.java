package com.revature;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HandlingMultipleElements {
    public static void main(String[] args) {
        WebDriver driver = null;
        try{
            driver = new ChromeDriver();
            Alert alert;
            driver.get("C:\\Users\\EricSuminski\\Desktop\\241209-JWA\\Week 2\\selenium\\src\\main\\resources\\pages\\ButtonButtonButton.html");
            /*
                If you are working with multiple web elements, or if you need to search through a collection of
                elements on the page, use the findElements method and a list of all elements found via your
                locator strategy will be returned
             */
            List<WebElement> buttons = driver.findElements(By.tagName("button"));
            /*
                You can then iterate through your list and perform whatever actions you deem necessary on those
                elements
             */
            for (WebElement button : buttons){
                button.click();
                alert = driver.switchTo().alert();
                System.out.println(alert.getText());
                alert.accept();
            }
        } finally {
            if(driver != null){
                driver.quit();
            }
        }
    }
}
