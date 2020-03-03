package build.dream.common.domains.catering;

import build.dream.common.annotations.ShardingColumn;
import build.dream.common.basic.BasicDomain;

@ShardingColumn(fieldName = GoodsAttributeGroup.FieldName.TENANT_ID, columnName = GoodsAttributeGroup.ColumnName.TENANT_ID)
public class GoodsAttributeGroup extends BasicDomain {
    public static final String TABLE_NAME = "goods_attribute_group";
    /**
     * 商户ID
     */
    private Long tenantId;

    /**
     * 商户编码
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
     * 属性组名称
     */
    private String name;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static class Builder extends BasicDomain.Builder<Builder, GoodsAttributeGroup> {
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

        public Builder name(String name) {
            instance.setName(name);
            return this;
        }

        @Override
        public GoodsAttributeGroup build() {
            GoodsAttributeGroup goodsAttributeGroup = super.build();
            goodsAttributeGroup.setTenantId(instance.getTenantId());
            goodsAttributeGroup.setTenantCode(instance.getTenantCode());
            goodsAttributeGroup.setBranchId(instance.getBranchId());
            goodsAttributeGroup.setGoodsId(instance.getGoodsId());
            goodsAttributeGroup.setName(instance.getName());
            return goodsAttributeGroup;
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
        public static final String NAME = "name";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String TENANT_ID = "tenantId";
        public static final String TENANT_CODE = "tenantCode";
        public static final String BRANCH_ID = "branchId";
        public static final String GOODS_ID = "goodsId";
        public static final String NAME = "name";
    }
}
