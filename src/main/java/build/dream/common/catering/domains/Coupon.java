package build.dream.common.catering.domains;

import build.dream.common.annotations.ShardingColumn;
import build.dream.common.basic.BasicDomain;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

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

    public static class Builder {
        private final Coupon instance = new Coupon();

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

        public Builder id(BigInteger id) {
            instance.setId(id);
            return this;
        }

        public Builder createdTime(Date createdTime) {
            instance.setCreatedTime(createdTime);
            return this;
        }

        public Builder createdUserId(BigInteger createdUserId) {
            instance.setCreatedUserId(createdUserId);
            return this;
        }

        public Builder updatedTime(Date updatedTime) {
            instance.setUpdatedTime(updatedTime);
            return this;
        }

        public Builder updatedUserId(BigInteger updatedUserId) {
            instance.setUpdatedUserId(updatedUserId);
            return this;
        }

        public Builder updatedRemark(String updatedRemark) {
            instance.setUpdatedRemark(updatedRemark);
            return this;
        }

        public Builder deletedTime(Date deletedTime) {
            instance.setDeletedTime(deletedTime);
            return this;
        }

        public Builder deleted(boolean deleted) {
            instance.setDeleted(deleted);
            return this;
        }

        public Coupon build() {
            Coupon coupon = new Coupon();
            coupon.setTenantId(instance.getTenantId());
            coupon.setTenantCode(instance.getTenantCode());
            coupon.setBranchId(instance.getBranchId());
            coupon.setName(instance.getName());
            coupon.setType(instance.getType());
            coupon.setFaceValue(instance.getFaceValue());
            coupon.setId(instance.getId());
            coupon.setCreatedTime(instance.getCreatedTime());
            coupon.setCreatedUserId(instance.getCreatedUserId());
            coupon.setUpdatedTime(instance.getUpdatedTime());
            coupon.setUpdatedUserId(instance.getUpdatedUserId());
            coupon.setUpdatedRemark(instance.getUpdatedRemark());
            coupon.setDeletedTime(instance.getDeletedTime());
            coupon.setDeleted(instance.isDeleted());
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
