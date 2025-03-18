package MyCredoE2E.Steps;

import MyCredoE2E.Elements.AuthorizationElements;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.testng.Assert;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class AuthorizationSteps extends AuthorizationElements {

    @Step
    public AuthorizationSteps openWebsite() {
        open("https://testmycredo.credo.ge/landing/main/auth");
        return this;
    }
    @Step
    public AuthorizationSteps enterUserData() {
        username.setValue("IILO2020");
        password.setValue("Xeleeee1");
        enter.click();
        otp.setValue("1234");
        otpSubmit.click();

        return this;
    }
    @Step
    public AuthorizationSteps closePopup() {
        if (easyAuth.shouldBe(visible, Duration.ofSeconds(5)).isDisplayed()) {
            easyAuthClose.click();
            easyAuthClose.click();
        } else {
            productsPage.shouldBe(visible, Duration.ofSeconds(5)).click();
        }

        return this;
    }
    @Step
    public AuthorizationSteps checkLogin() {
        String transactions = lastTransactions.shouldBe(visible, Duration.ofSeconds(10)).getText();
        Assert.assertEquals(transactions, "ბოლო ტრანზაქციები");
        return this;
    }
}
