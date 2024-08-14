package utils;

import forms.AccountCreatedPage;
import forms.GeneralBtnList;
import forms.LoginPage;
import forms.RegisterPage;
import models.User;

public class GeneralUtils {
    private final LoginPage loginPage = new LoginPage();
    private final GeneralBtnList generalBtnList = new GeneralBtnList();
    private final RegisterPage registerPage = new RegisterPage();
    private final AccountCreatedPage accountCreatedPage = new AccountCreatedPage();

    public void loginIn(String email, String password) {
        generalBtnList.myAccountBtn.click();
        generalBtnList.loginBtn.click();
        registerPage.emailField.sendKeys(email);
        registerPage.passwordField.sendKeys(password);
        loginPage.loginConfirmBtn.click();
        generalBtnList.openCartLogoBtn.click();
    }

    public void registerIn(User user) {
        generalBtnList.myAccountBtn.click();
        generalBtnList.registerBtn.click();
        registerPage.firstNameField.sendKeys(user.getFirstname());
        registerPage.lastNameField.sendKeys(user.getLastname());
        registerPage.emailField.sendKeys(user.getEmail());
        registerPage.passwordField.sendKeys(user.getPassword());
        registerPage.checkPrivacyPolicy.click();
        registerPage.continueRPBtn.click();
        accountCreatedPage.continueBtn.click();
    }
}
