package MyCredoE2E.Elements;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class NextCardElements {
    public SelenideElement nextButton = $(Selectors.byId("selectNextProduct"));
    public SelenideElement firstCardAccNumber = $(Selectors.byXpath("//div[@class='wrapper']//p[@class='block-header-caps-16' and contains(text(), 'GE72CD0360000036501626')]"));
    public SelenideElement secondCardAccNumber = $(Selectors.byXpath("//div[@class='wrapper']//p[@class='block-header-caps-16' and contains(text(), 'GE56CD0360000036484648')]"));
    public SelenideElement previousButton = $(Selectors.byId("selectPreviousProduct"));
}
