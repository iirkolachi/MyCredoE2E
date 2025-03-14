package MyCredoE2E.Models.CurrencyRates;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.ArrayList;

@Getter
@Setter
@ToString
public class CurrencyRateResponseModel {
    public boolean success;
    @JsonProperty("Version")
    public String version;
    @JsonProperty("StatusCode")
    public int statusCode;
    @JsonProperty("Description")
    public String description;
    @JsonProperty("Result")
    public ArrayList<CurrencyResult> currencyResult;
    public String error;
}
