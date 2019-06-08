package build.dream.common.utils;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by liuyandong on 2017/7/3.
 */
public class SerialNumberGenerator {
    public static String nextSerialNumber(int digit, int currentValue) {
        String currentValueString = String.valueOf(currentValue);
        int length = currentValueString.length();
        ValidateUtils.isTrue(length <= digit, "当前值长度超过指定长度！");
        int zeroCount = digit - length;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < zeroCount; i++) {
            stringBuffer.append("0");
        }
        return stringBuffer.append(currentValueString).toString();
    }

    public static String nextOrderNumber(String prefix, int digit, int currentValue) {
        return prefix + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + nextSerialNumber(digit, currentValue);
    }

    public static String generatorTodaySequenceName(String sequenceName) {
        return new SimpleDateFormat("yyyyMMdd").format(new Date()) + "_" + sequenceName;
    }

    public static String generatorTodaySequenceName(BigInteger tenantId, BigInteger branchId, String sequenceName) {
        return new SimpleDateFormat("yyyyMMdd").format(new Date()) + "_" + tenantId + "_" + branchId + "@" + sequenceName;
    }
}
