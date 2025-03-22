package MyCredoE2E.Steps;

import MyCredoE2E.Elements.ProductPageElements;
import io.qameta.allure.Step;
import java.time.Duration;
import static com.codeborne.selenide.Condition.visible;

public class ProductPageSteps extends ProductPageElements {
    @Step
    public ProductPageSteps goToProductsPage() {
        productsPage.shouldBe(visible, Duration.ofSeconds(15)).click();
        return this;
    }
    @Step
    public ProductPageSteps openAccsAndCards() {
        accountsAndCards.shouldBe(visible, Duration.ofSeconds(15)).click();
        return this;
    }
    @Step
    public ProductPageSteps openCards() {
        if (!card.isDisplayed()) {
            System.out.println("if");
            goToProductsPage();
            openAccsAndCards();
            card.shouldBe(visible, Duration.ofSeconds(15)).click();
        } else {
            System.out.println("else");
            card.shouldBe(visible, Duration.ofSeconds(15)).click();
        }
        return this;
    }
}



