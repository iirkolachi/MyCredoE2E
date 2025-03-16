package MyCredoE2E.APICallsAndSteps.GetAccounts;

import MyCredoE2E.DataController;
import MyCredoE2E.Models.Accounts.AccountsRequestModel;
import java.sql.SQLException;
import java.util.List;

public class GetAccountsList {
    DataController dataController = new DataController();
    GetAccountsSteps getAccountsSteps = new GetAccountsSteps();
    String accessToken = "";
    AccountsRequestModel accountsRequestModel = new AccountsRequestModel();

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
}