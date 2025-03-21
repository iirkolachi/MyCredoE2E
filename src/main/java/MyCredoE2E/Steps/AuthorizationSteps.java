package MyCredoE2E.Steps;

import MyCredoE2E.Elements.AuthorizationElements;
import MyCredoE2E.Utils.SetUp;
import io.qameta.allure.Step;
import org.testng.Assert;
import java.time.Duration;
import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class AuthorizationSteps extends AuthorizationElements {
    SetUp setup = new SetUp();

    @Step
    public AuthorizationSteps openWebsite(String url) {
        setup.setUp();
        open(url);
        return this;
    }
    @Step
    public AuthorizationSteps enterUserData() {
        username.setValue("IILO2020");
        password.setValue("Xeleeee1");
        enter.click();
        otp.shouldBe(clickable, Duration.ofSeconds(10)).click();
        otp.setValue("1234");
        otpSubmit.click();

        return this;
    }
    @Step
    public AuthorizationSteps closePopup() {
        if (easyAuth.shouldBe(visible, Duration.ofSeconds(15)).isDisplayed()) {
            easyAuthClose.click();
            easyAuthClose.click();
        } else {
            productsPage.shouldBe(visible, Duration.ofSeconds(15)).click();
        }
        return this;
    }
    @Step
    public AuthorizationSteps checkLogin() {
        String transactions = lastTransactions.shouldBe(visible, Duration.ofSeconds(15)).getText();
        Assert.assertEquals(transactions, "ბოლო ტრანზაქციები");
        return this;
    }
}
