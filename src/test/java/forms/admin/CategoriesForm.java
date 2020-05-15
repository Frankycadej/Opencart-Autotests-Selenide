package forms.admin;

import models.Category;
import org.openqa.selenium.By;
import webdriver.BaseForm;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CategoriesForm extends BaseForm {

    public void gotoCreateForm() {
        $(By.xpath("//a[@data-original-title=\"Add New\"]")).click();
    }

    public void clickOnDeleteBtn() {
        $(By.xpath("//button[@data-original-title=\"Delete\"]/i")).click();
        submitAlert();
    }

    public void findCategoryAndClickOnUpdateBtn(Category category) {
        int countPage = 1;
        boolean exit = false;
        while(!exit) {
            if ($(byText(category.getName())).exists()) {
                $(By.xpath("//tr[contains(., '" + category.getName() + "')]//a")).click();
                break;
            }
            countPage++;
            if ($(By.xpath("//ul[@class=\"pagination\"]//a[contains(., '" + countPage + "')]")).exists()) {
                $(By.xpath("//ul[@class=\"pagination\"]//a[contains(., '" + countPage + "')]")).click();
            } else {
                exit = true;
            }
        }
    }

    public void findAndMarkCategory(Category category) {
        int countPage = 1;
        boolean exit = false;
        while(!exit) {
            if ($(byText(category.getName())).exists()) {
                $(By.xpath("//tr[contains(., '" + category.getName() + "')]//input[@name=\"selected[]\"]")).click();
                break;
            }
            countPage++;
            if ($(By.xpath("//ul[@class=\"pagination\"]//a[contains(., '" + countPage + "')]")).exists()) {
                $(By.xpath("//ul[@class=\"pagination\"]//a[contains(., '" + countPage + "')]")).click();
            } else {
                exit = true;
            }
        }
    }
}
