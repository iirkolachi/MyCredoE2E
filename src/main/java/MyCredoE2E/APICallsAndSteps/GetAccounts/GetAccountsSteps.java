package MyCredoE2E.APICallsAndSteps.GetAccounts;

import MyCredoE2E.Elements.ProductPageElements;
import MyCredoE2E.Models.Accounts.AccountsRequestModel;
import MyCredoE2E.Models.Accounts.AccountsResponseModel;
import MyCredoE2E.Models.Accounts.AccountResult;
import MyCredoE2E.Models.CurrencyRates.CurrencyRateRequestModel;
import MyCredoE2E.Models.CurrencyRates.CurrencyRateResponseModel;
import MyCredoE2E.Models.CurrencyRates.CurrencyResult;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import java.util.ArrayList;
import java.util.List;

public class GetAccountsSteps {

    @Step
    public List<Double> getBalances(AccountsRequestModel accountsRequestModel, String accessToken) {
        AccountsResponseModel accountsResponseModel = getAccounts(accountsRequestModel, accessToken);
        ProductPageElements productPageElements = new ProductPageElements();
        var accountNumber = productPageElements.accNumber.getText();
        List<Double> balances = new ArrayList<>();
        for (AccountResult accountResult : accountsResponseModel.accountResult) {
            if (accountResult.accountNumber.equals(accountNumber)) {
                balances.add(Double.valueOf(String.valueOf(accountResult.availableBalance)));
            }
        }
        return balances;
    }

    @Step
    public AccountsResponseModel getAccounts(AccountsRequestModel accountsRequestModel, String accessToken) {
        GetAccountsCalls getAccountsCalls = new GetAccountsCalls();
        Response response = getAccountsCalls.responseAccount(accountsRequestModel, accessToken);
        int statusCode = response.getStatusCode();
        AccountsResponseModel accountsResponseModel = null;
        if (statusCode == 200) {
            accountsResponseModel = response.as(AccountsResponseModel.class);
        } else {
            accountsResponseModel = new AccountsResponseModel();
            accountsResponseModel.setError(String.format("Error occurred: Status code %d, Response: %s", statusCode, response.getBody()));
        }
        return accountsResponseModel;

    }

    @Step
    public List<Double> getCurrencies(CurrencyRateRequestModel currencyRateRequestModel, String accessToken) {
        CurrencyRateResponseModel currencyRateResponseModel = getAllCurrencyRates(currencyRateRequestModel, accessToken);
        List<Double> rates = new ArrayList<>();
        for (CurrencyResult currencyResult : currencyRateResponseModel.currencyResult) {
            if (currencyResult.currency.equals("GEL") || currencyResult.currency.equals("USD") || currencyResult.currency.equals("EUR")) {
                rates.add(currencyResult.buyRate);
            }
        }
        return rates;
    }

    @Step
    public CurrencyRateResponseModel getAllCurrencyRates(CurrencyRateRequestModel currencyRateRequestModel, String accessToken) {
        GetAccountsCalls getAccountsCalls = new GetAccountsCalls();
        Response response = getAccountsCalls.responseCurrency(currencyRateRequestModel, accessToken);
        int statusCode = response.getStatusCode();
        CurrencyRateResponseModel currencyRateResponseModel = null;
        if (statusCode == 200) {
            currencyRateResponseModel = response.as(CurrencyRateResponseModel.class);
        } else {
            currencyRateResponseModel = new CurrencyRateResponseModel();
            currencyRateResponseModel.setError(String.format("Error occurred: Status code %d, Response: %s", statusCode, response.getBody()));
        }
        return currencyRateResponseModel;

    }

}


