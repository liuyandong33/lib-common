package build.dream.common.domains.catering;

import build.dream.common.basic.BasicDomain;

public class TenantConfig extends BasicDomain {
    public static final String TABLE_NAME = "tenant_config";
    /**
     * 商户ID
     */
    private Long tenantId;
    /**
     * 商户编码
     */
    private String tenantCode;
    /**
     * 配置名称
     */
    private String name;
    /**
     * 当前值
     */
    private Integer currentValue;
    /**
     * 最大值
     */
    private Integer maxValue;

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public String getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(Integer currentValue) {
        this.currentValue = currentValue;
    }

    public Integer getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Integer maxValue) {
        this.maxValue = maxValue;
    }

    public static class Builder extends BasicDomain.Builder<Builder, TenantConfig> {
        public Builder tenantId(Long tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder tenantCode(String tenantCode) {
            instance.setTenantCode(tenantCode);
            return this;
        }

        public Builder name(String name) {
            instance.setName(name);
            return this;
        }

        public Builder currentValue(Integer currentValue) {
            instance.setCurrentValue(currentValue);
            return this;
        }

        public Builder maxValue(Integer maxValue) {
            instance.setMaxValue(maxValue);
            return this;
        }

        @Override
        public TenantConfig build() {
            TenantConfig tenantConfig = super.build();
            tenantConfig.setTenantId(instance.getTenantId());
            tenantConfig.setTenantCode(instance.getTenantCode());
            tenantConfig.setName(instance.getName());
            tenantConfig.setCurrentValue(instance.getCurrentValue());
            tenantConfig.setMaxValue(instance.getMaxValue());
            return tenantConfig;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String TENANT_ID = "tenant_id";
        public static final String TENANT_CODE = "tenant_code";
        public static final String NAME = "name";
        public static final String CURRENT_VALUE = "current_value";
        public static final String MAX_VALUE = "max_value";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String TENANT_ID = "tenantId";
        public static final String TENANT_CODE = "tenantCode";
        public static final String NAME = "name";
        public static final String CURRENT_VALUE = "currentValue";
        public static final String MAX_VALUE = "maxValue";
    }
}
