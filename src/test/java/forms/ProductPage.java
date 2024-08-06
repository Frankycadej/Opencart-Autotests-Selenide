package forms;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ProductPage {
    public SelenideElement
            addToCartBtn = $x("//button[@id='button-cart']"),
//            viewCartBtn = $x("View Cart"), //general
            addToWishListBtn = $x("//button[contains(@aria-label, 'Wish')]");
}

