package build.dream.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LunarCalendarUtils {
    private static String[] LUNAR_DATE_ARRAY = {
            "04BD8", "04AE0", "0A570", "054D5", "0D260", "0D950", "16554", "056A0", "09AD0", "055D2",
            "04AE0", "0A5B6", "0A4D0", "0D250", "1D255", "0B540", "0D6A0", "0ADA2", "095B0", "14977",
            "04970", "0A4B0", "0B4B5", "06A50", "06D40", "1AB54", "02B60", "09570", "052F2", "04970",
            "06566", "0D4A0", "0EA50", "06E95", "05AD0", "02B60", "186E3", "092E0", "1C8D7", "0C950",
            "0D4A0", "1D8A6", "0B550", "056A0", "1A5B4", "025D0", "092D0", "0D2B2", "0A950", "0B557",
            "06CA0", "0B550", "15355", "04DA0", "0A5B0", "14573", "052B0", "0A9A8", "0E950", "06AA0",
            "0AEA6", "0AB50", "04B60", "0AAE4", "0A570", "05260", "0F263", "0D950", "05B57", "056A0",
            "096D0", "04DD5", "04AD0", "0A4D0", "0D4D4", "0D250", "0D558", "0B540", "0B6A0", "195A6",
            "095B0", "049B0", "0A974", "0A4B0", "0B27A", "06A50", "06D40", "0AF46", "0AB60", "09570",
            "04AF5", "04970", "064B0", "074A3", "0EA50", "06B58", "055C0", "0AB60", "096D5", "092E0",
            "0C960", "0D954", "0D4A0", "0DA50", "07552", "056A0", "0ABB7", "025D0", "092D0", "0CAB5",
            "0A950", "0B4A0", "0BAA4", "0AD50", "055D9", "04BA0", "0A5B0", "15176", "052B0", "0A930",
            "07954", "06AA0", "0AD50", "05B52", "04B60", "0A6E6", "0A4E0", "0D260", "0EA65", "0D530",
            "05AA0", "076A3", "096D0", "04BD7", "04AD0", "0A4D0", "1D0B6", "0D250", "0D520", "0DD45",
            "0B5A0", "056D0", "055B2", "049B0", "0A577", "0A4B0", "0AA50", "1B255", "06D20", "0ADA0",
            "14B63"};

    public static String obtainLunarDate(Date date) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date signDate = simpleDateFormat.parse("1900-01-31 00:00:00");
        long total = (date.getTime() - signDate.getTime()) / 86400000 + 1;
        return null;
    }

    public static int obtainTotalDays(String lunarDate) {
        return 100;
    }

    public static int[] obtainLunarDate(String lunarDate) {
        int[] array = new int[14];
        array[0] = Integer.valueOf(lunarDate.charAt(0) + "");
        return null;
    }
}
