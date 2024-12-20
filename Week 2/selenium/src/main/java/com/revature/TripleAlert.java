package com.revature;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TripleAlert {
    public static void main(String[] args) {
        WebDriver driver = null;
        try{
            driver = new ChromeDriver();
            driver.get("C:\\Users\\EricSuminski\\Desktop\\241209-JWA\\Week 2\\selenium\\src\\main\\resources\\pages\\alertalertalert.html");
            driver.findElement(By.tagName("button")).click();
            /*
                Selenium can use the same alert object for new alerts
                that appear on a page
             */
            Alert alert = driver.switchTo().alert();
            for(int x = 1; x <= 3 ; x++){
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
