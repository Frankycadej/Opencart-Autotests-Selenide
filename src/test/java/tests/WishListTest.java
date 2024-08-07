package tests;

import forms.*;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import steps.HomePageSteps;
import steps.admin.*;
import webdriver.NewTest;

import static com.codeborne.selenide.Condition.text;

@Feature("WishList Test")
public class WishListTest extends NewTest {
    private final AdminLoginFormSteps adminLoginFormSteps = new AdminLoginFormSteps();
    private final NavigationMenuFormSteps navigationMenuFormSteps = new NavigationMenuFormSteps();
    private final CategoriesFormSteps categoriesFormSteps = new CategoriesFormSteps();
    private final CreateCategoryFormSteps createCategoryFormSteps = new CreateCategoryFormSteps();
    private final UpdateCategoryFormSteps updateCategoryFormSteps = new UpdateCategoryFormSteps();
    private final HomePageSteps homePageSteps = new HomePageSteps();
    private final AccountCreatedPage accountCreatedPage = new AccountCreatedPage();
    private final GeneralBtnList generalBtnList = new GeneralBtnList();
    private final ProductPage productPage = new ProductPage();
    private final RegisterPage registerPage = new RegisterPage();
    private final ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    private final WishListPage wishListPage = new WishListPage();
    private final MyAccountPage myAccountPage = new MyAccountPage();
    private final HomePage homePage = new HomePage();
    private final LoginPage loginPage = new LoginPage();

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
            registerPage.emailField.sendKeys("hjaawafsdsah@gmail.com"); //RandomStringUtils.random(3)+
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
        shoppingCartPage.emptyShoppingCart.shouldHave();
        Allure.step("3. Нажать Continue");
        shoppingCartPage.continueSCPBtn.click();
        Allure.step("4. Нажать на MacBook");
        homePage.macBookBtn.click();
        Allure.step("5. Нажать Add to Cart");
        productPage.addToCartBtn.click();
        Allure.step("6. Нажать на 1 item(s)");
        generalBtnList.itemsCostBtn.click();
        Allure.step("7. Проверить выпадающие меню");
        generalBtnList.dropDownMenuItems.shouldHave();
        Allure.step("8. Проверить наличие MacBook в n item(s)");
        generalBtnList.macbookInItemsMenu.shouldHave();
        Allure.step("9. Нажать View Cart");
        generalBtnList.viewCartBtn.click();
        Allure.step("10. Проверить наличие MacBook в корзине");
        shoppingCartPage.macbookInShoppingCart.shouldHave();
        Allure.step("11. Нажать Checkout");
        shoppingCartPage.checkoutSCPBtn.click();
        System.out.println("42");
    }

    @Test
    public void wishlistCheck() { ////h1[contains(., 'My Wishlist')]
        openMainPage();
        generalBtnList.myAccountBtn.click();
        generalBtnList.loginBtn.click();
        registerPage.emailField.sendKeys("hjaawafsdsah@gmail.com");
        registerPage.passwordField.sendKeys("drty"); //TODO хочется вывести отдельно
        loginPage.loginConfirmBtn.click();
        generalBtnList.openCartLogoBtn.click();
        Allure.step("1. Нажать Wish List");
        generalBtnList.wishListBtn.click();
        Allure.step("2. Проверить что пуст");
        wishListPage.emptyWishList.shouldHave();
        Allure.step("3. Нажать Continue"); //почти бесполезно
        wishListPage.continueBtn.click();
        Allure.step("4. Нажать Opencart");
        generalBtnList.openCartLogoBtn.click();
        Allure.step("5. Нажать на Iphone");
        homePage.iPhoneBtn.click();
        Allure.step("6. Нажать Add to Wishlist(иконка сердечка)");
        productPage.addToWishListBtn.click();
//        Allure.step("7. Проверить что цифра в скобочках у Wish List'a поменялась");//она кстати не меняется
        Allure.step("8. Нажать Wish List");
        generalBtnList.wishListBtn.click();
        Allure.step("9. Проверить наличие iPhone в Wish List'е"); //
        wishListPage.iphoneInWishList.shouldHave();
    }

    @Test
    public void desktopsCheck() {
        openMainPage();
        Allure.step("1. Навестись на Desktops");
        generalBtnList.desktopsBtn.hover();
        Allure.step("2. Проверить выдвижение меню");
        generalBtnList.desktopsDropDownMenu.shouldHave();
        Allure.step("3. Убрать курсор с Desktops");
        generalBtnList.openCartLogoBtn.hover(); //TODO
        Allure.step("4. Проверить что выпадающее меню пропало");
        generalBtnList.desktopsDropDownMenu.shouldNotHave();
//        Allure.step("5. Навестись на Desktops"); //это ведь не нужно
//        generalBtnList.desktopsBtn.hover();
        Allure.step("6. Нажать на Desktops");
        generalBtnList.desktopsBtn.click();
        Allure.step("7. Убрать курсор с Desktops");
        generalBtnList.openCartLogoBtn.hover();
        Allure.step("8. Проверить что выпадающее меню осталось");
        generalBtnList.desktopsDropDownMenu.shouldHave();
        Allure.step("9. Нажать Show all Desktops");
        generalBtnList.showAllDesktopsBtn.click();
    }

    @Test
    public void homeCheck() {
        openMainPage();
        Allure.step("1. Проверить наличие лого OpenCart");
        generalBtnList.openCartLogoBtn.shouldHave();
        Allure.step("2. Нажать на OpenCart");
        generalBtnList.openCartLogoBtn.click();
        Allure.step("4. Проверить наличие кнопок в menubar", () -> {
            generalBtnList.narbarMenu.shouldHave();
            Allure.step("4.1 Проверить наличие DeskTops"); //
            generalBtnList.desktopsBtn.shouldHave();
            generalBtnList.desktopsBtn.hover();
            Allure.step("4.2 Проверить наличие Laptops & Notebooks"); //
            generalBtnList.laptopsAndNotebooksBtn.shouldHave();
            generalBtnList.laptopsAndNotebooksBtn.hover();
            Allure.step("4.3 Проверить наличие Components"); //
            generalBtnList.componentsBtn.shouldHave();
            generalBtnList.componentsBtn.hover();
            Allure.step("4.4 Проверить наличие Tablets"); //
            generalBtnList.tabletsBtn.shouldHave();
            generalBtnList.tabletsBtn.hover();
            Allure.step("4.5 Проверить наличие Software"); //
            generalBtnList.softwareBtn.shouldHave();
            generalBtnList.softwareBtn.hover();
            Allure.step("4.6 Проверить наличие Phones & PDAs"); //
            generalBtnList.phonesAndPDAsBtn.shouldHave();
            generalBtnList.phonesAndPDAsBtn.hover();
            Allure.step("4.7 Проверить наличие Cameras"); //
            generalBtnList.camerasBtn.shouldHave();
            generalBtnList.camerasBtn.hover();
            Allure.step("4.8 Проверить наличие MP3 Players"); //
            generalBtnList.mp3PlayersBtn.shouldHave();
            generalBtnList.mp3PlayersBtn.hover(); //
                });
        generalBtnList.openCartLogoBtn.hover();
        Allure.step("5. Проверить наличие двух товаров на главной");
        homePage.imgInHomePageNumber1.shouldHave();
        homePage.imgInHomePageNumber2.shouldHave();
        Allure.step("6. Проверить наличие товаров в Featured", () -> {
            Allure.step("6.1 Наличие MacBook"); //
            homePage.macBookBtn.shouldHave();
            homePage.macBookBtn.hover();
            Allure.step("6.2 Наличие IPhone"); //
            homePage.iPhoneBtn.shouldHave();
            homePage.iPhoneBtn.hover();
            Allure.step("6.3 Наличие Apple Cinema 30"); //
            homePage.appleCinema30.shouldHave();
            homePage.appleCinema30.hover();
            Allure.step("6.4 Наличие Canon EOS 5D"); //
            homePage.canonEOS5D.shouldHave();
            homePage.canonEOS5D.hover();
                });
        Allure.step("7. Проверить наличие списка брендов");
        homePage.carouselWithBrands.shouldHave();
    }
}
