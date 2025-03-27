package MyCredoE2E.Elements;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LogoutElements {
    public SelenideElement userMenu = $(Selectors.byXpath("//div[@class='user-menu-wrapper']"));
    public SelenideElement logout = $(Selectors.byXpath("//li[@class='logout']"));
    public SelenideElement homePage = $(Selectors.byXpath("//p[@class='block-header-caps-20' and contains(text(),'სისტემაში შესვლა')]"));
}
