package tests;

import core.TestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MydocsPage;
import utils.StringMan;

public class RegistrationTest extends TestBase {

    private String email;
    private AppiumDriver<MobileElement> driver;

    @BeforeTest
    public void setup() {
        this.email = StringMan.makeUniqueEmail(testData.emails.get(0));
        this.driver = getDriver();
    }


    @Test
    public void registrationTest() {
        LoginPage loginPage = new LoginPage(driver);
        MydocsPage mydocsPage = loginPage.register(email, testData.password);
       mydocsPage.isOpened();
    }
}
