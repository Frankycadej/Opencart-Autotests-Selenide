package utils;

import forms.GeneralBtnList;
import forms.LoginPage;
import forms.RegisterPage;

public class GeneralUtils {
    private final LoginPage loginPage = new LoginPage();
    private final GeneralBtnList generalBtnList = new GeneralBtnList();
    private final RegisterPage registerPage = new RegisterPage();

    public void loginIn(String email, String password) {
        generalBtnList.myAccountBtn.click();
        generalBtnList.loginBtn.click();
        registerPage.emailField.sendKeys(email);
        registerPage.passwordField.sendKeys(password);
        loginPage.loginConfirmBtn.click();
        generalBtnList.openCartLogoBtn.click();
    }
}
