package utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeMan {
    public static Date getCurrentDate() {
        return Calendar.getInstance().getTime();
    }

    public static String getCurrentDate(String format) {
        DateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(Calendar.getInstance().getTime());
    }

    public static void sleep(int seconds) {
        Logger.info("Sleeping for [" + seconds + "] seconds");
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
