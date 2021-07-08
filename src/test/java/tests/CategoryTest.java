package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import models.Category;
import models.User;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import steps.HomePageSteps;
import steps.admin.*;
import webdriver.BaseTest;

@Feature("Create - Read - Update - Delete Test")
public class CategoryTest extends BaseTest {
    private final AdminLoginFormSteps adminLoginFormSteps = new AdminLoginFormSteps();
    private final NavigationMenuFormSteps navigationMenuFormSteps = new NavigationMenuFormSteps();
    private final CategoriesFormSteps categoriesFormSteps = new CategoriesFormSteps();
    private final CreateCategoryFormSteps createCategoryFormSteps = new CreateCategoryFormSteps();
    private final UpdateCategoryFormSteps updateCategoryFormSteps = new UpdateCategoryFormSteps();
    private final HomePageSteps homePageSteps = new HomePageSteps();

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

        openAdminLoginPage();

        adminLoginFormSteps.login(admin);
        navigationMenuFormSteps.gotoPage("Catalog", "Categories");
        categoriesFormSteps.gotoCreateForm();
        createCategoryFormSteps.fillCreateForm(category)
                .saveCreateForm();
    }

    @Test(description = "Проверка отображения категории", dependsOnMethods = "createGroupTest")
    @Description(value = "Проверка отображения категории")
    public void readCategoryTest() {

        openMainPage();

        homePageSteps.checkThatCategoryIsVisible(category.getName());
    }

    @Test(description = "Обновление категории", dependsOnMethods = "readCategoryTest")
    @Description(value = "Обновление категории")
    public void updateCategoryTest() {

        openAdminLoginPage();

        adminLoginFormSteps.login(admin);
        navigationMenuFormSteps.gotoPage("Catalog", "Categories");
        categoriesFormSteps.findCategoryAndClickOnUpdateBtn(category);
        updateCategoryFormSteps.fillCreateForm(categoryAfterUpdate)
                .saveCreateForm();
    }

    @Test(description = "Проверка отображения категории после обновления", dependsOnMethods = "updateCategoryTest")
    @Description(value = "Проверка отображения категории после обновления")
    public void readCategoryAfterUpdateTest() {

        openMainPage();

        homePageSteps.checkThatCategoryIsVisible(categoryAfterUpdate.getName());
    }

    @Test(description = "Удаление категории", dependsOnMethods = "readCategoryAfterUpdateTest", alwaysRun = true)
    @Description(value = "Удаление категории")
    public void deleteCategory() {

        openAdminLoginPage();

        adminLoginFormSteps.login(admin);
        navigationMenuFormSteps.gotoPage("Catalog", "Categories");
        categoriesFormSteps.findAndMarkCategory(categoryAfterUpdate)
                .clickOnDeleteBtn();
    }

    @Test(description = "Проверка отображения категории после удаления", dependsOnMethods = "deleteCategory")
    @Description(value = "Проверка отображения категории после удаления")
    public void readCategoryAfterDeleteTest() {

        openMainPage();

        homePageSteps.checkThatCategoryIsNotVisible(categoryAfterUpdate.getName());
    }
}
