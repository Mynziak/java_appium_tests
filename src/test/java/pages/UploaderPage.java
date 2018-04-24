package pages;

import core.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import static org.testng.Assert.assertTrue;

public class UploaderPage extends BasePage {

    private By enterUrlDoc_button = By.id("com.pdffiller:id/from_url_button");

    public UploaderPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @Override
    public void isOpened() {
        assertTrue(isElementPresent(enterUrlDoc_button), "Uploader is not opened!");
    }

    public EnterUrlDocumentPage addUrlDocument() {
        click(enterUrlDoc_button);
        EnterUrlDocumentPage enterUrlDocumentPage = new EnterUrlDocumentPage(driver);
        enterUrlDocumentPage.isOpened();
        return enterUrlDocumentPage;
    }
}
