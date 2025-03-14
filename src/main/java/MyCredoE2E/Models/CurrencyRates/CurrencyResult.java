package MyCredoE2E.Models.CurrencyRates;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CurrencyResult {
    @JsonProperty("CurrencyId")
    public int currencyId;
    @JsonProperty("Currency")
    public String currency;
    @JsonProperty("BuyRate")
    public double buyRate;
    @JsonProperty("SellRate")
    public double sellRate;
    @JsonProperty("NBGRate")
    public double nBGRate;
    @JsonProperty("IsDivide")
    public boolean isDivide;
}
