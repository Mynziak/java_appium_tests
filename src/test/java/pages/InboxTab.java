package pages;

import core.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import static org.testng.Assert.assertTrue;

public class InboxTab extends MydocsPage {

    public InboxTab(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @Override
    public void isOpened() {

    }
}
