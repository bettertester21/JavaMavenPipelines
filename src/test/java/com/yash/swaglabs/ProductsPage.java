package com.yash.swaglabs;

import com.yash.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    WebDriver driver;


    public ProductsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private By backpack = By.id(("add-to-cart-sauce-labs-backpack"));
    private By shoppingCart = By.xpath("//*[@id=\"shopping_cart_container\"]");

   public void clickOnBackpackProduct()
   {
       if(driver.findElement(backpack).isDisplayed())
       driver.findElement(backpack).click();

   }

    public void clickOnShoppingCart()
    {
        if(driver.findElement(shoppingCart).isDisplayed())
        driver.findElement(shoppingCart).click();
    }

    
}
