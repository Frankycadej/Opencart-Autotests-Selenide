package tests;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

@Feature("WishList Test")
public class WishListTest {

    @Test
    public void accountRegister() {
        Allure.step("1. Нажать на My Account");
        Allure.step("2. Нажать на Register");
        Allure.step("3. Создать аккаунт", () -> {
            Allure.step("3.1 Ввести значение First Name");
            Allure.step("3.2 Ввести значение Last Name");
            Allure.step("3.3 Ввести значение E-Mail");
            Allure.step("3.4 Ввести значение Password");
            Allure.step("3.5 Отметить чекбокс Agree to the Privacy Policy");
            Allure.step("3.6 Нажать Continue");
        });
        Allure.step("4. На новой странице нажать Continue"); //TODO сделать отдельную страницу
        Allure.step("5. Проверить что загрузилась страница My Account");
    }

    @Test
    public void shoppingCart() {
        Allure.step("1. Нажать Shopping Cart");
        Allure.step("2. Проверить что он пуст");
        Allure.step("3. Нажать Continue");
        Allure.step("4. Нажать на MacBook");
        Allure.step("5. Нажать Add to Cart");
        Allure.step("6. Нажать на 1 item(s)");
        Allure.step("7. Проверить выпадающие меню");
        Allure.step("8. Проверить наличие MacBook");
        Allure.step("9. Нажать View Cart");
        Allure.step("10. Проверить наличие MacBook");
        Allure.step("11. Нажать Checkout");
    }

    @Test
    public void wishlistCheck() { ////h1[contains(., 'My Wishlist')]
        Allure.step("1. Нажать Wish List");
        Allure.step("2. Проверить что пуст");
        Allure.step("3. Нажать Continue");
        Allure.step("4. Нажать Opencart");
        Allure.step("5. Нажать на Iphone");
        Allure.step("6. Нажать Add to Wishlist(иконка сердечка)");
        Allure.step("7. Проверить что цифра в скобочках у Wish List'a поменялась"); //она кстати не меняется
        Allure.step("8. Нажать Wish List");
        Allure.step("9. Проверить наличие товара в Wish List'е");
    }

    @Test
    public void desktopsCheck() {
        Allure.step("1. Навестись на Desktops");
        Allure.step("2. Проверить выдвижение меню");
        Allure.step("3. Убрать курсор с Desktops");
        Allure.step("4. Проверить что выпадающее меню пропало");
        Allure.step("5. Навестись на Desktops");
        Allure.step("6. Нажать на Desktops");
        Allure.step("7. Убрать курсор с Desktops");
        Allure.step("8. Проверить что выпадающее меню осталось");
        Allure.step("9. Нажать Show all Desktops");
    }

    @Test
    public void homeCheck() {
        Allure.step("1. Проверить наличие лого OpenCart");
        Allure.step("2. Нажать на OpenCart"); //
        Allure.step("3. Проверить загрузку страницы home");
        Allure.step("4. Проверить наличие кнопок в menubar", () -> { //
            Allure.step("4.1 Проверить наличие DeskTops"); //
            Allure.step("4.2 Проверить наличие Laptops & Notebooks"); //
            Allure.step("4.3 Проверить наличие Components"); //
            Allure.step("4.4 Проверить наличие Tablets"); //
            Allure.step("4.5 Проверить наличие Software"); //
            Allure.step("4.6 Проверить наличие Phones & PDAs"); //
            Allure.step("4.7 Проверить наличие Cameras"); //
            Allure.step("4.8 Проверить наличие MP3 Players"); //
                });
        Allure.step("5. Проверить наличие двух товаров на главной");
        Allure.step("6. Проверить наличие товаров в Featured", () -> {
            Allure.step("6.1 Наличие MacBook"); //
            Allure.step("6.2 Наличие IPhone"); //
            Allure.step("6.3 Наличие Apple Cinema 30"); //
            Allure.step("6.4 Наличие Canon EOS 5D"); //
        });
        Allure.step("7. Проверить наличие списка брендов");
    }
}
