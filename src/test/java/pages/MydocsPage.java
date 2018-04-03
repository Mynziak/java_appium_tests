package pages;

import core.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import static org.testng.Assert.assertTrue;

public class MydocsPage extends BasePage {

    public MydocsPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public void isOpened() {
        By tabs = By.className("android.widget.TabWidget");
        assertTrue(isElementPresent(tabs, 30), "Mydocs is not openeed!");
    }

    public void openTab (String tabName) {
       // android.widget.RelativeLayout
    }



}
