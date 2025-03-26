package MyCredoE2E.Elements;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class DownloadRequisitesElements {
    public SelenideElement requisite = $(Selectors.byId("downloadRequisite"));
}
