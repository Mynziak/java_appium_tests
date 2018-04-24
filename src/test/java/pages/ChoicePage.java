package pages;

import core.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import static org.testng.Assert.assertTrue;

public class ChoicePage extends BasePage {

    public ChoicePage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @Override
    public void isOpened() {
        By whatWouldLikeToDo_title = By.xpath("//*[@class='android.widget.TextView'][@text='What Would You like to Do?']");
        assertTrue(isElementPresent(whatWouldLikeToDo_title), "Choice page is not opened!");
    }

    public MydocsPage goToMyDocs() {
        By goToMyDocs_button = By.xpath("//*[@class='android.widget.TextView'][@text='Go to MY DOCS']");
        assertTrue(isElementPresent(goToMyDocs_button), "Go to MY DOCS is absent!");
        click(goToMyDocs_button);
        return new MydocsPage(driver);
    }
}
