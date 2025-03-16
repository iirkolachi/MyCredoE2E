package MyCredoE2E.Steps;

import MyCredoE2E.APICallsAndSteps.Currency.Currency;
import MyCredoE2E.APICallsAndSteps.GetAccounts.GetAccountsList;
import MyCredoE2E.DataController;
import MyCredoE2E.Elements.CardPageElements;
import MyCredoE2E.Elements.ProductPageElements;
import org.testng.Assert;
import java.sql.SQLException;
import java.util.List;

public class CardPageSteps extends CardPageElements {

    public CardPageSteps checkCardName() throws SQLException {
        DataController dataController = new DataController();
        CardPageElements cardPageElements = new CardPageElements();
        Assert.assertEquals(dataController.cardName(), cardPageElements.cardName.getText());
        System.out.println(dataController.cardName() + cardPageElements.cardName.getText());
        return this;
    }

    public CardPageSteps compareBalances() {
        GetAccountsList getAccountsList = new GetAccountsList();
        Currency currency = new Currency();
        List<Double> balances = getAccountsList.getAccountsList();
        List<Double> rates = currency.getCurrencyRatesList();

        String gelText = gel.getText();
        String[] gelSplitText = gelText.split("₾");
        Assert.assertEquals(balances.get(0), Double.parseDouble(gelSplitText[0]));

        String usdText = usd.getText();
        String[] usdSplitText = usdText.split("\\$");
        Assert.assertEquals(balances.get(1), Double.parseDouble(usdSplitText[0]));

        String eurText = eur.getText();
        String[] eurSplitText = eurText.split("€");
        Assert.assertEquals(balances.get(2), Double.parseDouble(eurSplitText[0]));

        ProductPageElements productPageElements = new ProductPageElements();
        String sumFront = productPageElements.balanceSum.getText();
        String[] sumSplit = sumFront.split("₾");
        sumSplit[0] = sumSplit[0].trim();
        double sumBack = balances.get(0);
        for (int i = 1; i < balances.size(); i++) {
            sumBack = sumBack + (balances.get(i) * rates.get(i-1));
        }
        //Assert.assertEquals(sumBack, Double.parseDouble(sumSplit[0]));
        System.out.println("ჯამური თანხა სალაროს კურსით: " + sumBack + "; ჯამური თანხა მაიკრედოს კურსით " + sumSplit[0].trim());

        return this;
    }
}