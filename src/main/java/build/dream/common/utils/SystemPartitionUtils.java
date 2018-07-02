package build.dream.common.utils;

import build.dream.common.constants.Constants;

import java.io.IOException;

/**
 * Created by liuyandong on 2017/7/24.
 */
public class SystemPartitionUtils {
    public static String getOutsideServiceDomain(String partitionCode, String serviceName) throws IOException {
        String homeUrl = ConfigurationUtils.getConfiguration(Constants.HOME_URL);
        return homeUrl + "/" + partitionCode + "-" + serviceName;
    }

    public static String getOutsideServiceDomain(String serviceName) throws IOException {
        String domainName = ConfigurationUtils.getConfiguration(Constants.HOME_URL);
        return domainName + "/" + serviceName;
    }

    public static String getOutsideUrl(String partitionCode, String serviceName, String controllerName, String actionName) throws IOException {
        return getOutsideServiceDomain(partitionCode, serviceName) + "/" + controllerName + "/" + actionName;
    }

    public static String getOutsideUrl(String serviceName, String controllerName, String actionName) throws IOException {
        return getOutsideServiceDomain(serviceName) + "/" + controllerName + "/" + actionName;
    }
}
