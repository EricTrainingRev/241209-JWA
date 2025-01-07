package com.revature.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.Map;

public class WikiHome {

    private WebDriver driver;

    private Map<String,WebElement> languageLinks;

    @FindBy(id = "js-link-box-en")
    private WebElement englishLink;

    @FindBy(xpath = "/html/body/main/nav[1]/div[6]/a")
    private WebElement spanishLink;

    @FindBy(xpath = "//a[@id='js-link-box-de']")
    private WebElement germanLink;

    public WikiHome(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        languageLinks = new HashMap<>();
        languageLinks.put("spanish", spanishLink);
        languageLinks.put("german", germanLink);
    }

    public void goToWikiHome(){
        driver.get("https://www.wikipedia.org/");
    }

    public void clickEnglishLink(){
        englishLink.click();
    }

    public void clickLanguageLink(String language){
        languageLinks.get(language).click();
    }


}
