package build.dream.common.utils;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

public class ChineseUtils {
    private static HanyuPinyinOutputFormat hanyuPinyinOutputFormat;

    static {
        hanyuPinyinOutputFormat = new HanyuPinyinOutputFormat();
        hanyuPinyinOutputFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
    }

    public static String[] obtainPinyinStringArray(char chinese) {
        return ApplicationHandler.callMethodSuppressThrow(() -> PinyinHelper.toHanyuPinyinStringArray(chinese, hanyuPinyinOutputFormat));
    }

    public static boolean isChinese(char c) {
        return c >= 0x4E00 && c <= 0x9FA5;
    }

    public static boolean isNotChinese(char c) {
        return !isChinese(c);
    }

    public static String obtainPinyinFirstLetter(String chinese) {
        String str = StringUtils.deleteWhitespace(chinese);
        char[] charArray = str.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : charArray) {
            if (isNotChinese(c)) {
                stringBuilder.append(c);
                continue;
            }

            String[] pinyinStringArray = obtainPinyinStringArray(c);
            if (ArrayUtils.isEmpty(pinyinStringArray)) {
                continue;
            }

            stringBuilder.append(pinyinStringArray[0].charAt(0));
        }
        return stringBuilder.toString();
    }

    public static String obtainPinyin(String chinese) {
        String str = StringUtils.deleteWhitespace(chinese);
        char[] charArray = str.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : charArray) {
            if (isNotChinese(c)) {
                stringBuilder.append(c);
                continue;
            }
            String[] pinyinStringArray = obtainPinyinStringArray(c);
            if (ArrayUtils.isEmpty(pinyinStringArray)) {
                continue;
            }

            stringBuilder.append(pinyinStringArray[0]);
        }
        return stringBuilder.toString();
    }
}
