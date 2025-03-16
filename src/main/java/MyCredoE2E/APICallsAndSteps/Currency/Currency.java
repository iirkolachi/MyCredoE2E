package MyCredoE2E.APICallsAndSteps.Currency;

import MyCredoE2E.DataController;
import MyCredoE2E.Models.CurrencyRates.CurrencyRateRequestModel;

import java.sql.SQLException;
import java.util.List;

public class Currency {
    DataController dataController = new DataController();
    CurrencySteps currencySteps = new CurrencySteps();
    String accessToken = "";
    CurrencyRateRequestModel currencyRateRequestModel = new CurrencyRateRequestModel();


    public List<Double> getCurrencyRatesList() {
        List<Double> currencies;
        try {
            accessToken = dataController.accessToken();
            currencyRateRequestModel.setCurrency("GEL");
            currencyRateRequestModel.setChanelId(98);
            currencyRateRequestModel.setChannelTypeId(1);
            currencies = currencySteps.getCurrencies(currencyRateRequestModel, accessToken);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return currencies;
    }
}
