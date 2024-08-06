package forms;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class GeneralBtnList {

    public SelenideElement
            myAccountBtn = $x("//i[contains(@class,'fa-user')]/../span or //i[contains(@class,'fa-user')]/following-sibling::span"),
            registerBtn = $x("//a[contains(.,'Register')]"),
            shoppingCartBtn = $x("//span[contains(.,'Shopping Cart')]"),
            wishListBtn = $x("//span[contains(.,'Wish List')]"),
            openCartLogoBtn = $x("//div[@id='logo']/a");

    public SelenideElement
            desktopsBtn = $x("//a[contains(.,'Desktops')]"),
            showAllDesktopsBtn = $x(" //a[@class='see-all' and contains(@href,'desktops')]");
}