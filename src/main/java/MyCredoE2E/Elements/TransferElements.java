package MyCredoE2E.Elements;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TransferElements {
    public SelenideElement transferButton = $(Selectors.byId("transfer"));
    public SelenideElement ownAccount = $(Selectors.byXpath("//p[contains(@class, 'paragraph-14') and contains(text(), 'საკუთარ')]"));
    public SelenideElement ownAccNumber = $(Selectors.byXpath("//p[@class='paragraph-12 opa-06 selected-accounts' and normalize-space(text())='GE72CD0360000036501626']"));
    public SelenideElement whereAccInput = $(Selectors.byXpath("//p[@class='paragraph-12 opa-06 selected-accounts' and contains(text(), 'აირჩიეთ ანგარიში')]"));
    public SelenideElement whereAcc = $$(Selectors.byId("accountItem")).get(0);
    public SelenideElement whereAccNumber = $(Selectors.byXpath("//p[@class='paragraph-12 opa-06 selected-accounts' and normalize-space(text())='GE07CD0360000036659742']"));
    public SelenideElement currency = $(Selectors.byId("accountCurrency_00"));
    public SelenideElement amountInput = $(Selectors.byXpath("//div[@class='custom-input-container']//input[@name='amount']"));
    public SelenideElement transfer = $(Selectors.byXpath("//button[@class='primary next' and normalize-space(text())='გადარიცხვა']"));
    public SelenideElement popup = $(Selectors.byXpath("//div[@class='popup-wrapper']"));
    public SelenideElement success = $(Selectors.byXpath("//p[@class='paragraph-16 success' and normalize-space(text())='გადარიცხვა წარმატებით შესრულდა']"));
    public SelenideElement popupClose = $(Selectors.byXpath("//div[@class='popup-wrapper']//div[@class='header']//div[@class='icon close-black grey-010 pointer']"));
    public SelenideElement mainPage = $(Selectors.byXpath("//a[contains(@routerlink, '/home/main')]"));
    public SelenideElement firstTransfer = $(Selectors.byXpath("//table/tr[1]"));
    public SelenideElement transferPopup = $(Selectors.byXpath("//div[@class='popup-wrapper']"));
    public SelenideElement headerText = $(Selectors.byXpath("//p[@class='block-header-caps-18' and normalize-space(text())='საკუთარ ანგარიშებს შორის გადარიცხვა']"));
    public SelenideElement ownAccNumberTransactions = $(Selectors.byXpath("//p[@class='block-header-caps-16' and normalize-space(text())='GE72CD0360000036501626GEL']"));
    public SelenideElement whereAccNumberTransactions = $(Selectors.byXpath("//p[@class='block-header-caps-16' and normalize-space(text())='GE07CD0360000036659742GEL']"));
}
