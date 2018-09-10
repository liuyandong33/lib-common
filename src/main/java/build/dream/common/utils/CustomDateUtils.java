package build.dream.common.utils;

import build.dream.common.constants.Constants;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;

public class CustomDateUtils {
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

    public static SimpleDateFormat buildISO8601SimpleDateFormat() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constants.ISO8601_DATE_PATTERN, Locale.US);
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, Constants.GMT));
        return simpleDateFormat;
    }
}
