package MyCredoE2E.Elements;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProductPageElements {

    public SelenideElement productsPage = $(Selectors.byXpath("//a[contains(@routerlink, '/home/products')]"));
    public SelenideElement accountsAndCards = $(Selectors.byXpath("//div[@class='accounts-and-cards product-block']"));
    public SelenideElement card = $$(Selectors.byXpath("(//div[@id='navToAccDetails'])")).get(1);
    public SelenideElement accNumber = $(Selectors.byXpath("//div[@class='wrapper']//p[@class='block-header-caps-16' and contains(text(), 'GE')]"));
}