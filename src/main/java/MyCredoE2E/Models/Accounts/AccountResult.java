package MyCredoE2E.Models.Accounts;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AccountResult {
    @JsonProperty("AccountItemId")
    public int accountItemId;
    @JsonProperty("T24AccountId")
    public int t24AccountId;
    @JsonProperty("CurrencyId")
    public int currencyId;
    @JsonProperty("Currency")
    public String currency;
    @JsonProperty("StatusId")
    public int statusId;
    @JsonProperty("Status")
    public String status;
    @JsonProperty("ActivationDate")
    public String activationDate;
    @JsonProperty("CloseDate")
    public Object closeDate;
    @JsonProperty("Balance")
    public double balance;
    @JsonProperty("AvailableBalance")
    public double availableBalance;
    @JsonProperty("MaskedBalance")
    public Object maskedBalance;
    @JsonProperty("MaskedAvailableBalance")
    public Object maskedAvailableBalance;
    @JsonProperty("BlockedAmount")
    public double blockedAmount;
    @JsonProperty("CommentCount")
    public int commentCount;
    @JsonProperty("Reason")
    public Object reason;
    @JsonProperty("FullName")
    public String fullName;
    @JsonProperty("AccNumberAvailableName")
    public String accNumberAvailableName;
    @JsonProperty("ChannelTypeId")
    public int channelTypeId;
    @JsonProperty("HasRestrictions")
    public boolean hasRestrictions;
    @JsonProperty("IsSecret")
    public boolean isSecret;
    @JsonProperty("IsOverdraft")
    public int isOverdraft;
    @JsonProperty("JointAccountPersonId")
    public Object jointAccountPersonId;
    @JsonProperty("AccountOwnerPersonId")
    public Object accountOwnerPersonId;
    @JsonProperty("HasInterestAccrualScheme")
    public boolean hasInterestAccrualScheme;
    @JsonProperty("HasStInterestAccrualScheme")
    public boolean hasStInterestAccrualScheme;
    @JsonProperty("InterestAccrualSchemeName")
    public Object interestAccrualSchemeName;
    @JsonProperty("CardNumber")
    public Object cardNumber;
    @JsonProperty("IsBusinessOverdraftAccount")
    public boolean isBusinessOverdraftAccount;
    @JsonProperty("IsCreditCardtAccount")
    public boolean isCreditCardtAccount;
    @JsonProperty("ApplicationId")
    public int applicationId;
    @JsonProperty("InitialStartDate")
    public Object initialStartDate;
    @JsonProperty("OfficerId")
    public Object officerId;
    @JsonProperty("DebtAmount")
    public Object debtAmount;
    @JsonProperty("CommisionName")
    public Object commisionName;
    @JsonProperty("OperationId")
    public int operationId;
    @JsonProperty("ProductId")
    public int productId;
    @JsonProperty("HasActiveWallet")
    public boolean hasActiveWallet;
    @JsonProperty("UserId")
    public Object userId;
    @JsonProperty("Rate")
    public double rate;
    @JsonProperty("EndDate")
    public String endDate;
    @JsonProperty("DepositScheduledInterest")
    public Object depositScheduledInterest;
    @JsonProperty("ProlongationTypeId")
    public Object prolongationTypeId;
    @JsonProperty("DepositTypeId")
    public Object depositTypeId;
    @JsonProperty("IsSetBranchIdParam")
    public boolean isSetBranchIdParam;
    @JsonProperty("Nickname")
    public String nickname;
    public Object hasUsedOtp;
    @JsonProperty("CardType")
    public Object cardType;
    @JsonProperty("AccountId")
    public int accountId;
    @JsonProperty("Account")
    public String account;
    @JsonProperty("AccountNumber")
    public String accountNumber;
    @JsonProperty("CategoryId")
    public int categoryId;
    @JsonProperty("Category")
    public String category;
    @JsonProperty("PersonId")
    public int personId;
    @JsonProperty("Person")
    public String person;
    @JsonProperty("PersonEng")
    public Object personEng;
    @JsonProperty("PersonCif")
    public int personCif;
    @JsonProperty("CurrencyIdList")
    public Object currencyIdList;
    @JsonProperty("BranchId")
    public int branchId;
    @JsonProperty("Branch")
    public String branch;
    @JsonProperty("ResponsibleUserId")
    public int responsibleUserId;
    @JsonProperty("ResponsibleUser")
    public String responsibleUser;
    @JsonProperty("ResponsibleLoanOfficerId")
    public Object responsibleLoanOfficerId;
    @JsonProperty("HasCard")
    public boolean hasCard;
    @JsonProperty("HasAccountOverdraft")
    public boolean hasAccountOverdraft;
    @JsonProperty("JointAccountCif")
    public Object jointAccountCif;
    @JsonProperty("CardApplications")
    public Object cardApplications;
    @JsonProperty("JointAccountOwnerPersonId")
    public Object jointAccountOwnerPersonId;
    @JsonProperty("PersNumber")
    public String persNumber;
    @JsonProperty("DisplayAccount")
    public boolean displayAccount;
    @JsonProperty("BankSource")
    public String bankSource;
    @JsonProperty("DateCreated")
    public String dateCreated;
    @JsonProperty("DateUpdated")
    public Object dateUpdated;
    @JsonProperty("DateDeleted")
    public Object dateDeleted;
}
