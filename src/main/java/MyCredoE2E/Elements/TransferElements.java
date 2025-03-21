package MyCredoE2E.Elements;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;

import java.util.Collections;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TransferElements {
    public SelenideElement transferButton = $(Selectors.byId("transfer"));
    public SelenideElement ownAccount = $(Selectors.byXpath("//p[contains(@class, 'paragraph-14') and contains(text(), 'საკუთარ')]"));
    public SelenideElement whereAccInput = $(Selectors.byXpath("//div[@class='advanced-accounts-select']//p[text()='აირჩიეთ ანგარიში']"));
    public SelenideElement whereAcc = $$(Selectors.byId("accountItem")).get(0);
    public SelenideElement currency = $(Selectors.byId("accountCurrency_00"));
    public SelenideElement amountInput = $(Selectors.byXpath("//div[@class='custom-input-container'//input[@name='amount'"));
    public SelenideElement transfer = $(Selectors.byXpath("//button[@class='primary next' and text()='გადარიცხვა']"));
}
