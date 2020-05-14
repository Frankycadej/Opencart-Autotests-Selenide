package forms.admin;

import models.Category;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CreateCategoryForm {

    public void fillCreateForm(Category category) {
        $("#input-name1").setValue(category.getName());
        $("#input-meta-title1").setValue(category.getMetaTagTitle());
        $("div.note-editable").setValue(category.getDescription());
        if (category.isTop()) {
            gotoTab("Data");
            $("#input-top").click();
        }
    }

    public void gotoTab(String title) {
        $(byText(title)).click();
    }

    public void saveCreateForm() {
        $(By.xpath("//button[@data-original-title=\"Save\"]")).click();
    }
}
