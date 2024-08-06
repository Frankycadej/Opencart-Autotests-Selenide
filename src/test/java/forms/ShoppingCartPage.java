package forms;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ShoppingCartPage {

    public SelenideElement
            continueSCPBtn = $x("//div[@class='text-end']/a"),
            checkoutSCPBtn = $x("//a[contains(@href,'checkout/checkout') and contains(@class,'btn')]");

}
