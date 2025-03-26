package MyCredoE2E.Steps;

import MyCredoE2E.Elements.DownloadRequisitesElements;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.testng.Assert;
import java.io.File;

public class DownloadRequisitesSteps extends DownloadRequisitesElements {
    File downloadedFile = new File(System.getProperty("user.home") + "/Downloads/Requisites.pdf");

    @Step
    public DownloadRequisitesSteps deleteExistingFile() {
        if (downloadedFile.exists()) {
            downloadedFile.delete();
        }
        return this;
    }
    @Step
    public DownloadRequisitesSteps downloadRequisites() {
        requisite.click();
        Selenide.sleep(10000);
        return this;
    }
    @Step
    public DownloadRequisitesSteps checkDownload() {
        Assert.assertEquals(downloadedFile.getName(), "Requisites.pdf");
        return this;
    }
}