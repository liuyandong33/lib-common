package build.dream.common.utils;

import build.dream.common.constants.Constants;
import org.apache.commons.lang.StringUtils;

import java.io.IOException;

/**
 * Created by liuyandong on 2017/7/24.
 */
public class SystemPartitionUtils {
    public static String getServiceDomain(String partitionCode, String serviceName) throws IOException {
        String serviceDomain = PropertyUtils.getProperty(partitionCode + "." + serviceName + ".service.connection");
        if (StringUtils.isBlank(serviceDomain)) {
            String deploymentEnvironment = PropertyUtils.getProperty(Constants.DEPLOYMENT_ENVIRONMENT);
            serviceDomain = CacheUtils.hget(Constants.KEY_SERVICE_DOMAIN, "_" + deploymentEnvironment + "_" + partitionCode + "_" + serviceName);
        }
        return serviceDomain;
    }

    public static String getOutsideServiceDomain(String partitionCode, String serviceName) throws IOException {
        String outsideServiceDomain = PropertyUtils.getProperty("outside." + partitionCode + "." + serviceName + ".service.connection");
        if (StringUtils.isBlank(outsideServiceDomain)) {
            String deploymentEnvironment = PropertyUtils.getProperty(Constants.KEY_OUTSIDE_SERVICE_DOMAIN);
            outsideServiceDomain = CacheUtils.hget(Constants.KEY_OUTSIDE_SERVICE_DOMAIN, "_" + deploymentEnvironment + "_" + partitionCode + "_" + serviceName);
        }
        return outsideServiceDomain;
    }

    public static String getUrl(String partitionCode, String serviceName, String controllerName, String actionName) throws IOException {
        return getServiceDomain(partitionCode, serviceName) + "/" + controllerName + "/" + actionName;
    }

    public static String getOutsideUrl(String partitionCode, String serviceName, String controllerName, String actionName) throws IOException {
        return getOutsideServiceDomain(partitionCode, serviceName) + "/" + controllerName + "/" + actionName;
    }
}
