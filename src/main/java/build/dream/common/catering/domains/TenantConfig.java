package build.dream.common.catering.domains;

import java.math.BigInteger;

public class TenantConfig {
    public static final String TABLE_NAME = "tenant_config";
    /**
     * 商户ID
     */
    private BigInteger tenantId;
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

    public BigInteger getTenantId() {
        return tenantId;
    }

    public void setTenantId(BigInteger tenantId) {
        this.tenantId = tenantId;
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
}
