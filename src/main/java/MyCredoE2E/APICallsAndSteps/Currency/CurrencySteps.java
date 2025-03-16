package MyCredoE2E.APICallsAndSteps.Currency;

import MyCredoE2E.Models.CurrencyRates.CurrencyRateRequestModel;
import MyCredoE2E.Models.CurrencyRates.CurrencyRateResponseModel;
import MyCredoE2E.Models.CurrencyRates.CurrencyResult;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import java.util.ArrayList;
import java.util.List;

public class CurrencySteps {

    @Step
    public List<Double> getCurrencies(CurrencyRateRequestModel currencyRateRequestModel, String accessToken) {
        CurrencyRateResponseModel currencyRateResponseModel = getAllCurrencyRates(currencyRateRequestModel, accessToken);
        List<Double> rates = new ArrayList<>();
        for (CurrencyResult currencyResult : currencyRateResponseModel.currencyResult) {
            if (currencyResult.currency.equals("GEL") || currencyResult.currency.equals("USD") || currencyResult.currency.equals("EUR")) {
                rates.add(currencyResult.sellRate);
            }
        }
        return rates;
    }

    @Step
    public CurrencyRateResponseModel getAllCurrencyRates(CurrencyRateRequestModel currencyRateRequestModel, String accessToken) {
        CurrencyCalls currencyCalls = new CurrencyCalls();
        Response response = currencyCalls.responseCurrency(currencyRateRequestModel, accessToken);
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
