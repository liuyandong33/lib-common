package build.dream.common.utils;

import build.dream.common.constants.Constants;

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
}
