package forms;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class AccountCreatedPage {

    public SelenideElement continueBtn = $x("//div[@class='text-end']/a");
}
