package MyCredoE2E.Elements;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class AuthorizationElements {

    public SelenideElement username = $(Selectors.byId("userName"));
    public SelenideElement password = $(Selectors.byId("newPass"));
    public SelenideElement enter = $(Selectors.byId("submitAuth"));
    public SelenideElement otp = $(Selectors.byId("otpCodeInput"));
    public SelenideElement otpSubmit = $(Selectors.byXpath("//*[@id='otpSend']/form/button"));
    public SelenideElement easyAuth = $(Selectors.byXpath("//div[@class='popup-wrapper']"));
    public SelenideElement easyAuthClose = $(Selectors.byXpath("//div[@class='popup-wrapper']//div[@class='header']//div[@class='icon close-black grey-010 pointer']"));
    public SelenideElement productsPage = $(Selectors.byXpath("//a[contains(@routerlink, '/home/products')]"));
    public SelenideElement lastTransactions = $(Selectors.byXpath("//div[@class='header']//p[@class='block-header-caps-18' and contains(text(), 'ბოლო ტრანზაქციები')]"));
}
