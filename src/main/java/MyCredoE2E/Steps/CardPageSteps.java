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
    ProductPageElements productPageElements = new ProductPageElements();
    @Step
    public CardPageSteps checkCardName() throws SQLException {
        DataController dataController = new DataController();
        Assert.assertEquals(dataController.cardName(), cardName.shouldBe(visible, Duration.ofSeconds(20)).getText());
        return this;
    }
    @Step
    public CardPageSteps checkBalances() {
        var accountNumber = productPageElements.accNumber.getText();
        GetAccountsList getAccountsList = new GetAccountsList();
        List<Double> balanceForCheck = getAccountsList.getAccountsList(accountNumber);
        Currency currency = new Currency();
        List<Double> currenciesForCheck = currency.getCurrencyRatesList();
        compareGelBalances(balanceForCheck);
        compareUsdBalances(balanceForCheck);
        compareEurBalances(balanceForCheck);
        compareSumBalances(balanceForCheck, currenciesForCheck);
        return this;
    }
    @Step
    public void compareGelBalances(List<Double> balances) {
        String gelText = gel.getText();
        String[] gelSplitText = gelText.split("₾");
        Assert.assertEquals(balances.get(0), Double.parseDouble(gelSplitText[0]));
    }
    @Step
    public void compareUsdBalances(List<Double> balances) {
        String usdText = usd.getText();
        String[] usdSplitText = usdText.split("\\$");
        Assert.assertEquals(balances.get(1), Double.parseDouble(usdSplitText[0]));
    }
    @Step
    public void compareEurBalances(List<Double> balances) {
        String eurText = eur.getText();
        String[] eurSplitText = eurText.split("€");
        Assert.assertEquals(balances.get(2), Double.parseDouble(eurSplitText[0]));
    }
    @Step
    public void compareSumBalances(List<Double> balances, List<Double> rates) {
        String sumFront = balanceSum.getText();
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
    }
}