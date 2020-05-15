package tests.user;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import webdriver.BaseTest;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CommonViewTest extends BaseTest {

    @Test(description = "")
    @Description(value = "")
    public void commonViewTest() {

        open("/");

        $(byText("Your Store")).shouldHave(text("Your Store"));
        $("nav.navbar").exists();
        $("div.container").exists();
        $("#common-home").exists();
        $("footer").exists();
    }
}
