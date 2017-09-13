package build.dream.common.utils;

import build.dream.common.constants.Constants;
import build.dream.common.saas.domains.SystemPartition;
import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liuyandong on 2017/7/24.
 */
public class SystemPartitionUtils {
    public static String getServiceDomain(String partitionCode, String serviceName) throws IOException {
        String serviceDomain = PropertyUtils.getProperty(partitionCode + "." + serviceName + ".service.connection");
        if (StringUtils.isBlank(serviceDomain)) {
            String deploymentEnvironment = PropertyUtils.getProperty(Constants.DEPLOYMENT_ENVIRONMENT);
            serviceDomain = CacheUtils.get(Constants.KEY_SERVICE_DOMAIN + "_" + deploymentEnvironment, "_" + deploymentEnvironment + "_" + partitionCode + "_" + serviceName);
        }
        return serviceDomain;
    }

    public static String getServiceDomain(String serviceName) throws IOException {
        String serviceDomain = PropertyUtils.getProperty(serviceName + ".service.connection");
        if (StringUtils.isBlank(serviceDomain)) {
            String deploymentEnvironment = PropertyUtils.getProperty(Constants.DEPLOYMENT_ENVIRONMENT);
            serviceDomain = CacheUtils.get(Constants.KEY_SERVICE_DOMAIN + "_" + deploymentEnvironment, "_" + deploymentEnvironment + "_" + serviceName);
        }
        return serviceDomain;
    }

    public static String getOutsideServiceDomain(String partitionCode, String serviceName) throws IOException {
        String outsideServiceDomain = PropertyUtils.getProperty("outside." + partitionCode + "." + serviceName + ".service.connection");
        if (StringUtils.isBlank(outsideServiceDomain)) {
            String deploymentEnvironment = PropertyUtils.getProperty(Constants.KEY_OUTSIDE_SERVICE_DOMAIN);
            outsideServiceDomain = CacheUtils.get(Constants.KEY_OUTSIDE_SERVICE_DOMAIN + "_" + deploymentEnvironment, "_" + deploymentEnvironment + "_" + partitionCode + "_" + serviceName);
        }
        return outsideServiceDomain;
    }

    public static String getOutsideServiceDomain(String serviceName) throws IOException {
        String outsideServiceDomain = PropertyUtils.getProperty("outside." + "." + serviceName + ".service.connection");
        if (StringUtils.isBlank(outsideServiceDomain)) {
            String deploymentEnvironment = PropertyUtils.getProperty(Constants.KEY_OUTSIDE_SERVICE_DOMAIN);
            outsideServiceDomain = CacheUtils.get(Constants.KEY_OUTSIDE_SERVICE_DOMAIN + "_" + deploymentEnvironment, "_" + deploymentEnvironment + "_" + serviceName);
        }
        return outsideServiceDomain;
    }

    public static String getUrl(String partitionCode, String serviceName, String controllerName, String actionName) throws IOException {
        return getServiceDomain(partitionCode, serviceName) + "/" + controllerName + "/" + actionName;
    }

    public static String getUrl(String serviceName, String controllerName, String actionName) throws IOException {
        return getServiceDomain(serviceName) + "/" + controllerName + "/" + actionName;
    }

    public static String getOutsideUrl(String partitionCode, String serviceName, String controllerName, String actionName) throws IOException {
        return getOutsideServiceDomain(partitionCode, serviceName) + "/" + controllerName + "/" + actionName;
    }

    public static String getOutsideUrl(String serviceName, String controllerName, String actionName) throws IOException {
        return getOutsideServiceDomain(serviceName) + "/" + controllerName + "/" + actionName;
    }

    public static void loadSystemPartitions(List<SystemPartition> systemPartitions, String deploymentEnvironment) throws IOException {
        Map<String, String> serviceDomainMap = new HashMap<String, String>();
        Map<String, String> outsideServiceDomainMap = new HashMap<String, String>();
        for (SystemPartition systemPartition : systemPartitions) {
            String key = null;
            if (systemPartition.getType() == 1) {
                key = "_" + systemPartition.getDeploymentEnvironment() + "_" + systemPartition.getServiceName();
            } else if (systemPartition.getType() == 2) {
                key = "_" + systemPartition.getDeploymentEnvironment() + "_" + systemPartition.getPartitionCode() + "_" + systemPartition.getServiceName();
            }
            serviceDomainMap.put(key, systemPartition.getServiceDomain());
            outsideServiceDomainMap.put(key, systemPartition.getOutsideServiceDomain());
        }
        String serviceDomainKey = Constants.KEY_SERVICE_DOMAIN + "_" + deploymentEnvironment;
        String outsideServiceDomainKey = Constants.KEY_OUTSIDE_SERVICE_DOMAIN + "_" + deploymentEnvironment;
        CacheUtils.delete(serviceDomainKey, outsideServiceDomainKey);
        CacheUtils.putAll(serviceDomainKey, serviceDomainMap);
        CacheUtils.putAll(outsideServiceDomainKey, outsideServiceDomainMap);
    }
}
