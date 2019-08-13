package build.dream.common.domains.catering;

import build.dream.common.annotations.ShardingColumn;
import build.dream.common.basic.BasicDomain;
import build.dream.common.constants.Constants;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

@ShardingColumn(fieldName = DietOrderActivity.FieldName.TENANT_ID, columnName = DietOrderActivity.ColumnName.TENANT_ID)
public class DietOrderActivity extends BasicDomain {
    public static final String TABLE_NAME = "diet_order_activity";
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
     * 活动id
     */
    private BigInteger activityId;
    /**
     * 活动名称
     */
    private String activityName;
    /**
     * 活动类型，activity.type
     */
    private Integer activityType;
    /**
     * 金额
     */
    private BigDecimal amount;
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

    public BigInteger getActivityId() {
        return activityId;
    }

    public void setActivityId(BigInteger activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public Integer getActivityType() {
        return activityType;
    }

    public void setActivityType(Integer activityType) {
        this.activityType = activityType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
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

    public static class Builder extends BasicDomain.Builder<Builder, DietOrderActivity> {
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

        public Builder activityId(BigInteger activityId) {
            instance.setActivityId(activityId);
            return this;
        }

        public Builder activityName(String activityName) {
            instance.setActivityName(activityName);
            return this;
        }

        public Builder activityType(Integer activityType) {
            instance.setActivityType(activityType);
            return this;
        }

        public Builder amount(BigDecimal amount) {
            instance.setAmount(amount);
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

        @Override
        public DietOrderActivity build() {
            DietOrderActivity dietOrderActivity = super.build();
            dietOrderActivity.setTenantId(instance.getTenantId());
            dietOrderActivity.setTenantCode(instance.getTenantCode());
            dietOrderActivity.setBranchId(instance.getBranchId());
            dietOrderActivity.setDietOrderId(instance.getDietOrderId());
            dietOrderActivity.setActivityId(instance.getActivityId());
            dietOrderActivity.setActivityName(instance.getActivityName());
            dietOrderActivity.setActivityType(instance.getActivityType());
            dietOrderActivity.setAmount(instance.getAmount());
            dietOrderActivity.setLocalId(instance.getLocalId());
            dietOrderActivity.setLocalDietOrderId(instance.getLocalDietOrderId());
            dietOrderActivity.setLocalCreatedTime(instance.getLocalCreatedTime());
            dietOrderActivity.setLocalUpdatedTime(instance.getLocalUpdatedTime());
            return dietOrderActivity;
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
        public static final String ACTIVITY_ID = "activity_id";
        public static final String ACTIVITY_NAME = "activity_name";
        public static final String ACTIVITY_TYPE = "activity_type";
        public static final String AMOUNT = "amount";
        public static final String LOCAL_ID = "local_id";
        public static final String LOCAL_DIET_ORDER_ID = "local_diet_order_id";
        public static final String LOCAL_CREATED_TIME = "local_created_time";
        public static final String LOCAL_UPDATED_TIME = "local_updated_time";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String TENANT_ID = "tenantId";
        public static final String TENANT_CODE = "tenantCode";
        public static final String BRANCH_ID = "branchId";
        public static final String DIET_ORDER_ID = "dietOrderId";
        public static final String ACTIVITY_ID = "activityId";
        public static final String ACTIVITY_NAME = "activityName";
        public static final String ACTIVITY_TYPE = "activityType";
        public static final String AMOUNT = "amount";
        public static final String LOCAL_ID = "localId";
        public static final String LOCAL_DIET_ORDER_ID = "localDietOrderId";
        public static final String LOCAL_CREATED_TIME = "localCreatedTime";
        public static final String LOCAL_UPDATED_TIME = "localUpdatedTime";
    }
}
