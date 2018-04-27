package build.dream.common.utils;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.apache.commons.lang.ArrayUtils;

public class ChineseUtils {
    private static HanyuPinyinOutputFormat hanyuPinyinOutputFormat;

    static {
        hanyuPinyinOutputFormat = new HanyuPinyinOutputFormat();
        hanyuPinyinOutputFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
    }

    public static String[] obtainPinyinStringArray(char chinese) throws BadHanyuPinyinOutputFormatCombination {
        return PinyinHelper.toHanyuPinyinStringArray(chinese, hanyuPinyinOutputFormat);
    }

    public static boolean isChinese(char c) {
        return c >= 0x4E00 && c <= 0x9FA5;
    }

    public static String obtainPinyinFirstLetter(String str) throws BadHanyuPinyinOutputFormatCombination {
        str = str.replace(" ", "");
        char[] charArray = str.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : charArray) {
            if (isChinese(c)) {
                String[] pinyinStringArray = obtainPinyinStringArray(c);
                if (ArrayUtils.isNotEmpty(pinyinStringArray)) {
                    stringBuilder.append(pinyinStringArray[0].charAt(0));
                }
            } else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }
}
