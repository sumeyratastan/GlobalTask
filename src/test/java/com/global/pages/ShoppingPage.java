package com.global.pages;

import com.global.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingPage {
    public ShoppingPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@id=\"search\"]")
    public WebElement searchBox;

    @FindBy(xpath = "//button[@title=\"Search\"]")
    public WebElement searchButton;

    @FindBy(linkText = "Gwyn Endurance Tee")
    public WebElement firstItem;

    @FindBy(xpath = "//div[@id=\"option-label-size-143-item-168\"]")
    public WebElement mediumSize;

    @FindBy(xpath = "//div[@option-label=\"Green\"]")
    public WebElement colourOfFirstItem;

    @FindBy(id = "qty")
    public WebElement quantityOfFirstItem;

    @FindBy(id = "product-addtocart-button")
    public WebElement addCartButton;

    @FindBy(xpath = "//div[@class=\"minicart-wrapper\"]/a")
    public WebElement basketButton;

    @FindBy(xpath = "//div[contains(text(), 'You added Gwyn Endurance Tee to your ')]")
    public WebElement addedCartMessage;

    @FindBy(xpath = "//span[@class=\"counter-number\"]")
    public WebElement basketButtonText;

    @FindBy(xpath = "//span[contains(text(),'Item in Cart')]")
    public WebElement proceedCheckoutButtonText;
    @FindBy(id = "top-cart-btn-checkout")
    public WebElement proceedCheckoutButton;

    @FindBy(id = "cart-item-94552-qty")
    public WebElement updateQuantityBox;

    @FindBy(xpath = "//span[@data-bind=\"i18n: 'Update'\"]")
    public WebElement updateButton;

    @FindBy(xpath = "//div[@id=\"option-label-size-143-item-167\"]")
    public WebElement smallSize;

    @FindBy(xpath = "//div[@option-label=\"Yellow\"]")
    public WebElement yellow;

    @FindBy(linkText = "Quest Lumaflex™ Band")
    public WebElement lastItem;


}

