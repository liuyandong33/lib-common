package build.dream.common.domains.devops;

import build.dream.common.basic.BasicDomain;

public class SnowflakeIdConfiguration {
    public static final String TABLE_NAME = "snowflake_id_configuration";
    /**
     * work id
     */
    private Integer workerId;

    /**
     * data center id
     */
    private Integer dataCenterId;

    /**
     * ip 地址
     */
    private String ipAddress;

    /**
     * 应用名称
     */
    private String applicationName;

    /**
     * 描述
     */
    private String description;

    public Integer getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Integer workerId) {
        this.workerId = workerId;
    }

    public Integer getDataCenterId() {
        return dataCenterId;
    }

    public void setDataCenterId(Integer dataCenterId) {
        this.dataCenterId = dataCenterId;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static class Builder {
        private SnowflakeIdConfiguration instance = new SnowflakeIdConfiguration();

        public Builder workerId(Integer workerId) {
            instance.setWorkerId(workerId);
            return this;
        }

        public Builder dataCenterId(Integer dataCenterId) {
            instance.setDataCenterId(dataCenterId);
            return this;
        }

        public Builder ipAddress(String ipAddress) {
            instance.setIpAddress(ipAddress);
            return this;
        }

        public Builder applicationName(String applicationName) {
            instance.setApplicationName(applicationName);
            return this;
        }

        public Builder description(String description) {
            instance.setDescription(description);
            return this;
        }

        public SnowflakeIdConfiguration build() {
            SnowflakeIdConfiguration snowflakeIdConfiguration = new SnowflakeIdConfiguration();
            snowflakeIdConfiguration.setWorkerId(instance.getWorkerId());
            snowflakeIdConfiguration.setDataCenterId(instance.getDataCenterId());
            snowflakeIdConfiguration.setIpAddress(instance.getIpAddress());
            snowflakeIdConfiguration.setApplicationName(instance.getApplicationName());
            snowflakeIdConfiguration.setDescription(instance.getDescription());
            return snowflakeIdConfiguration;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String WORKER_ID = "worker_id";
        public static final String DATA_CENTER_ID = "data_center_id";
        public static final String IP_ADDRESS = "ip_address";
        public static final String APPLICATION_NAME = "application_name";
        public static final String DESCRIPTION = "description";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String WORKER_ID = "workerId";
        public static final String DATA_CENTER_ID = "dataCenterId";
        public static final String IP_ADDRESS = "ipAddress";
        public static final String APPLICATION_NAME = "applicationName";
        public static final String DESCRIPTION = "description";
    }
}
