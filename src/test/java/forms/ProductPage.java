package forms;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ProductPage {
    public SelenideElement
            addToCartBtn = $x("//button[@id='button-cart']"),
            addToWishListBtn = $x("//div[@class='btn-group']/button[1]"); //button[contains(@aria-label,'Wish')]
}

