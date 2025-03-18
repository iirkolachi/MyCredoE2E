package MyCredoE2E.Elements;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class CardLockUnlockElements {

    public SelenideElement lock = $(Selectors.byId("showBlockOrUnblock"));
    public SelenideElement lockButton = $(Selectors.byId("lockCard"));
    public SelenideElement decline = $(Selectors.byId("popupCard"));
    public SelenideElement close = $(Selectors.byXpath("//div[@class='popup-wrapper']//div[@class='header']//div[@class='icon close-black grey-010 pointer']"));
    public SelenideElement lockSuccessful = $(Selectors.byXpath("//p[text()='ბარათი წარმატებით დაიბლოკა']"));
    public SelenideElement unlock = $(Selectors.byId("showBlockOrUnblockCardPopup"));
    public SelenideElement unlockButton = $(Selectors.byId("unblock"));
    public SelenideElement unlockSuccessful = $(Selectors.byXpath("//p[text()='ბარათი წარმატებით განიბლოკა']"));
    public SelenideElement closeNotification = $(Selectors.byXpath("//div[@class='icon white-010 close pointer']"));
}
