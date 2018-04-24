package pages;

import core.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import static org.testng.Assert.assertTrue;

public class EditorPage extends BasePage {

    public EditorPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @Override
    public void isOpened() {
        By editorContent = By.id("android:id/content");
        assertTrue (isElementPresent(editorContent, 30), "EditorPage is not opened!");
    }

    public ChoicePage clickDone () {
        By done_button = By.id("com.pdffiller:id/done_btn");
        assertTrue(isElementPresent(done_button), "Done button is absent!");
        click(done_button);
        ChoicePage choice = new ChoicePage(driver);
        choice.isOpened();
        return choice;
    }
}
