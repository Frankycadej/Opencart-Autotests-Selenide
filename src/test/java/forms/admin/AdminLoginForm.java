package forms.admin;

import models.User;
import org.openqa.selenium.By;
import webdriver.BaseForm;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class AdminLoginForm extends BaseForm {

    public void login(User user) {
        $(By.name("username")).setValue(user.getLogin());
        $(By.name("password")).setValue(user.getPassword());
        $(byText("Login")).click();
    }

}
