package core;

import utils.Logger;
import utils.TimeMan;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;

public class PDFfillerTest extends TestBase{

    /*protected HashMap<String, String> uploadForm(String email, String password, String pdfLinkForm, String newNamePart) throws IOException, URISyntaxException {
        Logger.info("Uploading .pdf file from Link");
        ApiV3 apiV3 = new ApiV3(testData.url, email, password);
        Users_Login sender = apiV3.users().login(email, password);
        String project_name = newNamePart + TimeMan.getCurrentDate("dd-MM-yyyy_HH-mm-ss");

        Upload_File upload_link = apiV3.upload(sender.token, sender.userId).uploadLink(pdfLinkForm);
        Integer project_id = upload_link.id;
        Projects_Rename projects_rename = apiV3.projects(sender.token, sender.userId).rename(project_id.toString(), project_name);
        checkTrue(projects_rename.result, "Project wasn't renamed after request");
        HashMap<String, String> projectFromApi = new HashMap<>();
        projectFromApi.put("id", project_id.toString());
        projectFromApi.put("name", project_name);
        return projectFromApi;
    }*/
}
