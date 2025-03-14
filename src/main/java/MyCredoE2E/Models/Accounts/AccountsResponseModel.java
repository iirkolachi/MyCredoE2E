package MyCredoE2E.Models.Accounts;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;


@Getter
@Setter
@ToString
public class AccountsResponseModel {
    public boolean success;
    @JsonProperty("Version")
    public String version;
    @JsonProperty("StatusCode")
    public int statusCode;
    @JsonProperty("Description")
    public String description;
    @JsonProperty("Result")
    public ArrayList<AccountResult> accountResult;
    public String error;
}

