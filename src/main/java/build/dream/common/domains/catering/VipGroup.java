package build.dream.common.domains.catering;

import build.dream.common.annotations.ShardingColumn;
import build.dream.common.basic.BasicDomain;

@ShardingColumn(fieldName = VipGroup.FieldName.TENANT_ID, columnName = VipGroup.ColumnName.TENANT_ID)
public class VipGroup extends BasicDomain {
    public static final String TABLE_NAME = "vip_group";
    /**
     * 商户ID
     */
    private Long tenantId;
    /**
     * 商户编号
     */
    private String tenantCode;
    /**
     * 分组名称
     */
    private String name;

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

    public static class Builder extends BasicDomain.Builder<Builder, VipGroup> {
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

        @Override
        public VipGroup build() {
            VipGroup vipGroup = super.build();
            vipGroup.setTenantId(instance.getTenantId());
            vipGroup.setTenantCode(instance.getTenantCode());
            vipGroup.setName(instance.getName());
            return vipGroup;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String TENANT_ID = "tenant_id";
        public static final String TENANT_CODE = "tenant_code";
        public static final String NAME = "name";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String TENANT_ID = "tenantId";
        public static final String TENANT_CODE = "tenantCode";
        public static final String NAME = "name";
    }
}
