package MyCredoE2E.Steps;

import MyCredoE2E.APICallsAndSteps.GetAccounts.GetAccountsList;
import MyCredoE2E.Elements.TransferElements;
import io.qameta.allure.Step;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.jar.JarOutputStream;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.visible;

public class TransferSteps extends TransferElements {
    String from;
    String to;
    String fromTransactions;
    String fromNumberSplitted;
    String toTransactions;
    String toNumberSplitted;
    double transferAmount = 1;
    double amountFromBefore;
    double amountToBefore;
    double amountFromAfter;
    double amountToAfter;

    GetAccountsList getAccountsList = new GetAccountsList();


    @Step
    public TransferSteps clickTranfer() {
        transferButton.shouldBe(clickable, Duration.ofSeconds(5)).click();
        return this;
    }
    @Step
    public TransferSteps chooseOwnAcc() {
        ownAccount.shouldBe(clickable, Duration.ofSeconds(5)).click();
        return this;
    }
    @Step
    public TransferSteps takeOwnAccNumber() {
        from = ownAccNumber.getText();
        return this;
    }

    @Step
    public TransferSteps clickWhereAcc() {
        whereAccInput.shouldBe(clickable, Duration.ofSeconds(10)).isDisplayed();
        whereAccInput.click();
        return this;
    }
    @Step
    public TransferSteps chooseWhereAcc() {
        System.out.println("here");
        if (!whereAcc.isDisplayed()) {
            whereAccInput.shouldBe(clickable, Duration.ofSeconds(10)).click();
            whereAcc.shouldBe(clickable, Duration.ofSeconds(5)).click();
        } else {
            System.out.println("click");
            whereAcc.shouldBe(clickable, Duration.ofSeconds(5)).click();
        }
        return this;
    }
    @Step
    public TransferSteps chooseCurrency() {
        currency.shouldBe(clickable, Duration.ofSeconds(5)).click();
        return this;
    }
    @Step
    public TransferSteps takeAnotherAccNumber() {
        to = whereAccNumber.getText();
        return this;
    }
    @Step
    public TransferSteps getBeforeAmounts() {
        GetAccountsList getAccountsList = new GetAccountsList();
        List<Double> balanceFromBefore = getAccountsList.getAccountsList(from);
        List<Double> balanceToBefore = getAccountsList.getAccountsList(to);
        amountFromBefore = balanceFromBefore.get(0);
        amountToBefore = balanceToBefore.get(0);
        return this;
    }

    @Step
    public TransferSteps amountInput() {
        amountInput.shouldBe(clickable, Duration.ofSeconds(5)).click();
        amountInput.setValue(String.valueOf(transferAmount));
        return this;
    }
    @Step
    public TransferSteps tranfer() {
        transfer.shouldBe(clickable, Duration.ofSeconds(5)).click();
        return this;
    }
    @Step
    public TransferSteps tranferPopup() {
        popup.shouldBe(visible, Duration.ofSeconds(10)).isDisplayed();
        return this;
    }
    @Step
    public TransferSteps checkTransferNotification() {
        Assert.assertEquals(success.getText(), "გადარიცხვა წარმატებით შესრულდა");
        return this;
    }
    @Step
    public TransferSteps closePopup() {
        popupClose.click();
        return this;
    }
    @Step
    public TransferSteps moveToMainPage() {
        mainPage.shouldBe(visible, Duration.ofSeconds(10)).click();
        return this;
    }
    @Step
    public TransferSteps takeFirstTransfer() {
        firstTransfer.shouldBe(visible, Duration.ofSeconds(10)).click();
        return this;
    }
    @Step
    public TransferSteps firstTransferOpens() {
        transferPopup.shouldBe(visible, Duration.ofSeconds(10)).isDisplayed();
        return this;
    }
    @Step
    public TransferSteps checkTransferBetweenYourAccs() {
        Assert.assertEquals(headerText.getText(), "საკუთარ ანგარიშებს შორის გადარიცხვა");
        return this;
    }
    @Step
    public TransferSteps takeOwnAccNumberfromTransactions() {
        fromTransactions = ownAccNumberTransactions.getText();
        fromNumberSplitted = fromTransactions.substring(0, fromTransactions.length() - 3);
        return this;
    }
    @Step
    public TransferSteps takeAnotherAccNumberfromTransactions() {
        toTransactions = whereAccNumberTransactions.getText();
        toNumberSplitted = toTransactions.substring(0, toTransactions.length() - 3);
        return this;
    }
    @Step
    public TransferSteps checkOwnAccs() {
        Assert.assertEquals(fromNumberSplitted, from);
        return this;
    }
    @Step
    public TransferSteps checkAnotherAccs() {
        Assert.assertEquals(toNumberSplitted, to);
        return this;
    }
    @Step
    public TransferSteps getAfterAmounts() {
        GetAccountsList getAccountsList = new GetAccountsList();
        List<Double> balanceFromAfter = getAccountsList.getAccountsList(from);
        List<Double> balanceToAfter = getAccountsList.getAccountsList(to);
        amountFromAfter = balanceFromAfter.get(0);
        amountToAfter = balanceToAfter.get(0);
        return this;
    }
    @Step
    public TransferSteps checkFromBalances() {
        Assert.assertEquals(amountFromAfter, amountFromBefore - transferAmount);
        return this;
    }
    @Step
    public TransferSteps checkToBalances() {
        Assert.assertEquals(amountToAfter, amountToBefore + transferAmount);
        return this;
    }
}
