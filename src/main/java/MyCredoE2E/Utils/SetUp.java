package MyCredoE2E.Utils;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class SetUp {

    @BeforeClass
    public void setUpMethod() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
    }

    @AfterClass
    public void quit() {
        Selenide.closeWebDriver();
    }
}
