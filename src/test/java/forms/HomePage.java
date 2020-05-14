package forms;

import webdriver.BaseForm;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class HomePage extends BaseForm {

    public void gotoUserLoginPage() {
        $(byText("My Account")).click();
        $(byText("Login")).click();
    }
}
