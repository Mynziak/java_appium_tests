package utils;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.sql.Timestamp;
import java.util.Date;

public class StringMan {

    public static String makeUniqueEmail(String email) {
        if (email.contains("@")) {
            int atIndex = email.indexOf('@');
            Date date = new Date();
            Timestamp ts = new Timestamp(date.getTime());
            String result = email.substring(0, atIndex) + "+" + ts.getTime() + email.substring(atIndex);
            Logger.info("Unique email: [" + result + "]");
            return result;
        } else {
            return "";
        }
    }

    public static String removeSchemeFromUrl(String url) {
        Logger.info("Removing [http://] or [https://] from url: [" + url + "]");
        String resultUrl = url;
        String regex = ".*?:\\/\\/";
        return resultUrl.replaceAll(regex, "");
    }

    public static String jsonPrettyPrint(String json) {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine scriptEngine = manager.getEngineByName("JavaScript");
        scriptEngine.put("jsonString", json);
        try {
            scriptEngine.eval("result = JSON.stringify(JSON.parse(jsonString), null, 2)");
        } catch (ScriptException e) {
            return json;
        }
        return (String) scriptEngine.get("result");
    }
}
