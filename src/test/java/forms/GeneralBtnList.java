package forms;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class GeneralBtnList {

    public SelenideElement
            myAccountBtn = $x("//i[contains(@class,'fa-user')]/../span"), //i[contains(@class,'fa-user')]/following-sibling::span"
            registerBtn = $x("//a[contains(.,'Register')]"),
            loginBtn = $x("//a[contains(@href,'login') and @class='dropdown-item']"),
            shoppingCartBtn = $x("//span[contains(.,'Shopping Cart')]"),
            wishListBtn = $x("//span[contains(.,'Wish List')]"),
            openCartLogoBtn = $x("//div[@id='logo']/a"),
            itemsCostBtn = $x("//div[@id='header-cart']//button[@type='button']"),
            viewCartBtn = $x("//p/a[contains(@href,'checkout/cart')]"),
            dropDownMenuItems = $x("//ul[contains(@class,'dropdown-menu-end')]"),
            macbookInItemsMenu = $x("//td[@class='text-start']/a[contains(@href,'macbook')]"),
            alertAddTodWishList = $x("//div[@id='alert']");

    public SelenideElement
            narbarMenu = $x("//div[@id='narbar-menu']"),
            desktopsBtn = $x("//a[contains(.,'Desktops')]"),
            desktopsDropDownMenu = $x("//a[contains(@href,'desktops/pc')]/../../../.."),
            showAllDesktopsBtn = $x(" //a[@class='see-all' and contains(@href,'desktops')]"),
            laptopsAndNotebooksBtn = $x("//a[contains(@href,'laptop-notebook') and @class='nav-link dropdown-toggle']"),
            componentsBtn = $x("//a[contains(@href,'component') and @class='nav-link dropdown-toggle']"),
            tabletsBtn = $x("//a[contains(@href,'tablet') and @class='nav-link']"),
            softwareBtn = $x("//a[contains(@href,'software') and @class='nav-link']"),
            phonesAndPDAsBtn = $x("//a[contains(@href,'smartphone') and @class='nav-link']"),
            camerasBtn = $x("//a[contains(@href,'cameras') and @class='nav-link']"),
            mp3PlayersBtn = $x("//a[contains(@href,'mp3-players') and @class='nav-link dropdown-toggle']");
}