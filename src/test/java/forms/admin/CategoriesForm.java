package forms.admin;

import com.codeborne.selenide.SelenideElement;
import models.Category;
import org.openqa.selenium.By;
import webdriver.BaseForm;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CategoriesForm extends BaseForm {

    public final SelenideElement addNewBtn = $x("//a[@data-original-title='Add New']"),
            deleteBtn = $x("//button[@data-original-title='Delete']/i");

    public SelenideElement getCellByName(String name) {
        return $x("//tr[contains(., '" + name + "')]//a");
    }

    public SelenideElement getPagesBtnByCounter(int countPage) {
        return $x("//ul[@class='pagination']//a[contains(., '" + countPage + "')]");
    }

    public SelenideElement getCellCheckboxByName(String name) {
        return $(By.xpath("//tr[contains(., '" + name + "')]//input[@name='selected[]']"));
    }

    public void findCategoryAndClickOnUpdateBtn(Category category) {
        int countPage = 1;
        boolean exit = false;
        while(!exit) {
            if (getCellByName(category.getName()).exists()) {
                getCellByName(category.getName()).click();
                break;
            }
            countPage++;
            if (getPagesBtnByCounter(countPage).exists()) {
                getPagesBtnByCounter(countPage).click();
            } else {
                exit = true;
            }
        }
    }

    public void findAndMarkCategory(Category category) {
        int countPage = 1;
        boolean exit = false;
        while(!exit) {
            if (getCellByName(category.getName()).exists()) {
                getCellCheckboxByName(category.getName()).click();
                break;
            }
            countPage++;
            if (getPagesBtnByCounter(countPage).exists()) {
                getPagesBtnByCounter(countPage).click();
            } else {
                exit = true;
            }
        }
    }
}
