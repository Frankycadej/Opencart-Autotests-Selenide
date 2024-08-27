package forms.admin;

import com.codeborne.selenide.SelenideElement;
import models.User;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class AdminLoginForm {

    public SelenideElement usernameField = $(By.name("username")),
            passwordField = $(By.name("password")),
            loginBtn = $(byText("Login"));

}
