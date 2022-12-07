package com.global.pages;

import com.global.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingPage {
    public ShippingPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//strong[@role=\"heading\"]/span")
    public WebElement shippingPageContent;

    @FindBy(xpath = "//li//input[@name=\"username\"]")
    public WebElement emailBox;

    @FindBy(xpath = "//input[@name=\"firstname\"]")
    public WebElement firstNameBox;

    @FindBy(xpath = "//input[@name=\"lastname\"]")
    public WebElement lastNameBox;

    @FindBy(xpath = "//input[@name=\"street[0]\"]")
    public WebElement streetBox;

    @FindBy(xpath = "//input[@name=\"city\"]")
    public WebElement cityBox;

    @FindBy(xpath = "//select[@name=\"region_id\"]")
    public WebElement selectRegionId;

    @FindBy(xpath = "//input[@name=\"postcode\"]")
    public WebElement zipCode;

    @FindBy(xpath = "//select[@name=\"country_id\"]")
    public WebElement selectCountry;


    @FindBy(xpath = "//input[@name=\"telephone\"]")
    public WebElement phoneNumberBox;

    @FindBy(xpath = "//input[@name=\"ko_unique_3\"]")
    public WebElement shippingMethod;

    @FindBy(xpath = "//button[@class=\"button action continue primary\"]/span")
    public WebElement nextButton;

    @FindBy(xpath = "//span[text()=\"Place Order\"]")
    public WebElement PlaceOrderButton;

    @FindBy(xpath = "(//table[@class=\"data table table-totals\"])//tr[4]/td/strong/span")
    public WebElement orderTotal;

    @FindBy(xpath = "(//span[@data-bind=\"text: getValue()\"])[2]")
    public WebElement country;


    //organizing basket
    @FindBy(xpath = "//a[@class=\"action action-edit\"]")
    public WebElement edit;

    @FindBy(id = "qty")
    public WebElement editQuantity;

    @FindBy(xpath = "//button[@id=\"product-updatecart-button\"]")
    public WebElement updateButton;

    @FindBy(xpath = "//a[text()=\"Gwyn Endurance Tee\"]")
    public WebElement addNewItems;

    @FindBy(xpath = "(//span[@class=\"price-wrapper\"])/span")
    public WebElement totalOrder;


    @FindBy(xpath = "(//div[@role=\"alert\"])//div[2]")
    public WebElement cartVerification;


}
