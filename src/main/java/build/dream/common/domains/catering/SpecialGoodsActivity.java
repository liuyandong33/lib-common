package build.dream.common.domains.catering;

import build.dream.common.annotations.ShardingColumn;
import build.dream.common.basic.BasicDomain;
import build.dream.common.constants.Constants;

@ShardingColumn(fieldName = SpecialGoodsActivity.FieldName.TENANT_ID, columnName = SpecialGoodsActivity.ColumnName.TENANT_ID)
public class SpecialGoodsActivity extends BasicDomain {
    public static final String TABLE_NAME = "special_goods_activity";
    /**
     * 商户id
     */
    private Long tenantId;
    /**
     * 商户编码
     */
    private String tenantCode;
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
     * 特价金额
     */
    private Double specialPrice = Constants.DECIMAL_DEFAULT_VALUE;
    /**
     * 折扣率
     */
    private Double discountRate = Constants.DECIMAL_DEFAULT_VALUE;

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

    public Double getSpecialPrice() {
        return specialPrice;
    }

    public void setSpecialPrice(Double specialPrice) {
        this.specialPrice = specialPrice;
    }

    public Double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(Double discountRate) {
        this.discountRate = discountRate;
    }

    public static class Builder extends BasicDomain.Builder<Builder, SpecialGoodsActivity> {
        public Builder tenantId(Long tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder tenantCode(String tenantCode) {
            instance.setTenantCode(tenantCode);
            return this;
        }

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

        public Builder specialPrice(Double specialPrice) {
            instance.setSpecialPrice(specialPrice);
            return this;
        }

        public Builder discountRate(Double discountRate) {
            instance.setDiscountRate(discountRate);
            return this;
        }

        @Override
        public SpecialGoodsActivity build() {
            SpecialGoodsActivity specialGoodsActivity = super.build();
            specialGoodsActivity.setTenantId(instance.getTenantId());
            specialGoodsActivity.setTenantCode(instance.getTenantCode());
            specialGoodsActivity.setActivityId(instance.getActivityId());
            specialGoodsActivity.setGoodsId(instance.getGoodsId());
            specialGoodsActivity.setGoodsSpecificationId(instance.getGoodsSpecificationId());
            specialGoodsActivity.setDiscountType(instance.getDiscountType());
            specialGoodsActivity.setSpecialPrice(instance.getSpecialPrice());
            specialGoodsActivity.setDiscountRate(instance.getDiscountRate());
            return specialGoodsActivity;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String TENANT_ID = "tenant_id";
        public static final String TENANT_CODE = "tenant_code";
        public static final String ACTIVITY_ID = "activity_id";
        public static final String GOODS_ID = "goods_id";
        public static final String GOODS_SPECIFICATION_ID = "goods_specification_id";
        public static final String DISCOUNT_TYPE = "discount_type";
        public static final String SPECIAL_PRICE = "special_price";
        public static final String DISCOUNT_RATE = "discount_rate";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String TENANT_ID = "tenantId";
        public static final String TENANT_CODE = "tenantCode";
        public static final String ACTIVITY_ID = "activityId";
        public static final String GOODS_ID = "goodsId";
        public static final String GOODS_SPECIFICATION_ID = "goodsSpecificationId";
        public static final String DISCOUNT_TYPE = "discountType";
        public static final String SPECIAL_PRICE = "specialPrice";
        public static final String DISCOUNT_RATE = "discountRate";
    }
}
