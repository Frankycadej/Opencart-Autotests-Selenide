package forms;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class HomePage {

    public final SelenideElement
            myAccountBtn = $(byText("My Account")), //span[contains(., 'My Account')]
            loginBtn = $(byText("Login")),
            macBookBtn = $x("//a[contains(.,'MacBook')]"),
            iPhoneBtn = $x("//a[contains(.,'iPhone')]"),
            appleCinema30 = $x("//h4/a[contains(@href,'apple-cinema')]"),
            canonEOS5D = $x("//h4/a[contains(@href,'canon')]"),
            carouselWithBrands = $x("//div[@id='carousel-banner-1']"),
            imgInHomePageNumber1 = $x("//img[@class='img-fluid' and contains(@src,'iPhone6')]"),
            imgInHomePageNumber2 = $x("//img[@class='img-fluid' and contains(@src,'Mac')]");

    public SelenideElement getCategoryBtn(String name) {
        return $(byText(name));
    }

}
