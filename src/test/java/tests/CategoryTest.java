package tests;

import com.codeborne.selenide.Condition;
import forms.admin.*;
import models.*;
import org.testng.annotations.Test;
import webdriver.BaseTest;

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

    @Test(description = "Проверка создания группы")
    public void createGroupTest() {

        AdminLoginForm adminLoginForm = new AdminLoginForm();
        NavigationMenuForm navigationMenuForm = new NavigationMenuForm();
        CategoriesForm categoriesForm = new CategoriesForm();
        CreateCategoryForm createCategoryForm = new CreateCategoryForm();

        // Login
        open("/admin");
        adminLoginForm.login(admin);

        // Navigate to categories page
        navigationMenuForm.gotoPage("Catalog", "Categories");

        // Open create category form
        categoriesForm.gotoCreateForm();

        // Fill form
        createCategoryForm.fillCreateForm(category);
        createCategoryForm.saveCreateForm();

    }

    @Test(description = "Проверка отображения категории", dependsOnMethods = "createGroupTest")
    public void readCategoryTest() {

        open("/");

        $(byText(category.getName())).shouldBe(Condition.visible);

    }

    @Test(description = "Обновление категории", dependsOnMethods = "readCategoryTest")
    public void updateCategoryTest() {

        AdminLoginForm adminLoginForm = new AdminLoginForm();
        NavigationMenuForm navigationMenuForm = new NavigationMenuForm();
        CategoriesForm categoriesForm = new CategoriesForm();
        CreateCategoryForm createCategoryForm = new CreateCategoryForm();

        // Login
        open("/admin");
        adminLoginForm.login(admin);

        // Navigate to categories page
        navigationMenuForm.gotoPage("Catalog", "Categories");

        // Open create category form
        categoriesForm.gotoCreateForm();

        // Fill form
        createCategoryForm.fillCreateForm(categoryAfterUpdate);
        createCategoryForm.saveCreateForm();

    }

    @Test(description = "Проверка отображения категории после обновления", dependsOnMethods = "updateCategoryTest")
    public void readCategoryAfterUpdateTest() {

        open("/");

        $(byText(categoryAfterUpdate.getName())).shouldBe(Condition.visible);
    }

    @Test(description = "Удаление категории", dependsOnMethods = "readCategoryAfterUpdateTest", alwaysRun = true)
    public void deleteCategory() {
        AdminLoginForm adminLoginForm = new AdminLoginForm();
        NavigationMenuForm navigationMenuForm = new NavigationMenuForm();

        // Login
        open("/admin");
        adminLoginForm.login(admin);

        // Navigate to categories page
        navigationMenuForm.gotoPage("Catalog", "Categories");

    }

    @Test(description = "Проверка отображения категории после удаления", dependsOnMethods = "deleteCategory")
    public void readCategoryAfterDeleteTest() {

        open("/");

        $(byText(categoryAfterUpdate.getName())).shouldNotBe(Condition.visible);

    }

}
