package tests;

import forms.*;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;
import utils.GeneralUtils;
import webdriver.NewTest;

import static com.codeborne.selenide.Condition.*;

@Feature("WishList Test")
public class WishListTest extends NewTest {
    private final AccountCreatedPage accountCreatedPage = new AccountCreatedPage();
    private final GeneralBtnList generalBtnList = new GeneralBtnList();
    private final GeneralUtils generalUtils = new GeneralUtils();
    private final HomePage homePage = new HomePage();
    private final MyAccountPage myAccountPage = new MyAccountPage();
    private final ProductPage productPage = new ProductPage();
    private final RegisterPage registerPage = new RegisterPage();
    private final ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    private final WishListPage wishListPage = new WishListPage();

    @Test
    @Feature("allure")
    @Description("tos")
    @Story("yes")
    public void accountRegister() {
        openMainPage();
        Allure.step("1. Нажать на My Account");
        generalBtnList.myAccountBtn.click();
        Allure.step("2. Нажать на Register");
        generalBtnList.registerBtn.click();
        Allure.step("3. Создать аккаунт", () -> {
            Allure.step("3.1 Ввести значение First Name");
            registerPage.firstNameField.sendKeys("gad");
            Allure.step("3.2 Ввести значение Last Name");
            registerPage.lastNameField.sendKeys("ynish");
            Allure.step("3.3 Ввести значение E-Mail");
            registerPage.emailField.sendKeys(RandomStringUtils.randomPrint(3) + "dsah@gmail.com");
            Allure.step("3.4 Ввести значение Password");
            registerPage.passwordField.sendKeys("drty");
            Allure.step("3.5 Отметить чекбокс Agree to the Privacy Policy");
            registerPage.checkPrivacyPolicy.click();
            Allure.step("3.6 Нажать Continue");
            registerPage.continueRPBtn.click();
        });
        Allure.step("4. На новой странице нажать Continue");
        accountCreatedPage.continueBtn.click();
        Allure.step("5. Проверить что загрузилась страница My Account");
        myAccountPage.myAccountText.shouldHave(text("My Account"));
    }

    @Test
    public void shoppingCart() {
        openMainPage();
        Allure.step("1. Нажать Shopping Cart");
        generalBtnList.shoppingCartBtn.click();
        Allure.step("2. Проверить что он пуст");
        shoppingCartPage.emptyShoppingCart.shouldHave(text("Your shopping cart is empty!"));
        Allure.step("3. Нажать Continue");
        shoppingCartPage.continueSCPBtn.click();
        Allure.step("4. Нажать на MacBook");
        homePage.macBookBtn.click();
        Allure.step("5. Нажать Add to Cart");
        productPage.addToCartBtn.click();
        Allure.step("6. Нажать на 1 item(s)");
        generalBtnList.itemsCostBtn.click();
        Allure.step("7. Проверить выпадающие меню");
        generalBtnList.dropDownMenuItems.should(exist);
        Allure.step("8. Проверить наличие MacBook в n item(s)");
        generalBtnList.macbookInItemsMenu.shouldHave(text("MacBook"));
        Allure.step("9. Нажать View Cart");
        generalBtnList.viewCartBtn.click();
        Allure.step("10. Проверить наличие MacBook в корзине");
        shoppingCartPage.macbookInShoppingCart.shouldHave(text("MacBook"));
        Allure.step("11. Удалить MacBook");
        shoppingCartPage.removeProduct.click();
    }

    @Test
    public void wishlistCheck() {
        openMainPage();
        generalUtils.loginIn("hjaawafsdsah@gmail.com", "drty");
        Allure.step("1. Нажать Wish List");
        generalBtnList.wishListBtn.click();
        Allure.step("2. Проверить что пуст");
        wishListPage.emptyWishList.shouldHave(text("Your wish list is empty."));
        Allure.step("3. Нажать Continue");
        wishListPage.continueBtn.click();
        Allure.step("4. Нажать Opencart");
        generalBtnList.openCartLogoBtn.click();
        Allure.step("5. Нажать на Iphone");
        homePage.iPhoneBtn.click();
        Allure.step("6. Нажать Add to Wishlist(иконка сердечка)");
        productPage.addToWishListBtn.click();
        Allure.step("7. Убрать оповещение");
        generalBtnList.alertAddTodWishList.click();
        Allure.step("8. Нажать Wish List");
        generalBtnList.wishListBtn.click();
        Allure.step("9. Проверить наличие iPhone в Wish List'е");
        wishListPage.iphoneInWishList.shouldHave(text("iPhone"));
        Allure.step("10. Удалить iPhone");
        wishListPage.removeProduct.click();
    }

    @Test
    public void desktopsCheck() {
        openMainPage();
        Allure.step("1. Навестись на Desktops");
        generalBtnList.desktopsBtn.hover();
        Allure.step("2. Проверить выдвижение меню");
        generalBtnList.desktopsDropDownMenu.should(visible);
        Allure.step("3. Убрать курсор с Desktops");
        generalBtnList.openCartLogoBtn.hover();
        Allure.step("4. Проверить что выпадающее меню пропало");
        generalBtnList.desktopsDropDownMenu.shouldNot(visible);
        Allure.step("6. Нажать на Desktops");
        generalBtnList.desktopsBtn.click();
        Allure.step("7. Убрать курсор с Desktops");
        generalBtnList.openCartLogoBtn.hover();
        Allure.step("8. Проверить что выпадающее меню осталось");
        generalBtnList.desktopsDropDownMenu.should(visible);
        Allure.step("9. Нажать Show all Desktops");
        generalBtnList.showAllDesktopsBtn.click();
    }

    @Test
    public void homeCheck() {
        openMainPage();
        Allure.step("1. Проверить наличие лого OpenCart");
        generalBtnList.openCartLogoBtn.should(visible);
        Allure.step("2. Нажать на OpenCart");
        generalBtnList.openCartLogoBtn.click();
        Allure.step("4. Проверить наличие кнопок в menubar", () -> {
            generalBtnList.narbarMenu.should(visible);
            Allure.step("4.1 Проверить наличие DeskTops");
            generalBtnList.desktopsBtn.should(visible);
            Allure.step("4.2 Проверить наличие Laptops & Notebooks");
            generalBtnList.laptopsAndNotebooksBtn.should(visible);
            Allure.step("4.3 Проверить наличие Components");
            generalBtnList.componentsBtn.should(visible);
            Allure.step("4.4 Проверить наличие Tablets");
            generalBtnList.tabletsBtn.should(visible);
            Allure.step("4.5 Проверить наличие Software");
            generalBtnList.softwareBtn.should(visible);
            Allure.step("4.6 Проверить наличие Phones & PDAs");
            generalBtnList.phonesAndPDAsBtn.should(visible);
            Allure.step("4.7 Проверить наличие Cameras");
            generalBtnList.camerasBtn.should(visible);
            Allure.step("4.8 Проверить наличие MP3 Players");
            generalBtnList.mp3PlayersBtn.should(visible);
        });
        Allure.step("5. Проверить наличие двух товаров на главной");
        homePage.imgInHomePageNumber1.should(visible);
        homePage.imgInHomePageNumber2.should(visible);
        Allure.step("6. Проверить наличие товаров в Featured", () -> {
            Allure.step("6.1 Наличие MacBook");
            homePage.macBookBtn.should(visible);
            Allure.step("6.2 Наличие IPhone");
            homePage.iPhoneBtn.should(visible);
            Allure.step("6.3 Наличие Apple Cinema 30");
            homePage.appleCinema30.should(visible);
            Allure.step("6.4 Наличие Canon EOS 5D");
            homePage.canonEOS5D.should(visible);
        });
        Allure.step("7. Проверить наличие списка брендов");
        homePage.carouselWithBrands.should(visible);
    }
}
