package MyCredoE2E.Steps;

import MyCredoE2E.Elements.AuthorizationElements;
import MyCredoE2E.Utils.SetUp;
import io.qameta.allure.Step;
import org.testng.Assert;
import java.time.Duration;
import static com.codeborne.selenide.Condition.*;
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
    public AuthorizationSteps enterUsername (String usernameValue) {
        username.shouldBe(clickable, Duration.ofSeconds(30)).click();
        username.setValue(usernameValue);
        return this;
    }
    @Step
    public AuthorizationSteps enterPassword (String passwordValue) {
        password.shouldBe(clickable, Duration.ofSeconds(30)).click();
        password.setValue(passwordValue);
        return this;
    }
    @Step
    public AuthorizationSteps clickEnter () {
        enter.click();
        return this;
    }
    @Step
    public AuthorizationSteps otpPopup () {
        otp.shouldBe(clickable, Duration.ofSeconds(30)).click();
        otp.setValue("1234");
        otpSubmit.click();
        return this;
    }
    @Step
    public AuthorizationSteps easyAuthPopup() {
        if (easyAuth.is(exist, Duration.ofSeconds(5))) {
            easyAuthClose.click();
            easyAuthClose.click();
        }
        return this;
    }
    @Step
    public AuthorizationSteps checkAuth() {
        String transactions = lastTransactions.shouldBe(visible, Duration.ofSeconds(20)).getText();
        Assert.assertEquals(transactions, "ბოლო ტრანზაქციები");
        return this;
    }
}