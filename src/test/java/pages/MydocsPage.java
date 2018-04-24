package pages;

import core.BasePage;
import data.ConstantsData;
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

    public boolean isTabActive(String tabName) {
        By activeTab = By.xpath("//*[@resource-id='com.pdffiller:id/textView'][@text='" + tabName + "'][@selected = 'true']");
        return isElementPresent(activeTab);
    }

    public <T extends BasePage> T openTab(String tabName) {
        By tabTitle = By.xpath("//*[@resource-id='com.pdffiller:id/textView'][@text='" + tabName + "']");

        if (!isTabActive(tabName)) {
            click(tabTitle);
        }

        if (tabName.equalsIgnoreCase(ConstantsData.MyDocs.TabList.mybox)) {
            MyBoxTab myBoxTab = new MyBoxTab(driver);
            myBoxTab.isOpened();
            return (T) myBoxTab;
        } else if (tabName.equalsIgnoreCase(ConstantsData.MyDocs.TabList.cloud)) {
            CloudTab cloudTab = new CloudTab(driver);
            cloudTab.isOpened();
            return (T) cloudTab;
        } else if (tabName.equalsIgnoreCase(ConstantsData.MyDocs.TabList.inbox)) {
            InboxTab inboxTab = new InboxTab(driver);
            inboxTab.isOpened();
            return (T) inboxTab;
        } else if (tabName.equalsIgnoreCase(ConstantsData.MyDocs.TabList.outbox)) {
            OutboxTab outboxTab = new OutboxTab(driver);
            outboxTab.isOpened();
            return (T) outboxTab;
        }
        return (T) this;
    }

    public void openFolder(String folderName) {
        By folder_locator = By.xpath("//*[@resource-id='com.pdffiller:id/name'][@text='" + folderName + "']");
        assertTrue(isElementPresent(folder_locator, 5), "Folder is absent!");
        click(folder_locator);
        By folderTitle = By.xpath("//*[@resource-id='com.pdffiller:id/text'][@text='" + folderName + "']");
        assertTrue(isElementPresent(folderTitle, 5), "Folder is not opened!");
    }

    public void back() {
        By backArrow_button = By.id("com.pdffiller:id/back");
        assertTrue(isElementPresent(backArrow_button), "Back arrow button is absent!");
        click(backArrow_button);
    }

    public UploaderPage openUploader() {
        By plus_button = By.id("com.pdffiller:id/fab");
        assertTrue(isElementPresent(plus_button), "Add document \"plus\" button is absent!");
        click(plus_button);
        UploaderPage uploader = new UploaderPage(driver);
        uploader.isOpened();
        return uploader;
    }
}
