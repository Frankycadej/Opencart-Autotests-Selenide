package forms.admin;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class NavigationMenuForm {

    public void gotoPage(String section, String menuItem) {
        $(By.xpath("//a[contains(., '" + section + "')]")).click();
        $(By.xpath("//a[contains(., '" + menuItem + "')]")).click();
    }
}
