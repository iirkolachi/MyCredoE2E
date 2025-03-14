package MyCredoE2E.Steps;

import MyCredoE2E.Elements.ProductPageElements;
import java.time.Duration;
import static com.codeborne.selenide.Condition.visible;

public class ProductPageSteps extends ProductPageElements {

    public ProductPageSteps goToProductsPage() {
        productsPage.click();
        return this;
    }
    public ProductPageSteps openCards() {
        accountsAndCards.shouldBe(visible, Duration.ofSeconds(10)).click();
        card.shouldBe(visible, Duration.ofSeconds(10)).click();
        System.out.println(balanceSum.getText());
        return this;
    }
}
