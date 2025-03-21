package MyCredoE2E.Utils;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.io.File;
import java.util.HashMap;

public class SetUp {

    @BeforeClass
    public void setUp() {
        Configuration.browser = "chrome";
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("download.default_directory", System.getProperty("user.home") + File.separator + "Downloads");
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("--force-device-scale-factor=1.0");
        Configuration.browserCapabilities = options;
        Selenide.open("about:blank");
        WebDriver driver = Selenide.webdriver().driver().getWebDriver();
        driver.manage().window().maximize();
        Configuration.browserSize = null;
    }
    @AfterClass
    public void quit() {
        Selenide.closeWebDriver();
    }
}