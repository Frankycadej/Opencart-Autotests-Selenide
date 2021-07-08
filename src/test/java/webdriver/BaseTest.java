package webdriver;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    protected String adminLogin, adminPassword;

    @BeforeTest
    @Parameters({"adminLogin", "adminPassword", "rootLink", "browser"})
    public void readParams(String adminLogin, String adminPassword, String rootLink, String browser) {
        this.adminLogin = adminLogin;
        this.adminPassword = adminPassword;
        Configuration.baseUrl = rootLink;
        Configuration.driverManagerEnabled = false;
        //Configuration.remote = "http://localhost:4444/wd/hub";
        Configuration.browser = "firefox";
        Configuration.startMaximized = true;
        Configuration.timeout = 5000;
    }

    protected void openAdminLoginPage() {
        open("/admin");
    }

    protected void openMainPage() {
        open("/");
    }
}
