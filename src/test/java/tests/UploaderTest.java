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

public class UploaderTest extends PDFfillerTest {

    private String email;
    private AppiumDriver<MobileElement> driver;
    private String formName = "pdf-test";
    private String pdfUrl = "http://www.orimi.com/pdf-test.pdf";

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

        //2. Open Unsorted folder:
        MyBoxTab myBoxTab = mydocsPage.openTab(ConstantsData.MyDocs.TabList.mybox);
        myBoxTab.openFolder(ConstantsData.MyDocs.FolderList.unsorted);

        //3. Upload Document from Uploader
        UploaderPage uploader = myBoxTab.openUploader();
        EnterUrlDocumentPage enterUrlDocumentPage = uploader.addUrlDocument();
        EditorPage editorPage = enterUrlDocumentPage.enterUrl(pdfUrl);
        ChoicePage choice = editorPage.clickDone();
        choice.goToMyDocs();
        myBoxTab.isOpened();


        //3. Select form:
        Actions actions = myBoxTab.tapForm(formName);

        //4. Open form:
        EditorPage editor = actions.open();

        TimeMan.sleep(15);
    }
}