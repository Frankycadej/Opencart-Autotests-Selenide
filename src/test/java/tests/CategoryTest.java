package tests;

import com.codeborne.selenide.Condition;
import forms.admin.*;
import io.qameta.allure.Description;
import models.Category;
import models.User;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import webdriver.BaseTest;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CategoryTest extends BaseTest {

    User admin;
    Category category;
    Category categoryAfterUpdate;

    @BeforeTest
    @Parameters({"titleCategory", "metaTagTitleCategory", "descriptionCategory", "titleCategoryAfterUpdate",
            "metaTagTitleCategoryAfterUpdate", "descriptionCategoryAfterUpdate"})
    public void precondition(String titleCategory, String metaTagTitleCategory, String descriptionCategory,
                             String titleCategoryAfterUpdate, String metaTagTitleCategoryAfterUpdate,
                             String descriptionCategoryAfterUpdate) {
        category = new Category(titleCategory, metaTagTitleCategory, descriptionCategory, true);
        categoryAfterUpdate = new Category(titleCategoryAfterUpdate, metaTagTitleCategoryAfterUpdate,
                descriptionCategoryAfterUpdate, true);
        admin = new User(adminLogin, adminPassword);
    }

    @Test(description = "Создание категории")
    @Description(value = "Создание категории")
    public void createGroupTest() {

        open("https://opencart.nakoskin.ru/admin");

        logStep(1, "Login as admin");
        AdminLoginForm adminLoginForm = new AdminLoginForm();
        adminLoginForm.login(admin);

        logStep(2, "Navigate to categories page");
        NavigationMenuForm navigationMenuForm = new NavigationMenuForm();
        navigationMenuForm.gotoPage("Catalog", "Categories");

        logStep(3, "Open create category form");
        CategoriesForm categoriesForm = new CategoriesForm();
        categoriesForm.gotoCreateForm();

        logStep(3, "Fill form");
        CreateCategoryForm createCategoryForm = new CreateCategoryForm();
        createCategoryForm.fillCreateForm(category);

        logStep(4, "Save form");
        createCategoryForm.saveCreateForm();

    }

    @Test(description = "Проверка отображения категории", dependsOnMethods = "createGroupTest")
    @Description(value = "Проверка отображения категории")
    public void readCategoryTest() {
        open("https://opencart.nakoskin.ru/");

        logStep(1, "Check that category is visible");
        $(byText(category.getName())).shouldBe(Condition.visible);
    }

    @Test(description = "Обновление категории", dependsOnMethods = "readCategoryTest")
    @Description(value = "Обновление категории")
    public void updateCategoryTest() {

        open("https://opencart.nakoskin.ru/admin");

        logStep(1, "Login as admin");
        AdminLoginForm adminLoginForm = new AdminLoginForm();
        adminLoginForm.login(admin);

        logStep(2, "Navigate to categories page");
        NavigationMenuForm navigationMenuForm = new NavigationMenuForm();
        navigationMenuForm.gotoPage("Catalog", "Categories");

        logStep(3, "Find and mark category's checkbox");
        CategoriesForm categoriesForm = new CategoriesForm();
        categoriesForm.findCategoryAndClickOnUpdateBtn(category);

        logStep(3, "Fill form");
        UpdateCategoryForm updateCategoryForm = new UpdateCategoryForm();
        updateCategoryForm.fillCreateForm(categoryAfterUpdate);

        logStep(4, "Save form");
        updateCategoryForm.saveCreateForm();
    }

    @Test(description = "Проверка отображения категории после обновления", dependsOnMethods = "updateCategoryTest")
    @Description(value = "Проверка отображения категории после обновления")
    public void readCategoryAfterUpdateTest() {
        open("https://opencart.nakoskin.ru/");

        logStep(1, "Check that category is visible");
        $(byText(categoryAfterUpdate.getName())).shouldBe(Condition.visible);
    }

    @Test(description = "Удаление категории", dependsOnMethods = "readCategoryAfterUpdateTest", alwaysRun = true)
    @Description(value = "Удаление категории")
    public void deleteCategory() {

        open("https://opencart.nakoskin.ru/admin");

        logStep(1, "Login as admin");
        AdminLoginForm adminLoginForm = new AdminLoginForm();
        adminLoginForm.login(admin);

        logStep(2, "Navigate to categories page");
        NavigationMenuForm navigationMenuForm = new NavigationMenuForm();
        navigationMenuForm.gotoPage("Catalog", "Categories");

        logStep(3, "Find category in table and mark it");
        CategoriesForm categoriesForm = new CategoriesForm();
        categoriesForm.findAndMarkCategory(categoryAfterUpdate);

        logStep(5, "Click on delete button");
        categoriesForm.clickOnDeleteBtn();

    }

    @Test(description = "Проверка отображения категории после удаления", dependsOnMethods = "deleteCategory")
    @Description(value = "Проверка отображения категории после удаления")
    public void readCategoryAfterDeleteTest() {
        open("https://opencart.nakoskin.ru/");

        $(byText(categoryAfterUpdate.getName())).exists();
    }
}
