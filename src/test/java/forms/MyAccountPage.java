package forms;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MyAccountPage {

    public SelenideElement myAccountText = $x("//div[@id='content']/h2");
}
