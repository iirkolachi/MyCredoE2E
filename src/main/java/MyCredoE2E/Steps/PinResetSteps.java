package MyCredoE2E.Steps;

import MyCredoE2E.Elements.PinResetElements;
import io.qameta.allure.Step;
import org.testng.Assert;
import java.time.Duration;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.visible;

public class PinResetSteps extends PinResetElements {
    @Step
    public PinResetSteps clickPin() {
        pin.shouldBe(visible, Duration.ofSeconds(20)).click();
        return this;
    }
    @Step
    public PinResetSteps resetDecline() {
        decline.shouldBe(visible, Duration.ofSeconds(20)).click();
        return this;
    }
    @Step
    public PinResetSteps resetClose() {
        clickPin();
        close.shouldBe(visible, Duration.ofSeconds(20)).click();
        return this;
    }
    @Step
    public PinResetSteps otpClose() {
        clickPin();
        resetButton.shouldBe(visible, Duration.ofSeconds(20)).click();
        close.shouldBe(visible, Duration.ofSeconds(20)).click();
        return this;
    }
    @Step
    public PinResetSteps wrongOtp() {
        clickPin();
        resetButton.shouldBe(visible, Duration.ofSeconds(20)).click();
        otpInput.setValue("1111");
        otpSubmit.shouldBe(clickable, Duration.ofSeconds(20)).click();
        return this;
    }
    @Step
    public PinResetSteps checkWrongOtp() {
        String wrongOtp = wrongOtpNotification.shouldBe(visible, Duration.ofSeconds(20)).getText();
        Assert.assertEquals(wrongOtp, "მონაცემები არასწორია");
        return this;
    }
    @Step
    public PinResetSteps closeWrongOtpNotification() {
        closeNotification.shouldBe(visible, Duration.ofSeconds(20)).click();
        return this;
    }
    @Step
    public PinResetSteps resetPin() {
        clickPin();
        resetButton.shouldBe(visible, Duration.ofSeconds(20)).click();
        otpInput.setValue("1234");
        otpSubmit.shouldBe(visible, Duration.ofSeconds(20)).click();
        return this;
    }
    @Step
    public PinResetSteps checkPinReset() {
        String pinReset = pinResetNotification.shouldBe(visible, Duration.ofSeconds(20)).getText();
        Assert.assertEquals(pinReset, "ახალი პინ კოდი sms-ით გამოგიგზავნეთ");
        return this;
    }
    @Step
    public PinResetSteps closePinResetNotification() {
        closeNotification.shouldBe(visible, Duration.ofSeconds(20)).click();
        return this;
    }
}
