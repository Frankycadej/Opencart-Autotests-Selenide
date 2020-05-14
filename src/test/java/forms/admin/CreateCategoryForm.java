package forms.admin;

import models.Category;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CreateCategoryForm {

    public void fillCreateForm(Category category) {
        $("#input-name1").setValue(category.getName());
        $("#input-meta-title1").setValue(category.getMetaTagTitle());
    }

    public void saveCreateForm() {
        $(By.xpath("//button[@data-original-title=\"Save\"]")).click();
    }
}
