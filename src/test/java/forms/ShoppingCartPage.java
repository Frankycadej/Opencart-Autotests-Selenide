package forms;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ShoppingCartPage {

    public SelenideElement
            continueSCPBtn = $x("Continue"),
            checkoutSCPBtn = $x("Checkout");

}
