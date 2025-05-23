package com.yash.swaglabs;

import com.yash.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationPage extends BasePage {

    public ConfirmationPage(WebDriver driver) {
        super(driver);
    }

    private By finish = By.id("finish");

    public void clickOnFinish()
    {
        if(driver.findElement(finish).isDisplayed())
        driver.findElement(finish).click();

    }
}
