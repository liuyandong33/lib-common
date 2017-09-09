package build.dream.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NamingStrategyUtils {
    public static String underscoreToCamelCase(String underscore) {
        StringBuffer camelCase = new StringBuffer();
        String[] underscoreArray = underscore.split("_");
        camelCase.append(underscoreArray[0]);
        int length = underscoreArray.length;
        for (int index = 1; index < length; index++) {
            String underscoreSplit = underscoreArray[index];
            if (underscoreSplit.length() == 1) {
                camelCase.append(underscoreSplit.toUpperCase());
            } else {
                camelCase.append(underscoreSplit.substring(0, 1).toUpperCase()).append(underscoreSplit.substring(1, underscoreSplit.length()));
            }
        }
        return camelCase.toString();
    }

    private static Pattern camelCasePattern = Pattern.compile("[A-Z]");
    public static String camelCaseToUnderscore(String camelCase) {
        Matcher matcher = camelCasePattern.matcher(camelCase);
        StringBuffer underscoreStringBuffer = new StringBuffer();
        while(matcher.find()){
            matcher.appendReplacement(underscoreStringBuffer, "_" + matcher.group(0).toLowerCase());
        }
        matcher.appendTail(underscoreStringBuffer);
        return underscoreStringBuffer.toString();
    }

    public static void main(String[] args) {
        System.out.println(camelCaseToUnderscore("dietOrderYInfoId"));
    }
}
