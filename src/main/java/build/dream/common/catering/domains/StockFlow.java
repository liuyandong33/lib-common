package build.dream.common.catering.domains;

import build.dream.common.basic.BasicDomain;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class StockFlow extends BasicDomain {
    public static final String TABLE_NAME = "stock_flow";
    /**
     * 商户ID
     */
    private BigInteger tenantId;

    /**
     * 商户号
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
     * 商品规格ID
     */
    private BigInteger goodsSpecificationId;

    /**
     * 商品单位ID
     */
    private BigInteger unitId;

    /**
     * 类型，1-进货，2-退货，3-销售
     */
    private Integer type;

    /**
     * 发生时间
     */
    private Date occurrenceTime;

    /**
     * 数量
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getOccurrenceTime() {
        return occurrenceTime;
    }

    public void setOccurrenceTime(Date occurrenceTime) {
        this.occurrenceTime = occurrenceTime;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public static class Builder {
        private final StockFlow instance = new StockFlow();

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

        public Builder goodsSpecificationId(BigInteger goodsSpecificationId) {
            instance.setGoodsSpecificationId(goodsSpecificationId);
            return this;
        }

        public Builder unitId(BigInteger unitId) {
            instance.setUnitId(unitId);
            return this;
        }

        public Builder type(Integer type) {
            instance.setType(type);
            return this;
        }

        public Builder occurrenceTime(Date occurrenceTime) {
            instance.setOccurrenceTime(occurrenceTime);
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

        public StockFlow build() {
            return instance;
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
        public static final String GOODS_SPECIFICATION_ID = "goods_specification_id";
        public static final String UNIT_ID = "unit_id";
        public static final String TYPE = "type";
        public static final String OCCURRENCE_TIME = "occurrence_time";
        public static final String QUANTITY = "quantity";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String TENANT_ID = "tenantId";
        public static final String TENANT_CODE = "tenantCode";
        public static final String BRANCH_ID = "branchId";
        public static final String GOODS_ID = "goodsId";
        public static final String GOODS_SPECIFICATION_ID = "goodsSpecificationId";
        public static final String UNIT_ID = "unitId";
        public static final String TYPE = "type";
        public static final String OCCURRENCE_TIME = "occurrenceTime";
        public static final String QUANTITY = "quantity";
    }
}
