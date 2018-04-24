package tests;

import core.PDFfillerTest;
import data.ConstantsData;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;
import utils.StringMan;
import utils.TimeMan;

public class RegistrationTest extends PDFfillerTest {

    private String email;
    private AppiumDriver<MobileElement> driver;
        private String formName = "Get a Document Signed";

        @BeforeTest
        public void setup() {
            this.email = StringMan.makeUniqueEmail(testData.emails.get(0));
            this.driver = getDriver();
        }

        @Test
        public void openEditorTest() {

        //1. Register User:
        LoginPage loginPage = new LoginPage(driver);
        MydocsPage mydocsPage = loginPage.register(email, testData.password);

        //2. Open in sharedWithMe folder:
        InboxTab inboxTab = mydocsPage.openTab(ConstantsData.MyDocs.TabList.inbox);
        inboxTab.openFolder(ConstantsData.MyDocs.FolderList.sharedWithMe);
        inboxTab.back();

        //3. Open Unsorted folder:
        MyBoxTab myBoxTab = mydocsPage.openTab(ConstantsData.MyDocs.TabList.mybox);
        myBoxTab.openFolder(ConstantsData.MyDocs.FolderList.unsorted);

        //4. Select form:
        Actions actions = myBoxTab.tapForm(formName);

        //5. Open form:
        actions.open();
        TimeMan.sleep(15);
    }
}
