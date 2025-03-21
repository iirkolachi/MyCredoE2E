package MyCredoE2E.Models.Accounts;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AccountsRequestModel {
    public int personId;
    @JsonProperty("ExcludeBalace")
    public boolean excludeBalace;
}