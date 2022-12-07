package com.global.step_definitions;

import com.github.javafaker.Faker;
import com.global.pages.ShippingPage;
import com.global.pages.ShoppingPage;
import com.global.utilities.ConfigurationReader;
import com.global.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.bytebuddy.asm.Advice;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Shopping_StepDef {
    ShoppingPage shoppingPage = new ShoppingPage();
    ShippingPage shippingPage = new ShippingPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

    @When("user open the {string}")
    public void user_open_the(String string) {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

    }

    @And("user add {string} of {string} to basket")
    public void user_add_of_to_basket(String quantity, String item) {

        shoppingPage.searchBox.sendKeys("Gwyn Endurance Tee", Keys.ENTER);
        shoppingPage.firstItem.click();
        shoppingPage.mediumSize.click();
        shoppingPage.colourOfFirstItem.click();
        shoppingPage.quantityOfFirstItem.clear();
        shoppingPage.quantityOfFirstItem.sendKeys("4");
        shoppingPage.addCartButton.click();


    }

    @And("user should see the adress is {string}")
    public void user_should_see_the_adress_is(String expected) throws InterruptedException {


        wait.until(ExpectedConditions.visibilityOf(shoppingPage.addedCartMessage));
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        shoppingPage.basketButton.click();

        wait.until(ExpectedConditions.visibilityOf(shoppingPage.proceedCheckoutButtonText));
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        shoppingPage.proceedCheckoutButton.click();


        wait.until(ExpectedConditions.visibilityOf(shippingPage.shippingPageContent));


        //Faker faker=new Faker() class can be useful for registration form to assign random data
        shippingPage.emailBox.sendKeys("test@gmail.com");
        shippingPage.firstNameBox.sendKeys("Test");
        shippingPage.lastNameBox.sendKeys("test");
        shippingPage.streetBox.sendKeys("London Street");
        shippingPage.cityBox.sendKeys("London");
        Select selectRegionId = new Select(shippingPage.selectRegionId);
        selectRegionId.selectByIndex(1);

        shippingPage.zipCode.sendKeys("AB12 3CD");
        Select selectCountry = new Select(shippingPage.selectCountry);
        selectCountry.selectByVisibleText(expected);

        shippingPage.phoneNumberBox.sendKeys("123456789");

        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        shippingPage.shippingMethod.click();
        shippingPage.nextButton.click();


    }

    @And("user check the cart total is {string}")
    public void user_check_the_cart_total_is(String expectedPrice) {
        String actualPrice = shippingPage.orderTotal.getText();


        //Payment page verification
        Assert.assertEquals(expectedPrice, actualPrice);


    }


    @And("user update the {string} of {string}")
    public void user_update_the_of(String quantity, String item) {
        //There is NO EDIT CART OPTION!
        // THAT'S WHY I GO TO THE CART BY WRITE DIRECT ADDRESS. I DID NOT SEE THE EDIT CART BUTTON.

        Driver.getDriver().get("https://magento.softwaretestingboard.com/checkout/cart/");

        // Update product (3 pcs)
        shippingPage.edit.click();
        shippingPage.editQuantity.clear();
        shippingPage.editQuantity.sendKeys("3");
        shippingPage.updateButton.click();


    }

    @And("user add {string} to basket")
    public void user_add_to_basket(String item) {
        // add new product small yellow 1 pc
        shippingPage.addNewItems.click();
        shoppingPage.smallSize.click();
        shoppingPage.yellow.click();
        shoppingPage.quantityOfFirstItem.clear();
        shoppingPage.quantityOfFirstItem.sendKeys("1");
        shoppingPage.addCartButton.click();

        // Let's add the 3rd product
        Driver.getDriver().get("https://magento.softwaretestingboard.com/quest-lumaflex-trade-band.html");
        shoppingPage.quantityOfFirstItem.clear();
        shoppingPage.quantityOfFirstItem.sendKeys("1");
        shoppingPage.addCartButton.click();


        shoppingPage.basketButton.click();
        wait.until(ExpectedConditions.visibilityOf(shippingPage.cartVerification));
    }

    @Then("user checks all items price is {string}")
    public void user_checks_all_items_price_is(String allPrice) {


        String actualAllPrice = shippingPage.totalOrder.getText();


        //Payment page verification
        Assert.assertEquals(allPrice, actualAllPrice);

        //MAY BUG IN THIS AREA! THE TOTAL PRICE OF THE PRODUCTS IS NOT $116. TOTAL $115.
    }
}
