package tests.admin;

import io.qameta.allure.Description;
import models.User;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import webdriver.BaseTest;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LoginTest extends BaseTest  {

    User admin = new User(adminLogin, adminPassword);

    @Test(description = "Тест логина под админом")
    @Description(value = "Тест логина под админом")
    public void loginTest() {

        step("Открытие страницы логина");
        open("/admin");

        step("Проверка отображения формы логина");
        $(byText("Please enter your login details.")).shouldHave(text("Please enter your login details."));
        $(byText("Username")).shouldHave(text("Username"));
        $(byText("Password")).shouldHave(text("Password"));
        $(byText("Forgotten Password")).shouldHave(text("Forgotten Password"));
        $(byText("Login")).shouldHave(text("Login"));

        step("Заполнение формы");
        $(By.name("username")).setValue(admin.getLogin());
        $(By.name("password")).setValue(admin.getPassword());

        step("Нажатие на кнопку \"Login\"");
        $(byText("Login")).click();

        step("Проверка успешного логина");
        $("div.container-fluid h1").shouldHave(text("Dashboard"));
        $("#navigation").shouldHave(text("Navigation"));
    }
}
