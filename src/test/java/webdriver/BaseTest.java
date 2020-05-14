package webdriver;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    @BeforeTest
    public void configuration() {
        Configuration.baseUrl = "http://opencart.nakoskin.ru";
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        Configuration.timeout = 5000;
    }

}
