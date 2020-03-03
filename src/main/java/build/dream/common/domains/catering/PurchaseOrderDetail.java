package build.dream.common.domains.catering;

import build.dream.common.annotations.ShardingColumn;
import build.dream.common.basic.BasicDomain;

@ShardingColumn(fieldName = PurchaseOrderDetail.FieldName.TENANT_ID, columnName = PurchaseOrderDetail.ColumnName.TENANT_ID)
public class PurchaseOrderDetail extends BasicDomain {
    public static final String TABLE_NAME = "purchase_order_detail";
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
     * 进货单ID
     */
    private Long purchaseOrderId;

    /**
     * 商品ID
     */
    private Long goodsId;

    /**
     * 商品规格ID
     */
    private Long goodsSpecificationId;

    /**
     * 商品单位ID
     */
    private Long unitId;

    /**
     * 进货价
     */
    private Double purchasePrice;

    /**
     * 进货数量
     */
    private Double quantity;

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

    public Long getPurchaseOrderId() {
        return purchaseOrderId;
    }

    public void setPurchaseOrderId(Long purchaseOrderId) {
        this.purchaseOrderId = purchaseOrderId;
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

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    public Double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public static class Builder extends BasicDomain.Builder<Builder, PurchaseOrderDetail> {
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

        public Builder purchaseOrderId(Long purchaseOrderId) {
            instance.setPurchaseOrderId(purchaseOrderId);
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

        public Builder unitId(Long unitId) {
            instance.setUnitId(unitId);
            return this;
        }

        public Builder purchasePrice(Double purchasePrice) {
            instance.setPurchasePrice(purchasePrice);
            return this;
        }

        public Builder quantity(Double quantity) {
            instance.setQuantity(quantity);
            return this;
        }

        @Override
        public PurchaseOrderDetail build() {
            PurchaseOrderDetail purchaseOrderDetail = super.build();
            purchaseOrderDetail.setTenantId(instance.getTenantId());
            purchaseOrderDetail.setTenantCode(instance.getTenantCode());
            purchaseOrderDetail.setBranchId(instance.getBranchId());
            purchaseOrderDetail.setPurchaseOrderId(instance.getPurchaseOrderId());
            purchaseOrderDetail.setGoodsId(instance.getGoodsId());
            purchaseOrderDetail.setGoodsSpecificationId(instance.getGoodsSpecificationId());
            purchaseOrderDetail.setUnitId(instance.getUnitId());
            purchaseOrderDetail.setPurchasePrice(instance.getPurchasePrice());
            purchaseOrderDetail.setQuantity(instance.getQuantity());
            return purchaseOrderDetail;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String TENANT_ID = "tenant_id";
        public static final String TENANT_CODE = "tenant_code";
        public static final String BRANCH_ID = "branch_id";
        public static final String PURCHASE_ORDER_ID = "purchase_order_id";
        public static final String GOODS_ID = "goods_id";
        public static final String GOODS_SPECIFICATION_ID = "goods_specification_id";
        public static final String UNIT_ID = "unit_id";
        public static final String PURCHASE_PRICE = "purchase_price";
        public static final String QUANTITY = "quantity";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String TENANT_ID = "tenantId";
        public static final String TENANT_CODE = "tenantCode";
        public static final String BRANCH_ID = "branchId";
        public static final String PURCHASE_ORDER_ID = "purchaseOrderId";
        public static final String GOODS_ID = "goodsId";
        public static final String GOODS_SPECIFICATION_ID = "goodsSpecificationId";
        public static final String UNIT_ID = "unitId";
        public static final String PURCHASE_PRICE = "purchasePrice";
        public static final String QUANTITY = "quantity";
    }
}
