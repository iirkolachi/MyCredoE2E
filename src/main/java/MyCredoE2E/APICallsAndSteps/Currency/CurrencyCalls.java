package MyCredoE2E.APICallsAndSteps.Currency;

import MyCredoE2E.Models.CurrencyRates.CurrencyRateRequestModel;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class CurrencyCalls {

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
