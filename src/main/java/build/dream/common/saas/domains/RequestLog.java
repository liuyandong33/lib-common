package build.dream.common.saas.domains;

import build.dream.common.basic.BasicDomain;

import java.math.BigInteger;
import java.util.Date;

public class RequestLog extends BasicDomain {
    /**
     * 唯一标识
     */
    private String uuid;
    /**
     * 部署环境
     */
    private String deploymentEnvironment;
    /**
     * 分区号
     */
    private String partitionCode;
    /**
     * 服务名称
     */
    private String serviceName;
    /**
     * 处理器类名
     */
    private String className;
    /**
     * 处理器方法名
     */
    private String methodName;
    /**
     * 访问时间
     */
    private Date requestTime;
    /**
     * 请求参数
     */
    private String requestParameters;
    /**
     * 请求头
     */
    private String headers;
    /**
     * cookie
     */
    private String cookies;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getDeploymentEnvironment() {
        return deploymentEnvironment;
    }

    public void setDeploymentEnvironment(String deploymentEnvironment) {
        this.deploymentEnvironment = deploymentEnvironment;
    }

    public String getPartitionCode() {
        return partitionCode;
    }

    public void setPartitionCode(String partitionCode) {
        this.partitionCode = partitionCode;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Date getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }

    public String getRequestParameters() {
        return requestParameters;
    }

    public void setRequestParameters(String requestParameters) {
        this.requestParameters = requestParameters;
    }

    public String getHeaders() {
        return headers;
    }

    public void setHeaders(String headers) {
        this.headers = headers;
    }

    public String getCookies() {
        return cookies;
    }

    public void setCookies(String cookies) {
        this.cookies = cookies;
    }

    public static class Builder {
        private final RequestLog instance = new RequestLog();

        public Builder uuid(String uuid) {
            instance.setUuid(uuid);
            return this;
        }

        public Builder deploymentEnvironment(String deploymentEnvironment) {
            instance.setDeploymentEnvironment(deploymentEnvironment);
            return this;
        }

        public Builder partitionCode(String partitionCode) {
            instance.setPartitionCode(partitionCode);
            return this;
        }

        public Builder serviceName(String serviceName) {
            instance.setServiceName(serviceName);
            return this;
        }

        public Builder className(String className) {
            instance.setClassName(className);
            return this;
        }

        public Builder methodName(String methodName) {
            instance.setMethodName(methodName);
            return this;
        }

        public Builder requestTime(Date requestTime) {
            instance.setRequestTime(requestTime);
            return this;
        }

        public Builder requestParameters(String requestParameters) {
            instance.setRequestParameters(requestParameters);
            return this;
        }

        public Builder headers(String headers) {
            instance.setHeaders(headers);
            return this;
        }

        public Builder cookies(String cookies) {
            instance.setCookies(cookies);
            return this;
        }

        public Builder id(BigInteger id) {
            instance.setId(id);
            return this;
        }

        public Builder createTime(Date createTime) {
            instance.setCreateTime(createTime);
            return this;
        }

        public Builder createUserId(BigInteger createUserId) {
            instance.setCreateUserId(createUserId);
            return this;
        }

        public Builder lastUpdateTime(Date lastUpdateTime) {
            instance.setLastUpdateTime(lastUpdateTime);
            return this;
        }

        public Builder lastUpdateUserId(BigInteger lastUpdateUserId) {
            instance.setLastUpdateUserId(lastUpdateUserId);
            return this;
        }

        public Builder lastUpdateRemark(String lastUpdateRemark) {
            instance.setLastUpdateRemark(lastUpdateRemark);
            return this;
        }

        public Builder deleteTime(Date deleteTime) {
            instance.setDeleteTime(deleteTime);
            return this;
        }

        public Builder deleted(boolean deleted) {
            instance.setDeleted(deleted);
            return this;
        }

        public RequestLog build() {
            return instance;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String UUID = "uuid";
        public static final String DEPLOYMENT_ENVIRONMENT = "deployment_environment";
        public static final String PARTITION_CODE = "partition_code";
        public static final String SERVICE_NAME = "service_name";
        public static final String CLASS_NAME = "class_name";
        public static final String METHOD_NAME = "method_name";
        public static final String REQUEST_TIME = "request_time";
        public static final String REQUEST_PARAMETERS = "request_parameters";
        public static final String HEADERS = "headers";
        public static final String COOKIES = "cookies";
    }
}
