package MyCredoE2E.APICallsAndSteps.GetAccounts;

import MyCredoE2E.DataController;
import MyCredoE2E.Models.Accounts.AccountsRequestModel;
import MyCredoE2E.Models.Accounts.AccountsResponseModel;
import MyCredoE2E.Models.CurrencyRates.CurrencyRateRequestModel;

import java.sql.SQLException;
import java.util.List;

public class GetAccountsList {
    DataController dataController = new DataController();
    GetAccountsSteps getAccountsSteps = new GetAccountsSteps();
    String accessToken = "";
    AccountsRequestModel accountsRequestModel = new AccountsRequestModel();
    AccountsResponseModel accountsResponseModel = new AccountsResponseModel();
    CurrencyRateRequestModel currencyRateRequestModel = new CurrencyRateRequestModel();

    public List<Double> getAccountsList() {
        List<Double> balances;
        try {
            accessToken = dataController.accessToken();
            accountsRequestModel.setPersonId(dataController.personId());
            accountsRequestModel.setExcludeBalace(false);
            balances = getAccountsSteps.getBalances(accountsRequestModel, accessToken);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return balances;
    }

    public List<Double> getCurrencyRatesList() {
        List<Double> currencies;
        try {
            accessToken = dataController.accessToken();
            currencyRateRequestModel.setChanelId(98);
            currencyRateRequestModel.setChannelTypeId(1);
            currencies = getAccountsSteps.getCurrencies(currencyRateRequestModel, accessToken);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return currencies;
    }
}