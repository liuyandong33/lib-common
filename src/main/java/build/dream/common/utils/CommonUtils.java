package build.dream.common.utils;

import build.dream.common.constants.Constants;
import build.dream.common.domains.saas.Tenant;
import org.apache.commons.lang.StringUtils;

import java.math.BigInteger;

public class CommonUtils {
    public static String getServiceName(String business) {
        if (Constants.BUSINESS_CATERING.equals(business)) {
            return Constants.SERVICE_NAME_CATERING;
        }

        if (Constants.BUSINESS_RETAIL.equals(business)) {
            return Constants.SERVICE_NAME_RETAIL;
        }

        if (Constants.BUSINESS_IOT.equals(business)) {
            return Constants.SERVICE_NAME_IOT;
        }
        return null;
    }

    public static BigInteger getServiceSystemUserId(String partitionCode, String serviceName) {
        String userId = ConfigurationUtils.getConfiguration(partitionCode + "." + serviceName + ".user.id");
        if (StringUtils.isNotBlank(userId)) {
            return BigInteger.valueOf(Long.valueOf(userId));
        }
        return null;
    }

    public static BigInteger getServiceSystemUserId() {
        String partitionCode = ConfigurationUtils.getConfiguration(Constants.PARTITION_CODE);
        String serviceName = ConfigurationUtils.getConfiguration(Constants.SERVICE_NAME);
        return getServiceSystemUserId(partitionCode, serviceName);
    }

    public static String getOutsideServiceDomain(String partitionCode, String serviceName) {
        String homeUrl = ConfigurationUtils.getConfiguration(Constants.HOME_URL);
        return homeUrl + "/" + partitionCode + "-" + serviceName;
    }

    public static String getOutsideServiceDomain(String serviceName) {
        String domainName = ConfigurationUtils.getConfiguration(Constants.HOME_URL);
        return domainName + "/" + serviceName;
    }

    public static String getOutsideUrl(String partitionCode, String serviceName, String controllerName, String actionName) {
        return getOutsideServiceDomain(partitionCode, serviceName) + "/" + controllerName + "/" + actionName;
    }

    public static String getOutsideUrl(String serviceName, String controllerName, String actionName) {
        return getOutsideServiceDomain(serviceName) + "/" + controllerName + "/" + actionName;
    }

    public static String getServiceDomain(String partitionCode, String serviceName) {
        String deploymentEnvironment = ConfigurationUtils.getConfiguration(Constants.DEPLOYMENT_ENVIRONMENT);
        return Constants.HTTP + deploymentEnvironment + "-" + partitionCode + "-" + serviceName;
    }

    public static String getServiceDomain(String serviceName) {
        String deploymentEnvironment = ConfigurationUtils.getConfiguration(Constants.DEPLOYMENT_ENVIRONMENT);
        return Constants.HTTP + deploymentEnvironment + "-" + serviceName;
    }

    public static String getUrl(String partitionCode, String serviceName, String controllerName, String actionName) {
        String deploymentEnvironment = ConfigurationUtils.getConfiguration(Constants.DEPLOYMENT_ENVIRONMENT);
        return Constants.HTTP + deploymentEnvironment + "-" + partitionCode + "-" + serviceName + "/" + controllerName + "/" + actionName;
    }

    public static String getUrl(String serviceName, String controllerName, String actionName) {
        String deploymentEnvironment = ConfigurationUtils.getConfiguration(Constants.DEPLOYMENT_ENVIRONMENT);
        return Constants.HTTP + deploymentEnvironment + "-" + serviceName + "/" + controllerName + "/" + actionName;
    }

    public static Tenant obtainTenantInfo(String tenantId, String tenantCode) {
        String tenantInfo = null;
        if (StringUtils.isNotBlank(tenantId)) {
            tenantInfo = CommonRedisUtils.hget(Constants.KEY_TENANT_INFOS, tenantId);
        } else if (StringUtils.isNotBlank(tenantCode)) {
            tenantInfo = CommonRedisUtils.hget(Constants.KEY_TENANT_INFOS, tenantCode);
        }

        if (StringUtils.isNotBlank(tenantInfo)) {
            return JacksonUtils.readValue(tenantInfo, Tenant.class);
        }
        return null;
    }

    public static String obtainApiServiceName(String clientType) {
        if (Constants.CLIENT_TYPE_APP.equals(clientType)) {
            return Constants.SERVICE_NAME_APPAPI;
        }

        if (Constants.CLIENT_TYPE_POS.equals(clientType)) {
            return Constants.SERVICE_NAME_POSAPI;
        }

        if (Constants.CLIENT_TYPE_WEB.equals(clientType)) {
            return Constants.SERVICE_NAME_WEBAPI;
        }
        return null;
    }
}
