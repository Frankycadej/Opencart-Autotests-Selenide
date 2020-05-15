package forms.admin;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.By;
import webdriver.BaseForm;

import static com.codeborne.selenide.Selenide.$;

public class NavigationMenuForm extends BaseForm {

    public void gotoPage(String section, String menuItem) {
        $(By.xpath("//a[contains(., '" + section + "')]")).click();
        $(By.xpath("//a[contains(., '" + menuItem + "')]")).click();
    }
}
