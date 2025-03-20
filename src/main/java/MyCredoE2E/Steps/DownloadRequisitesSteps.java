package MyCredoE2E.Steps;

import MyCredoE2E.Elements.DownloadRequisitesElements;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.testng.Assert;
import java.io.File;

public class DownloadRequisitesSteps extends DownloadRequisitesElements {
    File file = new File(Configuration.downloadsFolder + "\\Requisites.pdf");

    @Step
    public DownloadRequisitesSteps deleteExistingFile() {
        if (file.exists()) {
            boolean deleted = file.delete();
            if (deleted) {
                System.out.println("Existing file deleted successfully: " + file.getName());
            } else {
                System.out.println("Failed to delete the existing file: " + file.getName());
            }
        } else {
            System.out.println("No existing file found to delete.");
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
        Assert.assertTrue(file.exists());
        return this;
    }
}
