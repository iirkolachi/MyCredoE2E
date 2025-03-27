package MyCredoE2E.Steps;

import MyCredoE2E.Elements.ProductPageElements;
import io.qameta.allure.Step;
import java.time.Duration;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;

public class ProductPageSteps extends ProductPageElements {
    @Step
    public ProductPageSteps goToProductsPage() {
        productsPage.shouldBe(visible, Duration.ofSeconds(30)).click();
        return this;
    }
    @Step
    public ProductPageSteps openAccsAndCards() {
        accountsAndCards.shouldBe(visible, Duration.ofSeconds(30)).click();
        return this;
    }
    @Step
    public ProductPageSteps openCards() {
        if(accountsAndCards.is(exist, Duration.ofSeconds(5))) {
            openAccsAndCards();
        }
        return this;
    }
    @Step
    public ProductPageSteps openCard() {
        card.shouldBe(visible, Duration.ofSeconds(20)).click();
        return this;
    }
}