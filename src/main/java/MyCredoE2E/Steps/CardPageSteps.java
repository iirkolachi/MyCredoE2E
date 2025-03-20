package MyCredoE2E.Steps;

import MyCredoE2E.APICallsAndSteps.Currency.Currency;
import MyCredoE2E.APICallsAndSteps.GetAccounts.GetAccountsList;
import MyCredoE2E.DataController;
import MyCredoE2E.Elements.CardPageElements;
import MyCredoE2E.Elements.ProductPageElements;
import io.qameta.allure.Step;
import org.testng.Assert;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;

public class CardPageSteps extends CardPageElements {
    @Step
    public CardPageSteps checkCardName() throws SQLException {
        DataController dataController = new DataController();
        CardPageElements cardPageElements = new CardPageElements();
        Assert.assertEquals(dataController.cardName(), cardPageElements.cardName.shouldBe(visible, Duration.ofSeconds(5)).getText());
        return this;
    }
    @Step
    public CardPageSteps compareIndividualBalances() {
        GetAccountsList getAccountsList = new GetAccountsList();
        List<Double> balances = getAccountsList.getAccountsList();

        String gelText = gel.getText();
        String[] gelSplitText = gelText.split("₾");
        Assert.assertEquals(balances.get(0), Double.parseDouble(gelSplitText[0]));

        String usdText = usd.getText();
        String[] usdSplitText = usdText.split("\\$");
        Assert.assertEquals(balances.get(1), Double.parseDouble(usdSplitText[0]));

        String eurText = eur.getText();
        String[] eurSplitText = eurText.split("€");
        Assert.assertEquals(balances.get(2), Double.parseDouble(eurSplitText[0]));

        return this;
    }
    @Step
    public CardPageSteps compareSumBalances() {
        GetAccountsList getAccountsList = new GetAccountsList();
        Currency currency = new Currency();
        List<Double> balances = getAccountsList.getAccountsList();
        List<Double> rates = currency.getCurrencyRatesList();

        ProductPageElements productPageElements = new ProductPageElements();
        String sumFront = productPageElements.balanceSum.getText();
        sumFront = sumFront.replace(",", "");
        String[] sumSplit = sumFront.split("₾");
        double sumFrontValue = Double.parseDouble(sumSplit[0]);
        double sumBack = balances.get(0);
        for (int i = 1; i < balances.size(); i++) {
            sumBack = sumBack + (balances.get(i) * rates.get(i-1));
        }
        DecimalFormat df = new DecimalFormat("#,###.00");
        String formattedSumBack = df.format(sumBack);
        String formattedSumFront = df.format(sumFrontValue);
        Assert.assertEquals(formattedSumBack, formattedSumFront);

        return this;
    }
}