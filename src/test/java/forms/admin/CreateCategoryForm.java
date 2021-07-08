package forms.admin;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CreateCategoryForm {

    public final SelenideElement nameField = $("#input-name1"),
            titleField = $("#input-meta-title1"),
            noteField = $("div.note-editable"),
            topCheckbox = $("#input-top"),
            saveButton = $x("//button[@data-original-title='Save']");

    public SelenideElement getTabByTitle(String title) {
        return $(byText(title));
    }
}
