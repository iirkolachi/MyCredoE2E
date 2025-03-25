package MyCredoE2E.Steps;

import MyCredoE2E.Elements.CardLockUnlockElements;
import io.qameta.allure.Step;
import org.testng.Assert;
import java.time.Duration;
import static com.codeborne.selenide.Condition.visible;

public class CardLockUnlockSteps extends CardLockUnlockElements {
    @Step
    public CardLockUnlockSteps lockDecline() {
        lock.shouldBe(visible, Duration.ofSeconds(20)).click();
        decline.shouldBe(visible, Duration.ofSeconds(20)).click();
        return this;
    }
    @Step
    public CardLockUnlockSteps lockClose() {
        lock.shouldBe(visible, Duration.ofSeconds(20)).click();
        close.shouldBe(visible, Duration.ofSeconds(20)).click();
        return this;
    }
    @Step
    public CardLockUnlockSteps lockCard() {
        lock.shouldBe(visible, Duration.ofSeconds(20)).click();
        lockButton.shouldBe(visible, Duration.ofSeconds(20)).click();
        return this;
    }
    @Step
    public CardLockUnlockSteps checkLock() {
        String lockSuccessfully = lockSuccessful.shouldBe(visible, Duration.ofSeconds(20)).getText();
        Assert.assertEquals(lockSuccessfully, "ბარათი წარმატებით დაიბლოკა");
        return this;
    }
    @Step
    public CardLockUnlockSteps closeLockNotification() {
        closeNotification.shouldBe(visible, Duration.ofSeconds(20)).click();
        return this;
    }
    @Step
    public CardLockUnlockSteps unlockDecline() {
        unlock.shouldBe(visible, Duration.ofSeconds(20)).click();
        decline.shouldBe(visible, Duration.ofSeconds(20)).click();
        return this;
    }
    @Step
    public CardLockUnlockSteps unlockClose(){
        unlock.shouldBe(visible, Duration.ofSeconds(20)).click();
        close.shouldBe(visible, Duration.ofSeconds(20)).click();
        return this;
    }
    @Step
    public CardLockUnlockSteps unlockCard() {
        unlock.shouldBe(visible, Duration.ofSeconds(20)).click();
        unlockButton.shouldBe(visible, Duration.ofSeconds(20)).click();
        return this;
    }
    @Step
    public CardLockUnlockSteps checkUnlock() {
        String lockSuccessfully = unlockSuccessful.shouldBe(visible, Duration.ofSeconds(20)).getText();
        Assert.assertEquals(lockSuccessfully, "ბარათი წარმატებით განიბლოკა");
        return this;
    }
    @Step
    public CardLockUnlockSteps closeUnlockNotification() {
        closeNotification.shouldBe(visible, Duration.ofSeconds(20)).click();
        return this;
    }
}
