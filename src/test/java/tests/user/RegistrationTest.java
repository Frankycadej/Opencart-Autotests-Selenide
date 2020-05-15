package tests.user;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import webdriver.BaseTest;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationTest extends BaseTest {

    @Test(description = "Регистрация пользователя")
    @Description(value = "Регистрация пользователя")
    public void registrationTest() {

        open("/");

        // Переход на страницу регистрации
        $(byText("My Account")).click();
        $(byText("Register")).click();



    }
}
