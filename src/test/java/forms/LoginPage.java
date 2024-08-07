package forms;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {

    public SelenideElement
            loginConfirmBtn = $x("//div[@class='text-end']/button[@type='submit']");
}
