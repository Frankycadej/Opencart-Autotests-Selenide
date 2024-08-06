package forms;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class HomePage {

    public final SelenideElement
            myAccountBtn = $(byText("My Account")), //span[contains(., 'My Account')]
            loginBtn = $(byText("Login")),
//            loginBtn = $x(""),
            macBookBtn = $x("//a[contains(.,'MacBook')]"),
            iPhoneBtn = $x("//a[contains(.,'iPhone')]");

    public SelenideElement getCategoryBtn(String name) {
        return $(byText(name));
    }

}
