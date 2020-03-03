package build.dream.common.domains.catering;

import build.dream.common.annotations.ShardingColumn;
import build.dream.common.basic.BasicDomain;
import build.dream.common.constants.Constants;

@ShardingColumn(fieldName = GoodsSpecification.FieldName.TENANT_ID, columnName = GoodsSpecification.ColumnName.TENANT_ID)
public class GoodsSpecification extends BasicDomain {
    public static final String TABLE_NAME = "goods_specification";

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
     * 规格名称
     */
    private String name;
    /**
     * 口味加价
     */
    private Double price = Constants.DECIMAL_DEFAULT_VALUE;
    /**
     * 库存数量
     */
    private Double stock;

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getStock() {
        return stock;
    }

    public void setStock(Double stock) {
        this.stock = stock;
    }

    public static class Builder extends BasicDomain.Builder<Builder, GoodsSpecification> {
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

        public Builder price(Double price) {
            instance.setPrice(price);
            return this;
        }

        public Builder stock(Double stock) {
            instance.setStock(stock);
            return this;
        }

        @Override
        public GoodsSpecification build() {
            GoodsSpecification goodsSpecification = super.build();
            goodsSpecification.setTenantId(instance.getTenantId());
            goodsSpecification.setTenantCode(instance.getTenantCode());
            goodsSpecification.setBranchId(instance.getBranchId());
            goodsSpecification.setGoodsId(instance.getGoodsId());
            goodsSpecification.setName(instance.getName());
            goodsSpecification.setPrice(instance.getPrice());
            goodsSpecification.setStock(instance.getStock());
            return goodsSpecification;
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
        public static final String PRICE = "price";
        public static final String STOCK = "stock";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String TENANT_ID = "tenantId";
        public static final String TENANT_CODE = "tenantCode";
        public static final String BRANCH_ID = "branchId";
        public static final String GOODS_ID = "goodsId";
        public static final String NAME = "name";
        public static final String PRICE = "price";
        public static final String STOCK = "stock";
    }
}
