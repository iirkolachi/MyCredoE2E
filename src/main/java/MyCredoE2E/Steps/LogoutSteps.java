package MyCredoE2E.Steps;

import MyCredoE2E.Elements.LogoutElements;
import io.qameta.allure.Step;
import junit.framework.Assert;
import java.time.Duration;
import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.visible;

public class LogoutSteps extends LogoutElements {
    @Step
    public LogoutSteps clickUserMenu() {
        userMenu.shouldBe(clickable, Duration.ofSeconds(30)).click();
        return this;
    }
    @Step
    public LogoutSteps clickLogout() {
        logout.shouldBe(visible, Duration.ofSeconds(30)).click();
        return this;
    }
    @Step
    public LogoutSteps checkLogout() {
        Assert.assertEquals("სისტემაში შესვლა", homePage.getText());
        return this;
    }
}
