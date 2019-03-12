package build.dream.common.saas.domains;

import build.dream.common.basic.BasicDomain;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class SpecialGoodsActivity extends BasicDomain {
    public static final String TABLE_NAME = "special_goods_activity";
    /**
     * 活动id
     */
    private BigInteger activityId;
    /**
     * 购买商品id
     */
    private BigInteger goodsId;
    /**
     * 购买商品规格id
     */
    private BigInteger goodsSpecificationId;
    /**
     * 优惠方式，1-特价，2-折扣
     */
    private Integer discountType;
    /**
     * 商户特价金额
     */
    private BigDecimal tenantSpecialPrice;
    /**
     * 代理商金额
     */
    private BigDecimal agentSpecialPrice;
    /**
     * 商户折扣率
     */
    private BigDecimal tenantDiscountRate;
    /**
     * 代理商折扣率
     */
    private BigDecimal agentDiscountRate;

    public BigInteger getActivityId() {
        return activityId;
    }

    public void setActivityId(BigInteger activityId) {
        this.activityId = activityId;
    }

    public BigInteger getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(BigInteger goodsId) {
        this.goodsId = goodsId;
    }

    public BigInteger getGoodsSpecificationId() {
        return goodsSpecificationId;
    }

    public void setGoodsSpecificationId(BigInteger goodsSpecificationId) {
        this.goodsSpecificationId = goodsSpecificationId;
    }

    public Integer getDiscountType() {
        return discountType;
    }

    public void setDiscountType(Integer discountType) {
        this.discountType = discountType;
    }

    public BigDecimal getTenantSpecialPrice() {
        return tenantSpecialPrice;
    }

    public void setTenantSpecialPrice(BigDecimal tenantSpecialPrice) {
        this.tenantSpecialPrice = tenantSpecialPrice;
    }

    public BigDecimal getAgentSpecialPrice() {
        return agentSpecialPrice;
    }

    public void setAgentSpecialPrice(BigDecimal agentSpecialPrice) {
        this.agentSpecialPrice = agentSpecialPrice;
    }

    public BigDecimal getTenantDiscountRate() {
        return tenantDiscountRate;
    }

    public void setTenantDiscountRate(BigDecimal tenantDiscountRate) {
        this.tenantDiscountRate = tenantDiscountRate;
    }

    public BigDecimal getAgentDiscountRate() {
        return agentDiscountRate;
    }

    public void setAgentDiscountRate(BigDecimal agentDiscountRate) {
        this.agentDiscountRate = agentDiscountRate;
    }

    public static class Builder {
        private final SpecialGoodsActivity instance = new SpecialGoodsActivity();

        public Builder activityId(BigInteger activityId) {
            instance.setActivityId(activityId);
            return this;
        }

        public Builder goodsId(BigInteger goodsId) {
            instance.setGoodsId(goodsId);
            return this;
        }

        public Builder goodsSpecificationId(BigInteger goodsSpecificationId) {
            instance.setGoodsSpecificationId(goodsSpecificationId);
            return this;
        }

        public Builder discountType(Integer discountType) {
            instance.setDiscountType(discountType);
            return this;
        }

        public Builder tenantSpecialPrice(BigDecimal tenantSpecialPrice) {
            instance.setTenantSpecialPrice(tenantSpecialPrice);
            return this;
        }

        public Builder agentSpecialPrice(BigDecimal agentSpecialPrice) {
            instance.setAgentSpecialPrice(agentSpecialPrice);
            return this;
        }

        public Builder tenantDiscountRate(BigDecimal tenantDiscountRate) {
            instance.setTenantDiscountRate(tenantDiscountRate);
            return this;
        }

        public Builder agentDiscountRate(BigDecimal agentDiscountRate) {
            instance.setAgentDiscountRate(agentDiscountRate);
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

        public SpecialGoodsActivity build() {
            SpecialGoodsActivity specialGoodsActivity = new SpecialGoodsActivity();
            specialGoodsActivity.setActivityId(instance.getActivityId());
            specialGoodsActivity.setGoodsId(instance.getGoodsId());
            specialGoodsActivity.setGoodsSpecificationId(instance.getGoodsSpecificationId());
            specialGoodsActivity.setDiscountType(instance.getDiscountType());
            specialGoodsActivity.setTenantSpecialPrice(instance.getTenantSpecialPrice());
            specialGoodsActivity.setAgentSpecialPrice(instance.getAgentSpecialPrice());
            specialGoodsActivity.setTenantDiscountRate(instance.getTenantDiscountRate());
            specialGoodsActivity.setAgentDiscountRate(instance.getAgentDiscountRate());
            specialGoodsActivity.setId(instance.getId());
            specialGoodsActivity.setCreatedTime(instance.getCreatedTime());
            specialGoodsActivity.setCreatedUserId(instance.getCreatedUserId());
            specialGoodsActivity.setUpdatedTime(instance.getUpdatedTime());
            specialGoodsActivity.setUpdatedUserId(instance.getUpdatedUserId());
            specialGoodsActivity.setUpdatedRemark(instance.getUpdatedRemark());
            specialGoodsActivity.setDeletedTime(instance.getDeletedTime());
            specialGoodsActivity.setDeleted(instance.isDeleted());
            return specialGoodsActivity;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String ACTIVITY_ID = "activity_id";
        public static final String GOODS_ID = "goods_id";
        public static final String GOODS_SPECIFICATION_ID = "goods_specification_id";
        public static final String DISCOUNT_TYPE = "discount_type";
        public static final String TENANT_SPECIAL_PRICE = "tenant_special_price";
        public static final String AGENT_SPECIAL_PRICE = "agent_special_price";
        public static final String TENANT_DISCOUNT_RATE = "tenant_discount_rate";
        public static final String AGENT_DISCOUNT_RATE = "agent_discount_rate";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String ACTIVITY_ID = "activityId";
        public static final String GOODS_ID = "goodsId";
        public static final String GOODS_SPECIFICATION_ID = "goodsSpecificationId";
        public static final String DISCOUNT_TYPE = "discountType";
        public static final String TENANT_SPECIAL_PRICE = "tenantSpecialPrice";
        public static final String AGENT_SPECIAL_PRICE = "agentSpecialPrice";
        public static final String TENANT_DISCOUNT_RATE = "tenantDiscountRate";
        public static final String AGENT_DISCOUNT_RATE = "agentDiscountRate";
    }
}
