package MyCredoE2E.Steps;

import MyCredoE2E.APICallsAndSteps.GetAccounts.GetAccountsList;
import MyCredoE2E.Elements.CardPageElements;
import org.testng.Assert;

import java.util.List;

public class CardPageSteps extends CardPageElements {

    public CardPageSteps compareBalances() {
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
}