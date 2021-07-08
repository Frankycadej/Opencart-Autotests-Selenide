package steps.admin;

import forms.admin.CreateCategoryForm;
import io.qameta.allure.Step;
import models.Category;

public class CreateCategoryFormSteps {

    private final CreateCategoryForm createCategoryForm = new CreateCategoryForm();

    @Step("Save form")
    public CreateCategoryFormSteps saveCreateForm() {
        createCategoryForm.saveButton.click();
        return this;
    }

    @Step("Fill form")
    public CreateCategoryFormSteps fillCreateForm(Category category) {
        createCategoryForm.nameField.setValue(category.getName());
        createCategoryForm.titleField.setValue(category.getMetaTagTitle());
        createCategoryForm.noteField.setValue(category.getDescription());
        if (category.isTop()) {
            gotoTabByTitle("Data");
            createCategoryForm.topCheckbox.click();
        }
        return this;
    }

    @Step("Go to tab by title")
    public void gotoTabByTitle(String title) {
        createCategoryForm.getTabByTitle(title).click();
    }
}
