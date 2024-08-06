package forms;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class RegisterPage {

    public SelenideElement
            firstNameField = $x("First Name"),
            lastNameField = $x("Last Name"),
            emailField = $x("E-Mail"),
            passwordField = $x("Password"),
            checkPrivacyPolicy = $x("Privacy Policy"),
            continueRPBtn = $x("Continue");
}
