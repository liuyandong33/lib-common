package build.dream.common.domains.saas;

import build.dream.common.basic.BasicDomain;

public class SpecialGoodsActivity extends BasicDomain {
    public static final String TABLE_NAME = "special_goods_activity";
    /**
     * 活动id
     */
    private Long activityId;
    /**
     * 购买商品id
     */
    private Long goodsId;
    /**
     * 购买商品规格id
     */
    private Long goodsSpecificationId;
    /**
     * 优惠方式，1-特价，2-折扣
     */
    private Integer discountType;
    /**
     * 商户特价金额
     */
    private Double tenantSpecialPrice;
    /**
     * 代理商金额
     */
    private Double agentSpecialPrice;
    /**
     * 商户折扣率
     */
    private Double tenantDiscountRate;
    /**
     * 代理商折扣率
     */
    private Double agentDiscountRate;

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getGoodsSpecificationId() {
        return goodsSpecificationId;
    }

    public void setGoodsSpecificationId(Long goodsSpecificationId) {
        this.goodsSpecificationId = goodsSpecificationId;
    }

    public Integer getDiscountType() {
        return discountType;
    }

    public void setDiscountType(Integer discountType) {
        this.discountType = discountType;
    }

    public Double getTenantSpecialPrice() {
        return tenantSpecialPrice;
    }

    public void setTenantSpecialPrice(Double tenantSpecialPrice) {
        this.tenantSpecialPrice = tenantSpecialPrice;
    }

    public Double getAgentSpecialPrice() {
        return agentSpecialPrice;
    }

    public void setAgentSpecialPrice(Double agentSpecialPrice) {
        this.agentSpecialPrice = agentSpecialPrice;
    }

    public Double getTenantDiscountRate() {
        return tenantDiscountRate;
    }

    public void setTenantDiscountRate(Double tenantDiscountRate) {
        this.tenantDiscountRate = tenantDiscountRate;
    }

    public Double getAgentDiscountRate() {
        return agentDiscountRate;
    }

    public void setAgentDiscountRate(Double agentDiscountRate) {
        this.agentDiscountRate = agentDiscountRate;
    }

    public static class Builder extends BasicDomain.Builder<Builder, SpecialGoodsActivity> {
        public Builder activityId(Long activityId) {
            instance.setActivityId(activityId);
            return this;
        }

        public Builder goodsId(Long goodsId) {
            instance.setGoodsId(goodsId);
            return this;
        }

        public Builder goodsSpecificationId(Long goodsSpecificationId) {
            instance.setGoodsSpecificationId(goodsSpecificationId);
            return this;
        }

        public Builder discountType(Integer discountType) {
            instance.setDiscountType(discountType);
            return this;
        }

        public Builder tenantSpecialPrice(Double tenantSpecialPrice) {
            instance.setTenantSpecialPrice(tenantSpecialPrice);
            return this;
        }

        public Builder agentSpecialPrice(Double agentSpecialPrice) {
            instance.setAgentSpecialPrice(agentSpecialPrice);
            return this;
        }

        public Builder tenantDiscountRate(Double tenantDiscountRate) {
            instance.setTenantDiscountRate(tenantDiscountRate);
            return this;
        }

        public Builder agentDiscountRate(Double agentDiscountRate) {
            instance.setAgentDiscountRate(agentDiscountRate);
            return this;
        }

        @Override
        public SpecialGoodsActivity build() {
            SpecialGoodsActivity specialGoodsActivity = super.build();
            specialGoodsActivity.setActivityId(instance.getActivityId());
            specialGoodsActivity.setGoodsId(instance.getGoodsId());
            specialGoodsActivity.setGoodsSpecificationId(instance.getGoodsSpecificationId());
            specialGoodsActivity.setDiscountType(instance.getDiscountType());
            specialGoodsActivity.setTenantSpecialPrice(instance.getTenantSpecialPrice());
            specialGoodsActivity.setAgentSpecialPrice(instance.getAgentSpecialPrice());
            specialGoodsActivity.setTenantDiscountRate(instance.getTenantDiscountRate());
            specialGoodsActivity.setAgentDiscountRate(instance.getAgentDiscountRate());
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
