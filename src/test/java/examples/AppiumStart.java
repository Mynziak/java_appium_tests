package examples;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MydocsPage;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumStart {

    private String emaiil = "df_autotestGeneral+help+8test_noEmail8+1522743896068@support.pdffiller.com";
    private String password = "1";
    private AppiumDriver<MobileElement> driver;

    @BeforeTest
    private void preconditions() throws MalformedURLException {

        File classPathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classPathRoot, "src/app");
        File app = new File(appDir, "app_mydocs-debug.apk");

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung Galaxy S5");
        caps.setCapability(MobileCapabilityType.UDID, "192.168.43.101:5555"); //it's id of android device - found in
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0");
        caps.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 300);
        caps.setCapability("appPackage", "com.pdffiller");
        caps.setCapability("appActivity", "com.ref.login_screen.LoginActivity");

        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void loginTest() {

        LoginPage loginPage = new LoginPage(driver);
        MydocsPage mydocsPage = loginPage.login(emaiil, password);
    }
}
