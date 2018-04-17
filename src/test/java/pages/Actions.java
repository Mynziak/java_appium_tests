package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import static org.testng.Assert.assertTrue;

public class Actions extends MydocsPage{

    public Actions(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public void open() {
        By open_button = By.id("com.pdffiller:id/form_action_fragment_button_fill");
        assertTrue(isElementPresent(open_button));
        click(open_button);
    }
}
