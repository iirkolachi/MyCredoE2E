package MyCredoE2E.Steps;

import MyCredoE2E.Elements.TransferElements;
import io.qameta.allure.Step;
import java.time.Duration;
import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.visible;

public class TransferSteps extends TransferElements {
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
    public TransferSteps clickWhereAcc() {
        whereAccInput.click();
        return this;
    }
    @Step
    public TransferSteps chooseWhereAcc() {
        whereAcc.shouldBe(visible, Duration.ofSeconds(5)).click();
        return this;
    }
    @Step
    public TransferSteps chooseCurrency() {
        currency.click();
        return this;
    }
    @Step
    public TransferSteps amountInput() {
        amountInput.setValue("1");
        return this;
    }
    @Step
    public TransferSteps tranfer() {
        transfer.click();
        return this;
    }
}
