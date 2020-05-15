package webdriver;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import static io.qameta.allure.Allure.step;

public class BaseTest {

    protected String adminLogin, adminPassword;

    private String rootLink, browser;

    @BeforeTest
    @Parameters({"adminLogin", "adminPassword", "rootLink", "browser"})
    public void readParams(String adminLogin, String adminPassword, String rootLink, String browser) {
        this.adminLogin = adminLogin;
        this.adminPassword = adminPassword;
        this.rootLink = rootLink;
        this.browser = browser;
        Configuration.baseUrl = rootLink;
        Configuration.browser = browser;
        Configuration.startMaximized = true;
        Configuration.timeout = 5000;
    }

    @BeforeTest
    public void configuration() {
    }

    public void logStep(Integer num, String description) {
        step(num + " " + description);
    }

}
