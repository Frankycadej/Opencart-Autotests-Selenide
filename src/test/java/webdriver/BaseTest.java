package webdriver;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeTest;

import static io.qameta.allure.Allure.step;

public class BaseTest {

    @BeforeTest
    public void configuration() {
        Configuration.baseUrl = "http://opencart.nakoskin.ru";
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        Configuration.timeout = 5000;
    }

    public void logStep(Integer num, String description) {
        step(num + description);
    }

}
