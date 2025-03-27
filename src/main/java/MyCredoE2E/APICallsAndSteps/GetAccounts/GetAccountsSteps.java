package MyCredoE2E.APICallsAndSteps.GetAccounts;

import MyCredoE2E.Models.Accounts.AccountsRequestModel;
import MyCredoE2E.Models.Accounts.AccountsResponseModel;
import MyCredoE2E.Models.Accounts.AccountResult;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import java.util.ArrayList;
import java.util.List;

public class GetAccountsSteps {

    @Step
    public List<Double> getBalances(AccountsRequestModel accountsRequestModel, String accessToken, String accountNumber) {
        AccountsResponseModel accountsResponseModel = getAccounts(accountsRequestModel, accessToken);
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
}