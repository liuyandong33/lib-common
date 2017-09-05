package build.dream.common.utils;

public class NamingStrategyUtils {
    public static String underscoreToCamelCase(String underscore) {
        long start = System.currentTimeMillis();
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
        System.out.println(System.currentTimeMillis() - start);
        return camelCase.toString();
    }
}
