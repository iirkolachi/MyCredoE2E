import MyCredoE2E.Steps.AuthorizationSteps;
import MyCredoE2E.Steps.CardPageSteps;
import MyCredoE2E.Steps.ProductPageSteps;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class E2ETest {

    @Test (priority = 1)
    public void authorization() {
        AuthorizationSteps authorizationSteps = new AuthorizationSteps();

        authorizationSteps
                .openWebsite()
                .enterUserData()
                .closePopup()
                .checkLogin();
    }
    @Test (priority = 2)
    public void productsPage() {
        ProductPageSteps productPageSteps = new ProductPageSteps();

        productPageSteps
                .goToProductsPage()
                .openCards();
    }
    @Test (priority = 3)
    public void cardPage() throws SQLException {
        CardPageSteps cardPageSteps = new CardPageSteps();
        cardPageSteps
                .checkCardName()
                .compareBalances();
    }
}