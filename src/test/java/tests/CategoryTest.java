package tests;

import com.codeborne.selenide.Condition;
import forms.admin.*;
import models.*;
import org.testng.annotations.Test;
import webdriver.BaseTest;

import io.qameta.allure.*;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class CategoryTest extends BaseTest {

    private final String login = "admin";
    private final String password = "GdfkvkrhjDH";

    User admin = new User(login, password);

    private final String titleCategory = "Test category";
    private final String metaTagTitleCategory = "TestMetaTagTitle";
    private final String descriptionCategory = "Test Description";
    private final boolean topCategory = true;

    Category category = new Category(titleCategory, metaTagTitleCategory, descriptionCategory, topCategory);

    private final String titleCategoryAfterUpdate = "Test category after update";
    private final String metaTagTitleCategoryAfterUpdate = "TestMetaTagTitle after update";
    private final String descriptionCategoryAfterUpdate = "Test Description after update";

    Category categoryAfterUpdate = new Category(titleCategoryAfterUpdate, metaTagTitleCategoryAfterUpdate,
            descriptionCategoryAfterUpdate, topCategory);

    @Test(description = "Создание категории")
    @Description(value = "Создание категории")
    public void createGroupTest() {

        open("/admin");

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
        open("/");

        logStep(1, "Check that category is visible");
        $(byText(category.getName())).shouldBe(Condition.visible);
    }

    @Test(description = "Обновление категории", dependsOnMethods = "readCategoryTest")
    @Description(value = "Обновление категории")
    public void updateCategoryTest() {

        open("/admin");

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
        createCategoryForm.fillCreateForm(categoryAfterUpdate);

        logStep(4, "Save form");
        createCategoryForm.saveCreateForm();

    }

    @Test(description = "Проверка отображения категории после обновления", dependsOnMethods = "updateCategoryTest")
    @Description(value = "Проверка отображения категории после обновления")
    public void readCategoryAfterUpdateTest() {
        open("/");

        logStep(1, "Check that category is visible");
        $(byText(categoryAfterUpdate.getName())).shouldBe(Condition.visible);
    }

    @Test(description = "Удаление категории", dependsOnMethods = "readCategoryAfterUpdateTest", alwaysRun = true)
    @Description(value = "Удаление категории")
    public void deleteCategory() {

        open("/admin");

        logStep(1, "Login as admin");
        AdminLoginForm adminLoginForm = new AdminLoginForm();
        adminLoginForm.login(admin);

        logStep(2, "Navigate to categories page");
        NavigationMenuForm navigationMenuForm = new NavigationMenuForm();
        navigationMenuForm.gotoPage("Catalog", "Categories");

        logStep(3, "Find category in table and mark it");
        CategoriesForm categoriesForm = new CategoriesForm();
        categoriesForm.findAndMarkCategory(titleCategoryAfterUpdate);

        logStep(5, "Click on delete button");
        categoriesForm.clickOnDeleteBtn();
    }

    @Test(description = "Проверка отображения категории после удаления", dependsOnMethods = "deleteCategory")
    @Description(value = "Проверка отображения категории после удаления")
    public void readCategoryAfterDeleteTest() {
        open("/");
        $(byText(categoryAfterUpdate.getName())).shouldNotBe(Condition.visible);
    }
}
