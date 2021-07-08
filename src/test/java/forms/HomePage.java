package forms;

import com.codeborne.selenide.SelenideElement;
import webdriver.BaseForm;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class HomePage extends BaseForm {

    public final SelenideElement myAccountBtn = $(byText("My Account")),
            loginBtn = $(byText("Login"));

    public SelenideElement getCategoryBtn(String name) {
        return $(byText(name));
    }
}
