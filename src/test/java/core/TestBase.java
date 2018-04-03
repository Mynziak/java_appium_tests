package core;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static final String DEFAULT_PASSWORD = "qwe1rty2";
    private String firstAppActivityName = "com.ref.login_screen.LoginActivity";
    private String appPackageName = "com.pdffiller";
    private String androidDeviceUdid = "192.168.43.101:5555";
    private String deviceName = "Samsung Galaxy S5";
    private AppiumDriver<MobileElement> driver;
    private String applicationName = "app_mydocs-debug.apk";
    public TestData testData = new TestData();
    public static final String DEFAULT_URL = "https://www.pdffiller.com";
    public static final String DEFAULT_EMAIL = "NO_EMAIL";

    @BeforeTest
    @Parameters({"platform", "url", "email", "password"})
    protected void beforeTest(@Optional(MobilePlatform.ANDROID) String platform,
                              @Optional(DEFAULT_URL) String url,
                              @Optional(DEFAULT_EMAIL) String email,
                              @Optional(DEFAULT_EMAIL) String password) throws MalformedURLException {

        //set directory od application:
        File classPathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classPathRoot, "src/app");
        File app = new File(appDir, applicationName);

        //specify capabilities:
        DesiredCapabilities caps = new DesiredCapabilities();
        if (platform.equalsIgnoreCase(MobilePlatform.ANDROID)) {
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        } else {
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
        }
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        caps.setCapability(MobileCapabilityType.UDID, androidDeviceUdid); //it's id of android device - found in
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0");
        caps.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 300);  // After this time app will close
        caps.setCapability("appPackage", appPackageName);
        caps.setCapability("appActivity", firstAppActivityName);
        driver = getDriver(platform, caps);

        //set test data:
        this.testData.url = url;
        this.testData.emails.add(email);
        this.testData.password = password;
    }

    public AppiumDriver<MobileElement> getDriver() {
        return this.driver;
    }

    protected AppiumDriver<MobileElement> getDriver(String platform, DesiredCapabilities caps) throws MalformedURLException {
        if (platform.equals(MobilePlatform.ANDROID)) {
            driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        } else {
            driver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps); //TODO : fix this if it doesn't work!
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return getDriver();
    }
}