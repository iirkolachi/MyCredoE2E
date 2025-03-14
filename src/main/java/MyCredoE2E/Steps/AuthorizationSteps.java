package MyCredoE2E.Steps;

import MyCredoE2E.Elements.AuthorizationElements;
import com.codeborne.selenide.Condition;
import org.testng.Assert;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class AuthorizationSteps extends AuthorizationElements {

    public AuthorizationSteps openWebsite() {
        open("https://testmycredo.credo.ge/landing/main/auth");
        return this;
    }
    public AuthorizationSteps enterUserData() {
        username.setValue("IILO2020");
        password.setValue("Xeleeee1");
        enter.click();
        otp.setValue("1234");
        otpSubmit.click();

        return this;
    }

    public AuthorizationSteps closePopup() {
        if (easyAuth.is(Condition.visible)) {
            easyAuthClose.click();
            easyAuthClose.click();
        } else {
            productsPage.click();
        }

        return this;
    }

    public AuthorizationSteps checkLogin() {
        String transactions = lastTransactions.shouldBe(visible, Duration.ofSeconds(10)).getText();
        Assert.assertEquals(transactions, "ბოლო ტრანზაქციები");
        return this;
    }
}
