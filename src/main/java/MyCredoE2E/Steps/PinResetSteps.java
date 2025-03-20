package MyCredoE2E.Steps;

import MyCredoE2E.Elements.PinResetElements;
import io.qameta.allure.Step;
import org.testng.Assert;
import java.time.Duration;
import static com.codeborne.selenide.Condition.visible;

public class PinResetSteps extends PinResetElements {
    @Step
    public PinResetSteps resetDecline() {
        pin.shouldBe(visible, Duration.ofSeconds(10)).click();
        decline.shouldBe(visible, Duration.ofSeconds(5)).click();
        return this;
    }
    @Step
    public PinResetSteps resetClose() {
        pin.shouldBe(visible, Duration.ofSeconds(5)).click();
        close.shouldBe(visible, Duration.ofSeconds(5)).click();
        return this;
    }
    @Step
    public PinResetSteps otpClose() {
        pin.shouldBe(visible, Duration.ofSeconds(5)).click();
        resetButton.shouldBe(visible, Duration.ofSeconds(5)).click();
        close.shouldBe(visible, Duration.ofSeconds(5)).click();
        return this;
    }
    @Step
    public PinResetSteps otpTimeExpire() {
        pin.shouldBe(visible, Duration.ofSeconds(5)).click();
        resetButton.shouldBe(visible, Duration.ofSeconds(5)).click();
        //otpResend.shouldBe(visible, Duration.ofSeconds(125)).click();
        return this;
    }
    @Step
    public PinResetSteps checkWrongOtp() {
        otpInput.setValue("1111");
        otpSubmit.shouldBe(visible, Duration.ofSeconds(5)).click();
        String wrongOtp = wrongOtpNotification.shouldBe(visible, Duration.ofSeconds(5)).getText();
        Assert.assertEquals(wrongOtp, "მონაცემები არასწორია");
        return this;
    }
    @Step
    public PinResetSteps closeWrongOtpNotification() {
        closeNotification.shouldBe(visible, Duration.ofSeconds(5)).click();
        return this;
    }
    @Step
    public PinResetSteps resetPin() {
        pin.shouldBe(visible, Duration.ofSeconds(5)).click();
        resetButton.shouldBe(visible, Duration.ofSeconds(5)).click();
        otpInput.setValue("1234");
        otpSubmit.click();
        return this;
    }
    @Step
    public PinResetSteps checkPinReset() {
        String pinReset = pinResetNotification.shouldBe(visible, Duration.ofSeconds(5)).getText();
        Assert.assertEquals(pinReset, "ახალი პინ კოდი sms-ით გამოგიგზავნეთ");
        return this;
    }
    public PinResetSteps closePinResetNotification() {
        closeNotification.shouldBe(visible, Duration.ofSeconds(5)).click();
        return this;
    }
}
