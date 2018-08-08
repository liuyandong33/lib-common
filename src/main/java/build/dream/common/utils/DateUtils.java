package build.dream.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static Date parse(String source, String pattern) {
        Date date = null;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            date = simpleDateFormat.parse(source);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return date;
    }

    public static String format(Date date, String pattern) {
        return new SimpleDateFormat(pattern).format(date);
    }
}
