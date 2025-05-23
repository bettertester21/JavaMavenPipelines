package com.yash.swaglabs;

import com.yash.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    private By firstNameTxt =By.id("first-name");
    private By lastNameTxt =By.id("last-name");
    private By postalCodeTxt =By.id("postal-code");

    private By continueBtn =By.id("continue");

    public void checkOut(String firstName,String lastName,String postalCode)
    {
        if(driver.findElement(firstNameTxt).isDisplayed())
        driver.findElement(firstNameTxt).sendKeys(firstName);
        if(driver.findElement(lastNameTxt).isDisplayed())
        driver.findElement(lastNameTxt).sendKeys(lastName);
        if(driver.findElement(postalCodeTxt).isDisplayed())
        driver.findElement(postalCodeTxt).sendKeys(postalCode);
        if(driver.findElement(continueBtn).isDisplayed())
        driver.findElement(continueBtn).click();

    }

}
