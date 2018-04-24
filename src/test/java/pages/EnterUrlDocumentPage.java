package pages;

import core.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import static org.testng.Assert.assertTrue;

public class EnterUrlDocumentPage extends BasePage {

    private By url_input = By.id("com.pdffiller:id/sourseText");

    public EnterUrlDocumentPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @Override
    public void isOpened() {
        assertTrue(isElementPresent(url_input, 15), "Enter URL page is not opened~!");
    }
    public EditorPage enterUrl (String url){
        type(url_input, url);
        By fillNow_button = By.id("com.pdffiller:id/getForm");
        assertTrue(isElementPresent(fillNow_button), "Fill Now! buton is absent!");
        click(fillNow_button);
        EditorPage editorPage = new EditorPage(driver);
        editorPage.isOpened();
        return editorPage;
    }
}
