package pages;

import core.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import static org.testng.Assert.assertTrue;

public class LoginPage extends BasePage {

    public LoginPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public MydocsPage login(String email, String password) {
        By email_field = By.id("com.pdffiller:id/et_login");
        assertTrue(isElementPresent(email_field, 5), "Email field is absent!");
        type(email_field, email);

        By password_field = By.id("com.pdffiller:id/et_password");
        assertTrue(isElementPresent(password_field, 2), "Password field is absent!");
        type(password_field, password);
        By login_button = By.id("com.pdffiller:id/sign_in_register");
        assertTrue(isElementPresent(login_button), "Login button is absent!");
        click(login_button);

//        driver.findElement(By.id("com.pdffiller:id/et_login")).sendKeys(email);
//        driver.findElement(By.id("com.pdffiller:id/et_password")).sendKeys(password);
//        driver.findElement(By.id("com.pdffiller:id/sign_in_register")).click();
        return new MydocsPage(driver);
    }

    public MydocsPage register(String email, String password) {
        By register_switcher = By.id("com.pdffiller:id/change_sign_type");
        assertTrue(isElementPresent(register_switcher), "Register button switcher is absent!");
        click(register_switcher);

        By email_field = By.id("com.pdffiller:id/et_login");
        assertTrue(isElementPresent(email_field, 5), "Email field is absent!");
        type(email_field, email);

        By password_field = By.id("com.pdffiller:id/et_password");
        assertTrue(isElementPresent(password_field, 2), "Password field is absent!");
        type(password_field, password);

        By register_button = By.id("com.pdffiller:id/sign_in_register");
        assertTrue(isElementPresent(register_button), "Login button is absent!");
        click(register_button);
        return new MydocsPage(driver);
    }
}
