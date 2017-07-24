package build.dream.common.utils;

import java.io.IOException;
import java.util.Map;

/**
 * Created by liuyandong on 2017/7/24.
 */
public class ProxyUtils {
    public static String doGetWithRequestParameters(String partitionCode, String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) throws IOException {
        return WebUtils.doGetWithRequestParameters(SystemPartitionUtils.getUrl(partitionCode, serviceName, controllerName, actionName), requestParameters);
    }

    public static String doPostWithRequestParameters(String partitionCode, String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) throws IOException {
        return WebUtils.doPostWithRequestParameters(SystemPartitionUtils.getUrl(partitionCode, serviceName, controllerName, actionName), requestParameters);
    }

    public static String doPostWithFiles(String partitionCode, String serviceName, String controllerName, String actionName, Map<String, Object> requestParameters) throws IOException {
        return WebUtils.doPostWithFiles(SystemPartitionUtils.getUrl(partitionCode, serviceName, controllerName, actionName), requestParameters);
    }
}
