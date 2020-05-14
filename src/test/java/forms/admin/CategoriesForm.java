package forms.admin;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CategoriesForm {

    public void gotoCreateForm() {
        $(By.xpath("//a[@data-original-title=\"Add New\"]")).click();
    }

}
