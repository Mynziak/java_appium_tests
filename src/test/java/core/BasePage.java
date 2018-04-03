package core;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import utils.Logger;
import utils.TimeMan;

import java.util.concurrent.TimeUnit;

public class BasePage {

    protected boolean android = false;
    protected boolean ios = false;

    protected AppiumDriver<MobileElement> driver;

    public BasePage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    //TODO: Use this method in Page classes where need to split platform (android or ios)
    public void setPlatformName() {
        String platformName = (String) driver.getCapabilities().getCapability("platformName");
        if (platformName.equalsIgnoreCase("Android")) {
            android = true;
        } else {
            ios = true;
        }
    }

    public boolean isElementPresent(final By locator, int seconds) {
        Logger.info("Checking is element [" + locator + "] present");
        Wait wait = new FluentWait(driver)
                .withTimeout(seconds, TimeUnit.SECONDS)
                .pollingEvery(500, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            return true;
        } catch (TimeoutException e) {
            Logger.warning("Element '" + locator + "' is not present");
            return false;
        }
    }

    protected void click(By locator) {
        Wait wait = new FluentWait(driver)
                .withTimeout(15, TimeUnit.SECONDS)
                .pollingEvery(500, TimeUnit.MILLISECONDS)
                .ignoring(ElementNotVisibleException.class).ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            Logger.info("Clicking on '" + locator + "'");
            driver.findElement(locator).click();
        } catch (TimeoutException e) {
            Logger.error("Can not click on element '" + locator + "'");
        }
    }

    public boolean isElementPresent(By locator) {
        return isElementPresent(locator, 2);
    }

    protected void type(final By locator, final String text) {
        if (isElementPresent(locator))
            try {
                Wait wait = new WebDriverWait(driver, 15);
                wait.until((ExpectedCondition<Boolean>) d -> {
                    try {
                        Logger.info("Typing '" + text + "' in '" + locator + "'");
                        TimeMan.sleep(1);
                        driver.findElement(locator).clear();
                        TimeMan.sleep(1);
                        driver.findElement(locator).sendKeys(text);
                        TimeMan.sleep(1);
                        return true;
                    } catch (InvalidElementStateException e) {
                        return false;
                    }
                });
            } catch (TimeoutException e) {
                Logger.error("Can not interact with element '" + locator + "'. Invalid state of element");
            }
    }
}
