package build.dream.common.domains.devops;

import build.dream.common.annotations.Table;
import build.dream.common.basic.BasicDomain;

@Table(name = "service")
public class $Service extends BasicDomain {
    private Long appId;
    /**
     * 名字
     */
    private String name;

    /**
     * 程序名称
     */
    private String programName;

    /**
     * 程序版本
     */
    private String programVersion;

    private String healthCheckPath;

    /**
     * 是否分区
     */
    private boolean partitioned;

    /**
     * 部署环境
     */
    private String deploymentEnvironment;

    /**
     * 分区码
     */
    private String partitionCode;

    /**
     * 服务名称
     */
    private String serviceName;

    /**
     * zookeeper 连接字符串
     */
    private String zookeeperConnectString;

    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getProgramVersion() {
        return programVersion;
    }

    public void setProgramVersion(String programVersion) {
        this.programVersion = programVersion;
    }

    public String getHealthCheckPath() {
        return healthCheckPath;
    }

    public void setHealthCheckPath(String healthCheckPath) {
        this.healthCheckPath = healthCheckPath;
    }

    public boolean isPartitioned() {
        return partitioned;
    }

    public void setPartitionCode(String partitionCode) {
        this.partitionCode = partitionCode;
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

    public void setPartitioned(boolean partitioned) {
        this.partitioned = partitioned;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getZookeeperConnectString() {
        return zookeeperConnectString;
    }

    public void setZookeeperConnectString(String zookeeperConnectString) {
        this.zookeeperConnectString = zookeeperConnectString;
    }

    public static class Builder extends BasicDomain.Builder<Builder, $Service> {
        public Builder appId(Long appId) {
            instance.setAppId(appId);
            return this;
        }

        public Builder name(String name) {
            instance.setName(name);
            return this;
        }

        public Builder programName(String programName) {
            instance.setProgramName(programName);
            return this;
        }

        public Builder programVersion(String programVersion) {
            instance.setProgramVersion(programVersion);
            return this;
        }

        public Builder healthCheckPath(String healthCheckPath) {
            instance.setHealthCheckPath(healthCheckPath);
            return this;
        }

        public Builder partitioned(boolean partitioned) {
            instance.setPartitioned(partitioned);
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

        public Builder zookeeperConnectString(String zookeeperConnectString) {
            instance.setZookeeperConnectString(zookeeperConnectString);
            return this;
        }

        public $Service build() {
            $Service service = super.build();
            service.setAppId(instance.getAppId());
            service.setName(instance.getName());
            service.setProgramName(instance.getProgramName());
            service.setProgramVersion(instance.getProgramVersion());
            service.setHealthCheckPath(instance.getHealthCheckPath());
            service.setPartitioned(instance.isPartitioned());
            service.setDeploymentEnvironment(instance.getDeploymentEnvironment());
            service.setPartitionCode(instance.getPartitionCode());
            service.setServiceName(instance.getServiceName());
            service.setZookeeperConnectString(instance.getZookeeperConnectString());
            return service;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String APP_ID = "app_id";
        public static final String NAME = "name";
        public static final String PROGRAM_NAME = "program_name";
        public static final String PROGRAM_VERSION = "program_version";
        public static final String HEALTH_CHECK_PATH = "health_check_path";
        public static final String PARTITIONED = "partitioned";
        public static final String DEPLOYMENT_ENVIRONMENT = "deployment_environment";
        public static final String PARTITION_CODE = "partition_code";
        public static final String SERVICE_NAME = "service_name";
        public static final String ZOOKEEPER_CONNECT_STRING = "zookeeper_connect_string";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String APP_ID = "appId";
        public static final String NAME = "name";
        public static final String PROGRAM_NAME = "programName";
        public static final String PROGRAM_VERSION = "programVersion";
        public static final String HEALTH_CHECK_PATH = "healthCheckPath";
        public static final String PARTITIONED = "partitioned";
        public static final String DEPLOYMENT_ENVIRONMENT = "deploymentEnvironment";
        public static final String PARTITION_CODE = "partitionCode";
        public static final String SERVICE_NAME = "serviceName";
        public static final String ZOOKEEPER_CONNECT_STRING = "zookeeperConnectString";
    }
}
