package api;

public class ApiV3 {
    private String host;
    private String email;
    private String password;

    public ApiV3(String hostUrl, String email, String password) {
        this.host = hostUrl;
        this.email = email;
        this.password = password;
    }

   /* public Projects_ApiV3 projects(String token, String userId) {
        Projects_ApiV3 projects = new Projects_ApiV3(host);
        projects.setTokenAndUserId(token, userId);
        return projects;
    }

    public Upload_ApiV3 upload(String token, String userId) {
        Upload_ApiV3 upload = new Upload_ApiV3(host);
        upload.setTokenAndUserId(token, userId);
        return upload;
    }*/

}
