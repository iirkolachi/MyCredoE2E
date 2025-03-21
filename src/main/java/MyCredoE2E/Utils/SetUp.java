package MyCredoE2E.Utils;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.awt.*;
import java.io.File;
import java.util.HashMap;

public class SetUp {

    @BeforeClass
    public void setUp() {
        Configuration.browser = "chrome";
        Selenide.open("about:blank");
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("download.default_directory", System.getProperty("user.home") + File.separator + "Downloads");
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("--start-maximized");
        Configuration.browserCapabilities = options;

        Selenide.open("about:blank");
        WebDriver driver = Selenide.webdriver().driver().getWebDriver();
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom = '80%'");

        Configuration.browserSize = null;
    }
    @AfterClass
    public void quit() {
        Selenide.closeWebDriver();
    }
}