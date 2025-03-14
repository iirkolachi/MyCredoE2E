package MyCredoE2E.Models.CurrencyRates;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CurrencyRateRequestModel{
    public String currency;
    @JsonProperty("ChannelTypeId")
    public int channelTypeId;
    @JsonProperty("ChanelId")
    public int chanelId;
}
