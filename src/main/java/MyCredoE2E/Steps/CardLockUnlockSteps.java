package MyCredoE2E.Steps;

import MyCredoE2E.Elements.CardLockUnlockElements;
import io.qameta.allure.Step;
import org.testng.Assert;
import java.time.Duration;
import static com.codeborne.selenide.Condition.visible;

public class CardLockUnlockSteps extends CardLockUnlockElements {
    @Step
    public CardLockUnlockSteps lockDecline() {
        lock.click();
        decline.click();
        return this;
    }
    @Step
    public CardLockUnlockSteps lockClose() {
        lock.click();
        close.click();
        return this;
    }
    @Step
    public CardLockUnlockSteps lockCard() {
        lock.click();
        lockButton.click();
        return this;
    }
    @Step
    public CardLockUnlockSteps checkLock() {
        String lockSuccessfully = lockSuccessful.getText();
        Assert.assertEquals(lockSuccessfully, "ბარათი წარმატებით დაიბლოკა");
        return this;
    }
    @Step
    public CardLockUnlockSteps closeLockNotification() {
        closeNotification.click();
        return this;
    }
    @Step
    public CardLockUnlockSteps unlockDecline() {
        unlock.shouldBe(visible, Duration.ofSeconds(3)).click();
        decline.click();
        return this;
    }
    @Step
    public CardLockUnlockSteps unlockClose(){
        unlock.click();
        close.click();
        return this;
    }
    @Step
    public CardLockUnlockSteps unlockCard() {
        unlock.click();
        unlockButton.click();
        return this;
    }
    @Step
    public CardLockUnlockSteps checkUnlock() {
        String lockSuccessfully = unlockSuccessful.getText();
        Assert.assertEquals(lockSuccessfully, "ბარათი წარმატებით განიბლოკა");
        return this;
    }
    @Step
    public CardLockUnlockSteps closeUnlockNotification() {
        closeNotification.click();
        return this;
    }
}
