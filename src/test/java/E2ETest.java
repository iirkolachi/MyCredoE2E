import MyCredoE2E.Steps.*;
import org.testng.annotations.Test;
import java.sql.SQLException;

public class E2ETest {
    AuthorizationSteps authorizationSteps = new AuthorizationSteps();
    ProductPageSteps productPageSteps = new ProductPageSteps();
    CardPageSteps cardPageSteps = new CardPageSteps();
    CardLockUnlockSteps cardLockUnlockSteps = new CardLockUnlockSteps();
    PinResetSteps pinResetSteps = new PinResetSteps();

    @Test
    public void e2eTest() throws SQLException {
        authorizationSteps
                .openWebsite()
                .enterUserData()
                .closePopup()
                .checkLogin();

        productPageSteps
                .goToProductsPage()
                .openCards();

        cardPageSteps
                .checkCardName()
                .compareIndividualBalances()
                .compareSumBalances();

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
                .checkPinReset();
    }
}