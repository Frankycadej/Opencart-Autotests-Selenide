package forms;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class RegisterPage {

    public SelenideElement
            firstNameField = $x("//input[@id='input-firstname']"),
            lastNameField = $x("//input[@id='input-lastname']"),
            emailField = $x("//input[@id='input-email']"),
            passwordField = $x("//input[@id='input-password']"),
            checkPrivacyPolicy = $x("(//input[@class='form-check-input'])[2]"),
            continueRPBtn = $x("//button[@type='submit']");
}
