package tests.user;

import forms.HomePage;
import models.*;
import org.testng.annotations.Test;
import webdriver.BaseTest;

import static com.codeborne.selenide.Selenide.*;

public class RegistrationTest extends BaseTest {

    @Test()
    public void registrationTest() {

        open("/");

        HomePage homePage = new HomePage();
        homePage.gotoUserLoginPage();


    }
}
