package steps;

import com.codeborne.selenide.Condition;
import forms.HomePage;
import io.qameta.allure.Step;

public class HomePageSteps {

    private HomePage homePage = new HomePage();

    public HomePageSteps gotoUserLoginPage() {
        homePage.myAccountBtn.click();
        homePage.loginBtn.click();
        return this;
    }

    @Step("Check that category is visible")
    public void checkThatCategoryIsVisible(String title) {
        homePage.getCategoryBtn(title).shouldBe(Condition.visible);
    }

    @Step("Check that category is not visible")
    public void checkThatCategoryIsNotVisible(String title) {
        homePage.getCategoryBtn(title).shouldNotBe(Condition.visible);
    }
}
