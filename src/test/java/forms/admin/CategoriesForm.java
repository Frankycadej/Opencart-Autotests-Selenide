package forms.admin;

import com.codeborne.selenide.Condition;
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

    public void findAndMarkCategory(String title) {
        int countPage = 1;
        if ($(byText(title)).exists()) {
            $(By.xpath("//tr[contains(., '" + title + "')]//input[@name=\"selected[]\"]")).click();
        } else if ($(By.xpath("//ul[@class=\"pagination\"]//span[contains(., '" + ++countPage + "')]")).exists()) {
            $(By.xpath("//ul[@class=\"pagination\"]//span[contains(., '" + countPage + "')]")).click();
        } else {
            System.out.println("Не найдена категория");
        }
    }

}
