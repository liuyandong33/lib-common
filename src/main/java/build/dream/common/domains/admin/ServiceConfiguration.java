package build.dream.common.domains.admin;

import build.dream.common.basic.BasicDomain;

public class ServiceConfiguration extends BasicDomain {
    private Long serviceId;
    private String configurationKey;
    private String configurationValue;

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public String getConfigurationKey() {
        return configurationKey;
    }

    public void setConfigurationKey(String configurationKey) {
        this.configurationKey = configurationKey;
    }

    public String getConfigurationValue() {
        return configurationValue;
    }

    public void setConfigurationValue(String configurationValue) {
        this.configurationValue = configurationValue;
    }

    public static class Builder extends BasicDomain.Builder<Builder, ServiceConfiguration> {
        public Builder serviceId(Long serviceId) {
            instance.setServiceId(serviceId);
            return this;
        }

        public Builder configurationKey(String configurationKey) {
            instance.setConfigurationKey(configurationKey);
            return this;
        }

        public Builder configurationValue(String configurationValue) {
            instance.setConfigurationKey(configurationValue);
            return this;
        }

        public ServiceConfiguration build() {
            ServiceConfiguration serviceConfiguration = super.build();
            serviceConfiguration.setServiceId(instance.getServiceId());
            serviceConfiguration.setConfigurationKey(instance.getConfigurationKey());
            serviceConfiguration.setConfigurationValue(instance.getConfigurationValue());
            return serviceConfiguration;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String SERVICE_ID = "service_id";
        public static final String CONFIGURATION_KEY = "configuration_key";
        public static final String CONFIGURATION_VALUE = "configuration_value";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String SERVICE_ID = "serviceId";
        public static final String CONFIGURATION_KEY = "configurationKey";
        public static final String CONFIGURATION_VALUE = "configurationValue";
    }
}
