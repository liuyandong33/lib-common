package build.dream.common.saas.domains;

import build.dream.common.basic.BasicDomain;

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
}
