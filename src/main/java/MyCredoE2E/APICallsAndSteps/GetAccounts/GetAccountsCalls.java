package MyCredoE2E.APICallsAndSteps.GetAccounts;

import MyCredoE2E.Models.Accounts.AccountsRequestModel;
import MyCredoE2E.Models.CurrencyRates.CurrencyRateRequestModel;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class GetAccountsCalls {
    public Response responseAccount (AccountsRequestModel accountsRequestModel, String accessToken) {
        return given()
                .header("Authorization", accessToken )
                .header("Accept" , "*/*")
                .header("Accept-Encoding" , "gzip, deflate, br")
                .contentType("application/json; charset=utf-8")
                .when()
                .body(accountsRequestModel)
                .post("http://test.api.css.credo.ge/api/Account/AccountList");
    }

    public Response responseCurrency (CurrencyRateRequestModel currencyRateRequestModel, String accessToken) {
        return given()
                .header("Authorization", accessToken )
                .header("Accept" , "*/*")
                .header("Accept-Encoding" , "gzip, deflate, br")
                .contentType("application/json; charset=utf-8")
                .when()
                .body(currencyRateRequestModel)
                .post("http://test.api.css.credo.ge/api/Core/CurrencyRateList");
    }
}