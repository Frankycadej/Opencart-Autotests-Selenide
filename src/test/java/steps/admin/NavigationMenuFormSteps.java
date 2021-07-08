package steps.admin;

import forms.admin.NavigationMenuForm;
import io.qameta.allure.Step;

public class NavigationMenuFormSteps {

    private final NavigationMenuForm navigationMenuForm = new NavigationMenuForm();

    @Step("Go to {section} {menuItem}")
    public NavigationMenuFormSteps gotoPage(String section, String menuItem) {
        navigationMenuForm.getSectionBtn(section).click();
        navigationMenuForm.getMenuItemBtn(menuItem).click();
        return this;
    }
}
