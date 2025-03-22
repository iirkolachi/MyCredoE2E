package MyCredoE2E.Elements;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CardPageElements {

    public SelenideElement gel = $$(Selectors.byXpath("//div[@class='wrapper account-card-currencies']//p[@class='block-header-caps-14 white']")).get(0);
    public SelenideElement usd = $$(Selectors.byXpath("//div[@class='wrapper account-card-currencies']//p[@class='block-header-caps-14 white']")).get(1);
    public SelenideElement eur = $$(Selectors.byXpath("//div[@class='wrapper account-card-currencies']//p[@class='block-header-caps-14 white']")).get(2);
    public SelenideElement cardName = $(Selectors.byXpath("//div[@class='brief-info']//p[@class='block-header-caps-20']"));
    public SelenideElement balanceSum = $(Selectors.byXpath("//div[@class='product-image has-card']//p[@class='block-header-caps-18 white']"));
}
