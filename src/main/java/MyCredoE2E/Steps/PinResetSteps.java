package MyCredoE2E.Steps;

import MyCredoE2E.Elements.PinResetElements;
import io.qameta.allure.Step;
import org.testng.Assert;
import java.time.Duration;
import static com.codeborne.selenide.Condition.visible;

public class PinResetSteps extends PinResetElements {
    @Step
    public PinResetSteps resetDecline() {
        pin.click();
        decline.click();
        return this;
    }
    @Step
    public PinResetSteps resetClose() {
        pin.click();
        close.click();
        return this;
    }
    @Step
    public PinResetSteps otpClose() {
        pin.click();
        resetButton.click();
        close.click();
        return this;
    }
    @Step
    public PinResetSteps otpTimeExpire() {
        pin.click();
        resetButton.click();
        otpResend.shouldBe(visible, Duration.ofSeconds(120)).click();
        System.out.println(otpResend.getText());
        return this;
    }
    @Step
    public PinResetSteps checkWrongOtp() {
//        pin.click();
//        resetButton.click();
        otpInput.setValue("1111");
        otpSubmit.click();
        String wrongOtp = wrongOtpNotification.getText();
        Assert.assertEquals(wrongOtp, "მონაცემები არასწორია");
        return this;
    }
    @Step
    public PinResetSteps closeWrongOtpNotification() {
        closeWrongOtpNotification.click();
        return this;
    }
    @Step
    public PinResetSteps resetPin() {
        pin.click();
        resetButton.click();
        otpInput.setValue("1234");
        otpSubmit.click();
        return this;
    }
    @Step
    public PinResetSteps checkPinReset() {
        String pinReset = pinResetNotification.getText();
        Assert.assertEquals(pinReset, "ახალი პინ კოდი sms-ით გამოგიგზავნეთ");
        return this;
    }
}
