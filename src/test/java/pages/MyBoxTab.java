package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import static org.testng.Assert.assertTrue;

public class MyBoxTab extends MydocsPage {

    public MyBoxTab(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public void isOpened() {

    }

    public Actions tapForm(String formName) {
        By formName_locator = By.xpath("//*[@resource-id='com.pdffiller:id/text1'][@text='" + formName + "']");
        assertTrue(isElementPresent(formName_locator), "Form [ " + formName + " ] is absent!");
        click(formName_locator);
        return new Actions(driver);
    }
}
