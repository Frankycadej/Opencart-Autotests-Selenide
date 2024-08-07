package webdriver;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import static com.codeborne.selenide.Selenide.open;

public class NewTest {

    @BeforeTest
    public void readParams() {
        Configuration.baseUrl = "localhost";
        Configuration.driverManagerEnabled = false;
        //Configuration.remote = "http://localhost:4444/wd/hub";
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        Configuration.timeout = 5000;
    }

    protected void openAdminLoginPage() {
        open("/admin");
    }

    protected void openMainPage() {
        open("http://localhost/en-gb?route=common/home");
    }
}
