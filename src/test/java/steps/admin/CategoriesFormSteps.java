package steps.admin;

import com.codeborne.selenide.Selenide;
import forms.admin.CategoriesForm;
import io.qameta.allure.Step;
import models.Category;

public class CategoriesFormSteps {

    private final CategoriesForm categoriesForm = new CategoriesForm();

    @Step("Open create category form")
    public void gotoCreateForm() {
        categoriesForm.addNewBtn.click();
    }

    @Step("Click on delete button")
    public void clickOnDeleteBtn() {
        categoriesForm.deleteBtn.click();
        Selenide.confirm();
    }

    @Step("Find and mark category's checkbox")
    public CategoriesFormSteps findCategoryAndClickOnUpdateBtn(Category category) {
        int countPage = 1;
        boolean exit = false;
        while(!exit) {
            if (categoriesForm.getCellByName(category.getName()).exists()) {
                categoriesForm.getCellByName(category.getName()).click();
                break;
            }
            countPage++;
            if (categoriesForm.getPagesBtnByCounter(countPage).exists()) {
                categoriesForm.getPagesBtnByCounter(countPage).click();
            } else {
                exit = true;
            }
        }
        return this;
    }

    @Step("Find category in table and mark it")
    public CategoriesFormSteps findAndMarkCategory(Category category) {
        int countPage = 1;
        boolean exit = false;
        while(!exit) {
            if (categoriesForm.getCellByName(category.getName()).exists()) {
                categoriesForm.getCellCheckboxByName(category.getName()).click();
                break;
            }
            countPage++;
            if (categoriesForm.getPagesBtnByCounter(countPage).exists()) {
                categoriesForm.getPagesBtnByCounter(countPage).click();
            } else {
                exit = true;
            }
        }
        return this;
    }
}
