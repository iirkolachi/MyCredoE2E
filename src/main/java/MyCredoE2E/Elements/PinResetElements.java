package MyCredoE2E.Elements;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class PinResetElements {
    public SelenideElement pin = $(Selectors.byId("pinReset"));
    public SelenideElement decline = $(Selectors.byId("closePinReset"));
    public SelenideElement close = $(Selectors.byXpath("//div[@class='popup-wrapper']//div[@class='header']//div[@class='icon close-black grey-010 pointer']"));
    public SelenideElement resetButton = $(Selectors.byId("resetPin"));
    public SelenideElement otpInput = $(Selectors.byId("otpCodeInput"));
    public SelenideElement otpSubmit = $(Selectors.byXpath("//button[@class='primary' and contains(text(), 'დადასტურება')]"));
    public SelenideElement otpResend = $(Selectors.byXpath("//p[@class='paragraph-14 blue pointer' and text()='კოდის თავიდან მიღება']"));
    public SelenideElement wrongOtpNotification = $(Selectors.byXpath("//p[text()='მონაცემები არასწორია']"));
    public SelenideElement closeNotification = $(Selectors.byXpath("//div[@class='icon white-010 close pointer']"));
    public SelenideElement pinResetNotification = $(Selectors.byXpath("//p[text()='ახალი პინ კოდი sms-ით გამოგიგზავნეთ']"));
}
