package build.dream.common.erp.catering.domains;

import build.dream.common.basic.BasicDomain;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class ElemeOrderActivity extends BasicDomain {
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
     * eleme_order.id
     */
    private BigInteger elemeOrderId;
    /**
     * 饿了么系统订单ID
     */
    private String orderId;
    /**
     * 饿了么活动ID
     */
    private BigInteger elemeActivityId;
    /**
     * 活动名称
     */
    private String name;
    /**
     * 活动类别
     */
    private Integer categoryId;
    /**
     * 饿了么承担部分
     */
    private BigDecimal elemePart;
    /**
     * 商家承担部分
     */
    private BigDecimal restaurantPart;
    /**
     * 金额
     */
    private BigDecimal amount;

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

    public BigInteger getElemeOrderId() {
        return elemeOrderId;
    }

    public void setElemeOrderId(BigInteger elemeOrderId) {
        this.elemeOrderId = elemeOrderId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public BigInteger getElemeActivityId() {
        return elemeActivityId;
    }

    public void setElemeActivityId(BigInteger elemeActivityId) {
        this.elemeActivityId = elemeActivityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public BigDecimal getElemePart() {
        return elemePart;
    }

    public void setElemePart(BigDecimal elemePart) {
        this.elemePart = elemePart;
    }

    public BigDecimal getRestaurantPart() {
        return restaurantPart;
    }

    public void setRestaurantPart(BigDecimal restaurantPart) {
        this.restaurantPart = restaurantPart;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public static class Builder {
        private final ElemeOrderActivity instance = new ElemeOrderActivity();

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

        public Builder elemeOrderId(BigInteger elemeOrderId) {
            instance.setElemeOrderId(elemeOrderId);
            return this;
        }

        public Builder orderId(String orderId) {
            instance.setOrderId(orderId);
            return this;
        }

        public Builder elemeActivityId(BigInteger elemeActivityId) {
            instance.setElemeActivityId(elemeActivityId);
            return this;
        }

        public Builder name(String name) {
            instance.setName(name);
            return this;
        }

        public Builder categoryId(Integer categoryId) {
            instance.setCategoryId(categoryId);
            return this;
        }

        public Builder elemePart(BigDecimal elemePart) {
            instance.setElemePart(elemePart);
            return this;
        }

        public Builder restaurantPart(BigDecimal restaurantPart) {
            instance.setRestaurantPart(restaurantPart);
            return this;
        }

        public Builder amount(BigDecimal amount) {
            instance.setAmount(amount);
            return this;
        }

        public Builder id(BigInteger id) {
            instance.setId(id);
            return this;
        }

        public Builder createTime(Date createTime) {
            instance.setCreateTime(createTime);
            return this;
        }

        public Builder createUserId(BigInteger createUserId) {
            instance.setCreateUserId(createUserId);
            return this;
        }

        public Builder lastUpdateTime(Date lastUpdateTime) {
            instance.setLastUpdateTime(lastUpdateTime);
            return this;
        }

        public Builder lastUpdateUserId(BigInteger lastUpdateUserId) {
            instance.setLastUpdateUserId(lastUpdateUserId);
            return this;
        }

        public Builder lastUpdateRemark(String lastUpdateRemark) {
            instance.setLastUpdateRemark(lastUpdateRemark);
            return this;
        }

        public Builder deleteTime(Date deleteTime) {
            instance.setDeleteTime(deleteTime);
            return this;
        }

        public Builder deleted(boolean deleted) {
            instance.setDeleted(deleted);
            return this;
        }

        public ElemeOrderActivity build() {
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
        public static final String ELEME_ORDER_ID = "eleme_order_id";
        public static final String ORDER_ID = "order_id";
        public static final String ELEME_ACTIVITY_ID = "eleme_activity_id";
        public static final String NAME = "name";
        public static final String CATEGORY_ID = "category_id";
        public static final String ELEME_PART = "eleme_part";
        public static final String RESTAURANT_PART = "restaurant_part";
        public static final String AMOUNT = "amount";
    }
}
