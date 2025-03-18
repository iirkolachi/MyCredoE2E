package MyCredoE2E.Steps;

import MyCredoE2E.Elements.ProductPageElements;
import io.qameta.allure.Step;
import java.time.Duration;
import static com.codeborne.selenide.Condition.visible;

public class ProductPageSteps extends ProductPageElements {
    @Step
    public ProductPageSteps goToProductsPage() {
        productsPage.shouldBe(visible, Duration.ofSeconds(5)).click();
        return this;
    }
    @Step
    public ProductPageSteps openCards() {
        accountsAndCards.shouldBe(visible, Duration.ofSeconds(15)).click();
        card.shouldBe(visible, Duration.ofSeconds(3)).click();
        return this;
    }
}
