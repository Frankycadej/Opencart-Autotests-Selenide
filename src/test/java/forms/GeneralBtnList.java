package forms;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class GeneralBtnList {

    public SelenideElement
            myAccountBtn = $x("//i[contains(@class,'fa-user')]/../span or //i[contains(@class,'fa-user')]/following-sibling::span"),
            registerBtn = $x("//a[contains(.,'Register')]"),
            shoppingCartBtn = $x("//span[contains(.,'Shopping Cart')]"),
            wishListBtn = $x("//span[contains(.,'Wish List')]"),
            openCartLogoBtn = $x("//div[@id='logo']/a"),
            itemsCostBtn = $x("//div[@id='header-cart']//button[@type='button']"),
            viewcartBtn = $x("//p/a[contains(@href,'checkout/cart')]");

    public SelenideElement
            desktopsBtn = $x("//a[contains(.,'Desktops')]"),
            showAllDesktopsBtn = $x(" //a[@class='see-all' and contains(@href,'desktops')]");
}