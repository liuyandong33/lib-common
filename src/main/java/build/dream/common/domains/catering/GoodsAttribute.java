package build.dream.common.domains.catering;

import build.dream.common.annotations.ShardingColumn;
import build.dream.common.basic.BasicDomain;
import build.dream.common.constants.Constants;

@ShardingColumn(fieldName = GoodsAttribute.FieldName.TENANT_ID, columnName = GoodsAttribute.ColumnName.TENANT_ID)
public class GoodsAttribute extends BasicDomain {
    public static final String TABLE_NAME = "goods_attribute";
    /**
     * 商户ID
     */
    private Long tenantId;
    /**
     * 商户编号
     */
    private String tenantCode;
    /**
     * 门店ID
     */
    private Long branchId;
    /**
     * 商品ID
     */
    private Long goodsId;
    /**
     * 商品属性组ID
     */
    private Long goodsAttributeGroupId;
    /**
     * 属性名称
     */
    private String name;
    /**
     * 加价
     */
    private Double price = Constants.DECIMAL_DEFAULT_VALUE;

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

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getGoodsAttributeGroupId() {
        return goodsAttributeGroupId;
    }

    public void setGoodsAttributeGroupId(Long goodsAttributeGroupId) {
        this.goodsAttributeGroupId = goodsAttributeGroupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public static class Builder extends BasicDomain.Builder<Builder, GoodsAttribute> {
        public Builder tenantId(Long tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder tenantCode(String tenantCode) {
            instance.setTenantCode(tenantCode);
            return this;
        }

        public Builder branchId(Long branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public Builder goodsId(Long goodsId) {
            instance.setGoodsId(goodsId);
            return this;
        }

        public Builder goodsAttributeGroupId(Long goodsAttributeGroupId) {
            instance.setGoodsAttributeGroupId(goodsAttributeGroupId);
            return this;
        }

        public Builder name(String name) {
            instance.setName(name);
            return this;
        }

        public Builder price(Double price) {
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
