package utils;

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
}
