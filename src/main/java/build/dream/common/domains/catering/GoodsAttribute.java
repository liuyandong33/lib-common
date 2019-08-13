package build.dream.common.domains.catering;

import build.dream.common.annotations.ShardingColumn;
import build.dream.common.basic.BasicDomain;
import build.dream.common.constants.Constants;

import java.math.BigDecimal;
import java.math.BigInteger;

@ShardingColumn(fieldName = GoodsAttribute.FieldName.TENANT_ID, columnName = GoodsAttribute.ColumnName.TENANT_ID)
public class GoodsAttribute extends BasicDomain {
    public static final String TABLE_NAME = "goods_attribute";
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
     * 商品ID
     */
    private BigInteger goodsId;
    /**
     * 商品属性组ID
     */
    private BigInteger goodsAttributeGroupId;
    /**
     * 属性名称
     */
    private String name;
    /**
     * 加价
     */
    private BigDecimal price = Constants.DECIMAL_DEFAULT_VALUE;

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

    public BigInteger getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(BigInteger goodsId) {
        this.goodsId = goodsId;
    }

    public BigInteger getGoodsAttributeGroupId() {
        return goodsAttributeGroupId;
    }

    public void setGoodsAttributeGroupId(BigInteger goodsAttributeGroupId) {
        this.goodsAttributeGroupId = goodsAttributeGroupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public static class Builder extends BasicDomain.Builder<Builder, GoodsAttribute> {
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

        public Builder goodsId(BigInteger goodsId) {
            instance.setGoodsId(goodsId);
            return this;
        }

        public Builder goodsAttributeGroupId(BigInteger goodsAttributeGroupId) {
            instance.setGoodsAttributeGroupId(goodsAttributeGroupId);
            return this;
        }

        public Builder name(String name) {
            instance.setName(name);
            return this;
        }

        public Builder price(BigDecimal price) {
            instance.setPrice(price);
            return this;
        }

        @Override
        public GoodsAttribute build() {
            GoodsAttribute goodsAttribute = super.build();
            goodsAttribute.setTenantId(instance.getTenantId());
            goodsAttribute.setTenantCode(instance.getTenantCode());
            goodsAttribute.setBranchId(instance.getBranchId());
            goodsAttribute.setGoodsId(instance.getGoodsId());
            goodsAttribute.setGoodsAttributeGroupId(instance.getGoodsAttributeGroupId());
            goodsAttribute.setName(instance.getName());
            goodsAttribute.setPrice(instance.getPrice());
            return goodsAttribute;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String TENANT_ID = "tenant_id";
        public static final String TENANT_CODE = "tenant_code";
        public static final String BRANCH_ID = "branch_id";
        public static final String GOODS_ID = "goods_id";
        public static final String GOODS_ATTRIBUTE_GROUP_ID = "goods_attribute_group_id";
        public static final String NAME = "name";
        public static final String PRICE = "price";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String TENANT_ID = "tenantId";
        public static final String TENANT_CODE = "tenantCode";
        public static final String BRANCH_ID = "branchId";
        public static final String GOODS_ID = "goodsId";
        public static final String GOODS_ATTRIBUTE_GROUP_ID = "goodsAttributeGroupId";
        public static final String NAME = "name";
        public static final String PRICE = "price";
    }
}
