package build.dream.common.utils;

import build.dream.common.constants.Constants;
import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.math.BigInteger;

public class CommonUtils {
    public static String getServiceName(String business) {
        String serviceName = null;
        if (Constants.BUSINESS_CATERING.equals(business)) {
            serviceName = Constants.SERVICE_NAME_CATERING;
        } else if (Constants.BUSINESS_RETAIL.equals(business)) {
            serviceName = Constants.SERVICE_NAME_RETAIL;
        }
        return serviceName;
    }

    public static BigInteger getServiceSystemUserId(String partitionCode, String serviceName) throws IOException {
        String userId = ConfigurationUtils.getConfiguration(partitionCode + "." + serviceName + ".user.id");
        if (StringUtils.isNotBlank(userId)) {
            return BigInteger.valueOf(Long.valueOf(userId));
        }
        return null;
    }

    public static BigInteger getServiceSystemUserId() throws IOException {
        String partitionCode = ConfigurationUtils.getConfiguration(Constants.PARTITION_CODE);
        String serviceName = ConfigurationUtils.getConfiguration(Constants.SERVICE_NAME);
        return getServiceSystemUserId(partitionCode, serviceName);
    }
}
