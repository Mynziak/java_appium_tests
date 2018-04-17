package api.requests;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.fluent.Request;
import org.apache.http.util.EntityUtils;
import utils.Logger;
import utils.StringMan;

import java.io.IOException;
import java.net.URI;

public class ApiBase {

    protected String token;
    protected String userId;

    protected String scheme = "https";
    protected String device = "web";
    protected String appKey = "AutoTest343_13FmciS";
    protected String host;

    protected ApiBase(String hostUrl) {
        host = StringMan.removeSchemeFromUrl(hostUrl);
    }

    public void setTokenAndUserId(String token, String userId) {
        this.token = token;
        this.userId = userId;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    protected String getResponseBody(HttpResponse resp) throws ParseException, IOException {
        String respBody = EntityUtils.toString(resp.getEntity());
        Logger.info("RESPONSE:\n" + StringMan.jsonPrettyPrint(respBody));
        return respBody;
    }

    protected HttpResponse getRequestWithHeaders(URI uri) throws IOException {
        return Request.Get(uri)
                .addHeader("appKey", appKey)
                .addHeader("token", token)
                .addHeader("userId", userId)
                .execute().returnResponse();
    }

    protected Request post(URI uri) throws IOException {
        return Request.Post(uri)
                .addHeader("appKey", appKey)
                .addHeader("token", token)
                .addHeader("userId", userId);
    }

    protected Request put(URI uri) throws IOException {

        return Request.Put(uri)
                .addHeader("appKey", appKey)
                .addHeader("token", token)
                .addHeader("userId", userId);
    }
}
