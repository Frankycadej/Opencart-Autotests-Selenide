package steps.admin;

import forms.admin.UpdateCategoryForm;
import io.qameta.allure.Step;
import models.Category;

public class UpdateCategoryFormSteps extends CreateCategoryFormSteps {

    private final UpdateCategoryForm updateCategoryForm = new UpdateCategoryForm();

    @Step("Fill form")
    public UpdateCategoryFormSteps fillCreateForm(Category category) {
        updateCategoryForm.nameField.setValue(category.getName());
        updateCategoryForm.titleField.setValue(category.getMetaTagTitle());
        updateCategoryForm.noteField.setValue(category.getDescription());
        return this;
    }
}
