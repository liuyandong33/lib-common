package build.dream.common.domains.catering;

import build.dream.common.annotations.ShardingColumn;
import build.dream.common.basic.BasicDomain;

import java.math.BigDecimal;
import java.math.BigInteger;

@ShardingColumn(fieldName = Coupon.FieldName.TENANT_ID, columnName = Coupon.ColumnName.TENANT_ID)
public class Coupon extends BasicDomain {
    public static final String TABLE_NAME = "coupon";
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
     * 卡券名称
     */
    private String name;
    /**
     * 类型，1-折扣券，2-代金券
     */
    private Integer type;
    /**
     * 代金券面值
     */
    private BigDecimal faceValue;

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public BigDecimal getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(BigDecimal faceValue) {
        this.faceValue = faceValue;
    }

    public static class Builder extends BasicDomain.Builder<Builder, Coupon> {
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

        public Builder type(Integer type) {
            instance.setType(type);
            return this;
        }

        public Builder faceValue(BigDecimal faceValue) {
            instance.setFaceValue(faceValue);
            return this;
        }

        @Override
        public Coupon build() {
            Coupon coupon = super.build();
            coupon.setTenantId(instance.getTenantId());
            coupon.setTenantCode(instance.getTenantCode());
            coupon.setBranchId(instance.getBranchId());
            coupon.setName(instance.getName());
            coupon.setType(instance.getType());
            coupon.setFaceValue(instance.getFaceValue());
            return coupon;
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
        public static final String TYPE = "type";
        public static final String FACE_VALUE = "face_value";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String TENANT_ID = "tenantId";
        public static final String TENANT_CODE = "tenantCode";
        public static final String BRANCH_ID = "branchId";
        public static final String NAME = "name";
        public static final String TYPE = "type";
        public static final String FACE_VALUE = "faceValue";
    }
}
