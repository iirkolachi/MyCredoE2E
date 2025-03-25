import MyCredoE2E.Steps.*;
import org.testng.annotations.Test;
import java.sql.SQLException;

public class E2ETest {
    AuthorizationSteps authorizationSteps = new AuthorizationSteps();
    ProductPageSteps productPageSteps = new ProductPageSteps();
    CardPageSteps cardPageSteps = new CardPageSteps();
    CardLockUnlockSteps cardLockUnlockSteps = new CardLockUnlockSteps();
    PinResetSteps pinResetSteps = new PinResetSteps();
    DownloadRequisitesSteps downloadRequisitesSteps = new DownloadRequisitesSteps();
    NextCardSteps nextCardSteps = new NextCardSteps();
    TransferSteps transferSteps = new TransferSteps();

    @Test
    public void e2eTest() throws SQLException {
        authorizationSteps
                .openWebsite("https://testmycredo.credo.ge/landing/main/auth")
                .enterUsername("IILO2020")
                .enterPassword("Xeleeee1")
                .clickEnter()
                .otpPopup()
                .easyAuthPopup_checkAuth();

        productPageSteps
                .goToProductsPage()
                .openAccsAndCards()
                .openCards();

        cardPageSteps
                .checkCardName()
                .checkBalances();

        cardLockUnlockSteps
                .lockDecline()
                .lockClose()
                .lockCard()
                .checkLock()
                .closeLockNotification()
                .unlockDecline()
                .unlockClose()
                .unlockCard()
                .checkUnlock()
                .closeUnlockNotification();

        pinResetSteps
                .resetDecline()
                .resetClose()
                .otpClose()
                .otpTimeExpire()
                .checkWrongOtp()
                .closeWrongOtpNotification()
                .resetPin()
                .checkPinReset()
                .closePinResetNotification();

        downloadRequisitesSteps
                .deleteExistingFile()
                .downloadRequisites()
                .checkDownload();

        nextCardSteps
                .takeFirstAccNumber()
                .clickNextButton()
                .takeSecondAccNumber()
                .checkCardChange()
                .backToFirstCard();

        transferSteps
                .clickTranfer()
                .chooseOwnAcc()
                .takeOwnAccNumber()
                .clickWhereAcc()
                .chooseWhereAcc()
                .chooseCurrency()
                .takeAnotherAccNumber()
                .getBeforeAmounts()
                .amountInput()
                .tranfer()
                .tranferPopup()
                .checkTransferNotification()
                .closePopup()
                .moveToMainPage()
                .takeFirstTransfer()
                .firstTransferOpens()
                .checkTransferBetweenYourAccs()
                .takeOwnAccNumberfromTransactions()
                .takeAnotherAccNumberfromTransactions()
                .checkOwnAccs()
                .checkAnotherAccs()
                .getAfterAmounts()
                .checkFromBalances()
                .checkToBalances();
    }
}