package MyCredoE2E.Steps;

import MyCredoE2E.Elements.NextCardElements;
import io.qameta.allure.Step;
import org.testng.Assert;

public class NextCardSteps extends NextCardElements {
    public static String firstAccNumber;
    public static String secondAccNumber;

    @Step
    public NextCardSteps takeFirstAccNumber() {
        firstAccNumber = firstCardAccNumber.getText();
        return this;
    }
    @Step
    public NextCardSteps clickNextButton() {
        nextButton.click();
        return this;
    }
    @Step
    public NextCardSteps takeSecondAccNumber() {
        secondAccNumber = secondCardAccNumber.getText();
        return this;
    }
    @Step
    public NextCardSteps checkCardChange() {
        Assert.assertNotSame(firstAccNumber, secondAccNumber);
        return this;
    }
    @Step
    public NextCardSteps backToFirstCard() {
    previousButton.click();
    return this;
    }
}
