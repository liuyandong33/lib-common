package build.dream.common.catering.domains;

import build.dream.common.basic.BasicDomain;
import build.dream.common.constants.Constants;

import java.math.BigInteger;
import java.util.Date;

public class DietOrderGroup extends BasicDomain {
    /**
     * 商户ID
     */
    private BigInteger tenantId;
    /**
     * 商户编码
     */
    private String tenantCode;
    /**
     * 门店ID
     */
    private BigInteger branchId;
    /**
     * diet_order.id
     */
    private BigInteger dietOrderId;
    /**
     * 组名
     */
    private String name;
    /**
     * normal-正常的菜品，extra-配送费等，discount-赠品
     */
    private String type;
    /**
     * 本地ID
     */
    private String localId = Constants.VARCHAR_DEFAULT_VALUE;
    /**
     * 本地订单ID
     */
    private String localDietOrderId = Constants.VARCHAR_DEFAULT_VALUE;
    /**
     * 本地创建时间
     */
    private Date localCreatedTime = Constants.DATETIME_DEFAULT_VALUE;
    /**
     * 本地最后更新时间
     */
    private Date localUpdatedTime = Constants.DATETIME_DEFAULT_VALUE;

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

    public BigInteger getDietOrderId() {
        return dietOrderId;
    }

    public void setDietOrderId(BigInteger dietOrderId) {
        this.dietOrderId = dietOrderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocalId() {
        return localId;
    }

    public void setLocalId(String localId) {
        this.localId = localId;
    }

    public String getLocalDietOrderId() {
        return localDietOrderId;
    }

    public void setLocalDietOrderId(String localDietOrderId) {
        this.localDietOrderId = localDietOrderId;
    }

    public Date getLocalCreatedTime() {
        return localCreatedTime;
    }

    public void setLocalCreatedTime(Date localCreatedTime) {
        this.localCreatedTime = localCreatedTime;
    }

    public Date getLocalUpdatedTime() {
        return localUpdatedTime;
    }

    public void setLocalUpdatedTime(Date localUpdatedTime) {
        this.localUpdatedTime = localUpdatedTime;
    }

    public static class Builder {
        private final DietOrderGroup instance = new DietOrderGroup();

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

        public Builder dietOrderId(BigInteger dietOrderId) {
            instance.setDietOrderId(dietOrderId);
            return this;
        }

        public Builder name(String name) {
            instance.setName(name);
            return this;
        }

        public Builder type(String type) {
            instance.setType(type);
            return this;
        }

        public Builder localId(String localId) {
            instance.setLocalId(localId);
            return this;
        }

        public Builder localDietOrderId(String localDietOrderId) {
            instance.setLocalDietOrderId(localDietOrderId);
            return this;
        }

        public Builder localCreatedTime(Date localCreatedTime) {
            instance.setLocalCreatedTime(localCreatedTime);
            return this;
        }

        public Builder localUpdatedTime(Date localUpdatedTime) {
            instance.setLocalUpdatedTime(localUpdatedTime);
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

        public DietOrderGroup build() {
            return instance;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String TENANT_ID = "tenant_id";
        public static final String TENANT_CODE = "tenant_code";
        public static final String BRANCH_ID = "branch_id";
        public static final String DIET_ORDER_ID = "diet_order_id";
        public static final String NAME = "name";
        public static final String TYPE = "type";
        public static final String LOCAL_ID = "local_id";
        public static final String LOCAL_DIET_ORDER_ID = "local_diet_order_id";
        public static final String LOCAL_CREATED_TIME = "local_created_time";
        public static final String LOCAL_UPDATED_TIME = "local_last_updated_time";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String TENANT_ID = "tenantId";
        public static final String TENANT_CODE = "tenantCode";
        public static final String BRANCH_ID = "branchId";
        public static final String DIET_ORDER_ID = "dietOrderId";
        public static final String NAME = "name";
        public static final String TYPE = "type";
        public static final String LOCAL_ID = "localId";
        public static final String LOCAL_DIET_ORDER_ID = "localDietOrderId";
        public static final String LOCAL_CREATED_TIME = "localCreatedTime";
        public static final String LOCAL_UPDATED_TIME = "localLastUpdatedTime";
    }
}
