package forms.admin;

import models.Category;

import static com.codeborne.selenide.Selenide.$;

public class UpdateCategoryForm extends CreateCategoryForm {

    public void fillCreateForm(Category category) {
        $("#input-name1").setValue(category.getName());
        $("#input-meta-title1").setValue(category.getMetaTagTitle());
        $("div.note-editable").setValue(category.getDescription());
    }
}
