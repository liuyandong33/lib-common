package build.dream.common.iot.domains;

import build.dream.common.basic.BasicDomain;

import java.math.BigInteger;

public class Device extends BasicDomain {
    public static final String TABLE_NAME = "device";
    /**
     * 商户ID
     */
    private BigInteger tenantId;
    /**
     * 商户编号
     */
    private String tenantCode;
    /**
     * 门店ID
     */
    private BigInteger branchId;

    /**
     * 设备名称
     */
    private String name;

    /**
     * 设备编号
     */
    private String code;

    /**
     * 设备类型，1-温控设备
     */
    private Integer type;

    public BigInteger getTenantId() {
        return tenantId;
    }

    public void setTenantId(BigInteger tenantId) {
        this.tenantId = tenantId;
    }

    public String getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }

    public BigInteger getBranchId() {
        return branchId;
    }

    public void setBranchId(BigInteger branchId) {
        this.branchId = branchId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public static class Builder extends BasicDomain.Builder<Builder, Device> {
        public Builder tenantId(BigInteger tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder tenantCode(String tenantCode) {
            instance.setTenantCode(tenantCode);
            return this;
        }

        public Builder branchId(BigInteger branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public Builder name(String name) {
            instance.setName(name);
            return this;
        }

        public Builder code(String code) {
            instance.setCode(code);
            return this;
        }

        public Builder type(Integer type) {
            instance.setType(type);
            return this;
        }

        @Override
        public Device build() {
            Device device = super.build();
            device.setTenantId(instance.getTenantId());
            device.setTenantCode(instance.getTenantCode());
            device.setBranchId(instance.getBranchId());
            device.setName(instance.getName());
            device.setCode(instance.getCode());
            device.setType(instance.getType());
            return device;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String TENANT_ID = "tenant_id";
        public static final String TENANT_CODE = "tenant_code";
        public static final String BRANCH_ID = "branch_id";
        public static final String NAME = "name";
        public static final String CODE = "code";
        public static final String TYPE = "type";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String TENANT_ID = "tenantId";
        public static final String TENANT_CODE = "tenantCode";
        public static final String BRANCH_ID = "branchId";
        public static final String NAME = "name";
        public static final String CODE = "code";
        public static final String TYPE = "type";
    }
}
