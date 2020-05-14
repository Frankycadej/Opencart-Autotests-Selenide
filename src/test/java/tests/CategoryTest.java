package tests;

import forms.admin.*;
import models.*;
import org.testng.annotations.Test;
import webdriver.BaseTest;

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

    }

    @Test(description = "Обновление категории", dependsOnMethods = "readCategoryTest")
    public void updateCategoryTest() {

    }

    @Test(description = "Удаление категории", dependsOnMethods = "updateCategoryTest", alwaysRun = true)
    public void deleteCategory() {
        AdminLoginForm adminLoginForm = new AdminLoginForm();
        NavigationMenuForm navigationMenuForm = new NavigationMenuForm();

        // Login
        open("/admin");
        adminLoginForm.login(admin);

        // Navigate to categories page
        navigationMenuForm.gotoPage("Catalog", "Categories");

    }
}
