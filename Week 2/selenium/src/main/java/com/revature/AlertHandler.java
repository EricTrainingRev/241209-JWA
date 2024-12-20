package com.revature;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertHandler {
    public static void main(String[] args) {
        WebDriver driver = null;
        try{
            driver = new ChromeDriver();
            driver.get("C:\\Users\\EricSuminski\\Desktop\\241209-JWA\\Week 2\\selenium\\src\\main\\resources\\pages\\AlertPage.html");
            WebElement alertButton = driver.findElement(By.tagName("button"));
            alertButton.click();
            /*
                When you know you need to interact with an alert you use the driver switchTo method
                and then call the alert method. This will return an Alert object you can use to interact
                with your alert on the web page
             */
            Alert alert = driver.switchTo().alert();
            // here we simply get the text of the alert
            System.out.println(alert.getText());
            /*
                make sure to close alerts when you are done with them: unclosed alerts can sometimes cause
                unexpected behavior between Selenium and the browser. Use the accept method to tell
                Selenium to click the "ok" or "accept" button on the alert, and the dismiss method
                to click the "cancel" option, if present
             */
            alert.accept();
        } finally {
            if(driver != null){
                driver.quit();
            }
        }
    }
}
