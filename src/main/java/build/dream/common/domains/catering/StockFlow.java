package build.dream.common.domains.catering;

import build.dream.common.annotations.ShardingColumn;
import build.dream.common.basic.BasicDomain;

import java.util.Date;

@ShardingColumn(fieldName = StockFlow.FieldName.TENANT_ID, columnName = StockFlow.ColumnName.TENANT_ID)
public class StockFlow extends BasicDomain {
    public static final String TABLE_NAME = "stock_flow";
    /**
     * 商户ID
     */
    private Long tenantId;

    /**
     * 商户号
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
     * 商品规格ID
     */
    private Long goodsSpecificationId;

    /**
     * 商品单位ID
     */
    private Long unitId;

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

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public static class Builder extends BasicDomain.Builder<Builder, StockFlow> {
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

        public Builder goodsSpecificationId(Long goodsSpecificationId) {
            instance.setGoodsSpecificationId(goodsSpecificationId);
            return this;
        }

        public Builder unitId(Long unitId) {
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

        public Builder quantity(Double quantity) {
            instance.setQuantity(quantity);
            return this;
        }

        @Override
        public StockFlow build() {
            StockFlow stockFlow = super.build();
            stockFlow.setTenantId(instance.getTenantId());
            stockFlow.setTenantCode(instance.getTenantCode());
            stockFlow.setBranchId(instance.getBranchId());
            stockFlow.setGoodsId(instance.getGoodsId());
            stockFlow.setGoodsSpecificationId(instance.getGoodsSpecificationId());
            stockFlow.setUnitId(instance.getUnitId());
            stockFlow.setType(instance.getType());
            stockFlow.setOccurrenceTime(instance.getOccurrenceTime());
            stockFlow.setQuantity(instance.getQuantity());
            return stockFlow;
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
