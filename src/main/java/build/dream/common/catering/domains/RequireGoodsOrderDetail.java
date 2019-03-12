package build.dream.common.catering.domains;

import build.dream.common.basic.BasicDomain;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class RequireGoodsOrderDetail extends BasicDomain {
    public static final String TABLE_NAME = "require_goods_order_detail";
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
     * 进货单ID
     */
    private BigInteger requireGoodsOrderId;

    /**
     * 商品ID
     */
    private BigInteger goodsId;

    /**
     * 商品规格ID
     */
    private BigInteger goodsSpecificationId;

    /**
     * 商品单位ID
     */
    private BigInteger unitId;

    /**
     * 进货价
     */
    private BigDecimal purchasePrice;

    /**
     * 进货数量
     */
    private BigDecimal quantity;

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

    public BigInteger getRequireGoodsOrderId() {
        return requireGoodsOrderId;
    }

    public void setRequireGoodsOrderId(BigInteger requireGoodsOrderId) {
        this.requireGoodsOrderId = requireGoodsOrderId;
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

    public BigInteger getUnitId() {
        return unitId;
    }

    public void setUnitId(BigInteger unitId) {
        this.unitId = unitId;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public static class Builder {
        private final RequireGoodsOrderDetail instance = new RequireGoodsOrderDetail();

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

        public Builder requireGoodsOrderId(BigInteger requireGoodsOrderId) {
            instance.setRequireGoodsOrderId(requireGoodsOrderId);
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

        public Builder unitId(BigInteger unitId) {
            instance.setUnitId(unitId);
            return this;
        }

        public Builder purchasePrice(BigDecimal purchasePrice) {
            instance.setPurchasePrice(purchasePrice);
            return this;
        }

        public Builder quantity(BigDecimal quantity) {
            instance.setQuantity(quantity);
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

        public RequireGoodsOrderDetail build() {
            RequireGoodsOrderDetail requireGoodsOrderDetail = new RequireGoodsOrderDetail();
            requireGoodsOrderDetail.setTenantId(instance.getTenantId());
            requireGoodsOrderDetail.setTenantCode(instance.getTenantCode());
            requireGoodsOrderDetail.setBranchId(instance.getBranchId());
            requireGoodsOrderDetail.setRequireGoodsOrderId(instance.getRequireGoodsOrderId());
            requireGoodsOrderDetail.setGoodsId(instance.getGoodsId());
            requireGoodsOrderDetail.setGoodsSpecificationId(instance.getGoodsSpecificationId());
            requireGoodsOrderDetail.setUnitId(instance.getUnitId());
            requireGoodsOrderDetail.setQuantity(instance.getQuantity());
            requireGoodsOrderDetail.setId(instance.getId());
            requireGoodsOrderDetail.setCreatedTime(instance.getCreatedTime());
            requireGoodsOrderDetail.setCreatedUserId(instance.getCreatedUserId());
            requireGoodsOrderDetail.setUpdatedTime(instance.getUpdatedTime());
            requireGoodsOrderDetail.setUpdatedUserId(instance.getUpdatedUserId());
            requireGoodsOrderDetail.setUpdatedRemark(instance.getUpdatedRemark());
            requireGoodsOrderDetail.setDeletedTime(instance.getDeletedTime());
            requireGoodsOrderDetail.setDeleted(instance.isDeleted());
            return requireGoodsOrderDetail;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String TENANT_ID = "tenant_id";
        public static final String TENANT_CODE = "tenant_code";
        public static final String BRANCH_ID = "branch_id";
        public static final String REQUIRE_GOODS_ORDER_ID = "require_goods_order_id";
        public static final String GOODS_ID = "goods_id";
        public static final String GOODS_SPECIFICATION_ID = "goods_specification_id";
        public static final String UNIT_ID = "unit_id";
        public static final String QUANTITY = "quantity";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String TENANT_ID = "tenantId";
        public static final String TENANT_CODE = "tenantCode";
        public static final String BRANCH_ID = "branchId";
        public static final String REQUIRE_GOODS_ORDER_ID = "requireGoodsOrderId";
        public static final String GOODS_ID = "goodsId";
        public static final String GOODS_SPECIFICATION_ID = "goodsSpecificationId";
        public static final String UNIT_ID = "unitId";
        public static final String QUANTITY = "quantity";
    }
}
