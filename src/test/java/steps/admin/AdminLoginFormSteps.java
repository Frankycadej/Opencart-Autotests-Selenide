package steps.admin;

import forms.admin.AdminLoginForm;
import io.qameta.allure.Step;
import models.User;

public class AdminLoginFormSteps {

    private final AdminLoginForm adminLoginForm = new AdminLoginForm();

    @Step("Login as {user.getLogin()}")
    public AdminLoginFormSteps login(User user) {
        adminLoginForm.usernameField.setValue(user.getLogin());
        adminLoginForm.passwordField.setValue(user.getPassword());
        adminLoginForm.loginBtn.click();
        return this;
    }
}
