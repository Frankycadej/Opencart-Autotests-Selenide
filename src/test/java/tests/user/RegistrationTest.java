package tests.user;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
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

        // Заполнение форм
        $("#input-firstname").setValue("Test");
        $("#input-lastname").setValue("Test");
        $("#input-email").setValue("test@test.test");
        $("#input-telephone").setValue("+123456789");
        $("#input-password").setValue("password");
        $("#input-confirm").setValue("password");
        $(By.name("agree")).click();

        $(byText("Continue")).click();
    }
}
