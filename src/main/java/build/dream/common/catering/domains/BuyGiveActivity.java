package build.dream.common.catering.domains;

import build.dream.common.annotations.ShardingColumn;
import build.dream.common.basic.BasicDomain;

import java.math.BigInteger;
import java.util.Date;

@ShardingColumn(fieldName = BuyGiveActivity.FieldName.TENANT_ID, columnName = BuyGiveActivity.ColumnName.TENANT_ID)
public class BuyGiveActivity extends BasicDomain {
    public static final String TABLE_NAME = "buy_give_activity";
    /**
     * 商户id
     */
    private BigInteger tenantId;
    /**
     * 商户编码
     */
    private String tenantCode;
    /**
     * 活动id
     */
    private BigInteger activityId;
    /**
     * 购买商品id
     */
    private BigInteger buyGoodsId;
    /**
     * 购买商品规格id
     */
    private BigInteger buyGoodsSpecificationId;
    /**
     * 购买数量
     */
    private Integer buyQuantity;
    /**
     * 赠送商品id
     */
    private BigInteger giveGoodsId;
    /**
     * 赠送商品规格id
     */
    private BigInteger giveGoodsSpecificationId;
    /**
     * 赠送数量
     */
    private Integer giveQuantity;

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

    public BigInteger getActivityId() {
        return activityId;
    }

    public void setActivityId(BigInteger activityId) {
        this.activityId = activityId;
    }

    public BigInteger getBuyGoodsId() {
        return buyGoodsId;
    }

    public void setBuyGoodsId(BigInteger buyGoodsId) {
        this.buyGoodsId = buyGoodsId;
    }

    public BigInteger getBuyGoodsSpecificationId() {
        return buyGoodsSpecificationId;
    }

    public void setBuyGoodsSpecificationId(BigInteger buyGoodsSpecificationId) {
        this.buyGoodsSpecificationId = buyGoodsSpecificationId;
    }

    public Integer getBuyQuantity() {
        return buyQuantity;
    }

    public void setBuyQuantity(Integer buyQuantity) {
        this.buyQuantity = buyQuantity;
    }

    public BigInteger getGiveGoodsId() {
        return giveGoodsId;
    }

    public void setGiveGoodsId(BigInteger giveGoodsId) {
        this.giveGoodsId = giveGoodsId;
    }

    public BigInteger getGiveGoodsSpecificationId() {
        return giveGoodsSpecificationId;
    }

    public void setGiveGoodsSpecificationId(BigInteger giveGoodsSpecificationId) {
        this.giveGoodsSpecificationId = giveGoodsSpecificationId;
    }

    public Integer getGiveQuantity() {
        return giveQuantity;
    }

    public void setGiveQuantity(Integer giveQuantity) {
        this.giveQuantity = giveQuantity;
    }

    public static class Builder {
        private final BuyGiveActivity instance = new BuyGiveActivity();

        public Builder tenantId(BigInteger tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder tenantCode(String tenantCode) {
            instance.setTenantCode(tenantCode);
            return this;
        }

        public Builder activityId(BigInteger activityId) {
            instance.setActivityId(activityId);
            return this;
        }

        public Builder buyGoodsId(BigInteger buyGoodsId) {
            instance.setBuyGoodsId(buyGoodsId);
            return this;
        }

        public Builder buyGoodsSpecificationId(BigInteger buyGoodsSpecificationId) {
            instance.setBuyGoodsSpecificationId(buyGoodsSpecificationId);
            return this;
        }

        public Builder buyQuantity(Integer buyQuantity) {
            instance.setBuyQuantity(buyQuantity);
            return this;
        }

        public Builder giveGoodsId(BigInteger giveGoodsId) {
            instance.setGiveGoodsId(giveGoodsId);
            return this;
        }

        public Builder giveGoodsSpecificationId(BigInteger giveGoodsSpecificationId) {
            instance.setGiveGoodsSpecificationId(giveGoodsSpecificationId);
            return this;
        }

        public Builder giveQuantity(Integer giveQuantity) {
            instance.setGiveQuantity(giveQuantity);
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

        public BuyGiveActivity build() {
            return instance;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String TENANT_ID = "tenant_id";
        public static final String TENANT_CODE = "tenant_code";
        public static final String ACTIVITY_ID = "activity_id";
        public static final String BUY_GOODS_ID = "buy_goods_id";
        public static final String BUY_GOODS_SPECIFICATION_ID = "buy_goods_specification_id";
        public static final String BUY_QUANTITY = "buy_quantity";
        public static final String GIVE_GOODS_ID = "give_goods_id";
        public static final String GIVE_GOODS_SPECIFICATION_ID = "give_goods_specification_id";
        public static final String GIVE_QUANTITY = "give_quantity";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String TENANT_ID = "tenantId";
        public static final String TENANT_CODE = "tenantCode";
        public static final String ACTIVITY_ID = "activityId";
        public static final String BUY_GOODS_ID = "buyGoodsId";
        public static final String BUY_GOODS_SPECIFICATION_ID = "buyGoodsSpecificationId";
        public static final String BUY_QUANTITY = "buyQuantity";
        public static final String GIVE_GOODS_ID = "giveGoodsId";
        public static final String GIVE_GOODS_SPECIFICATION_ID = "giveGoodsSpecificationId";
        public static final String GIVE_QUANTITY = "giveQuantity";
    }
}
