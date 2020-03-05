package build.dream.common.domains.admin;

import build.dream.common.basic.BasicDomain;

public class AppConfiguration extends BasicDomain {
    private Long appId;
    private String configurationKey;
    private String configurationValue;

    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
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

    public static class Builder extends BasicDomain.Builder<Builder, AppConfiguration> {
        public Builder appId(Long appId) {
            instance.setAppId(appId);
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

        public AppConfiguration build() {
            AppConfiguration appConfiguration = super.build();
            appConfiguration.setAppId(instance.getAppId());
            appConfiguration.setConfigurationKey(instance.getConfigurationKey());
            appConfiguration.setConfigurationValue(instance.getConfigurationValue());
            return appConfiguration;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String APP_ID = "app_id";
        public static final String CONFIGURATION_KEY = "configuration_key";
        public static final String CONFIGURATION_VALUE = "configuration_value";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String APP_ID = "appId";
        public static final String CONFIGURATION_KEY = "configurationKey";
        public static final String CONFIGURATION_VALUE = "configurationValue";
    }
}
