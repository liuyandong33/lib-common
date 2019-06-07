package build.dream.common.saas.domains;

import build.dream.common.basic.BasicDomain;
import build.dream.common.constants.Constants;

import java.math.BigInteger;
import java.util.Date;

public class SaleFlow extends BasicDomain {
    public static final String TABLE_NAME = "sale_flow";
    /**
     * 订单id
     */
    private BigInteger orderId;
    /**
     * 销售流水类型，1-商户流水，2-代理商流水
     */
    private Integer type;
    /**
     * 商户id
     */
    private BigInteger tenantId = Constants.BIGINT_DEFAULT_VALUE;
    /**
     * 门店id
     */
    private BigInteger branchId = Constants.BIGINT_DEFAULT_VALUE;
    ;
    /**
     * 代理商id
     */
    private BigInteger agentId = Constants.BIGINT_DEFAULT_VALUE;
    ;
    /**
     * 流水产生时间
     */
    private Date occurrenceTime;
    /**
     * 商品id
     */
    private BigInteger goodsId;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 商品规格id
     */
    private BigInteger goodsSpecificationId;
    /**
     * 商品规格名称
     */
    private String goodsSpecificationName;
    /**
     * 购买数量
     */
    private Integer quantity;
    /**
     * 支付类型，1-微信支付，2-支付宝支付
     */
    private Integer paidType;

    public BigInteger getOrderId() {
        return orderId;
    }

    public void setOrderId(BigInteger orderId) {
        this.orderId = orderId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public BigInteger getTenantId() {
        return tenantId;
    }

    public void setTenantId(BigInteger tenantId) {
        this.tenantId = tenantId;
    }

    public BigInteger getBranchId() {
        return branchId;
    }

    public void setBranchId(BigInteger branchId) {
        this.branchId = branchId;
    }

    public BigInteger getAgentId() {
        return agentId;
    }

    public void setAgentId(BigInteger agentId) {
        this.agentId = agentId;
    }

    public Date getOccurrenceTime() {
        return occurrenceTime;
    }

    public void setOccurrenceTime(Date occurrenceTime) {
        this.occurrenceTime = occurrenceTime;
    }

    public BigInteger getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(BigInteger goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public BigInteger getGoodsSpecificationId() {
        return goodsSpecificationId;
    }

    public void setGoodsSpecificationId(BigInteger goodsSpecificationId) {
        this.goodsSpecificationId = goodsSpecificationId;
    }

    public String getGoodsSpecificationName() {
        return goodsSpecificationName;
    }

    public void setGoodsSpecificationName(String goodsSpecificationName) {
        this.goodsSpecificationName = goodsSpecificationName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getPaidType() {
        return paidType;
    }

    public void setPaidType(Integer paidType) {
        this.paidType = paidType;
    }

    public static class Builder extends BasicDomain.Builder<Builder, SaleFlow> {
        public Builder orderId(BigInteger orderId) {
            instance.setOrderId(orderId);
            return this;
        }

        public Builder type(Integer type) {
            instance.setType(type);
            return this;
        }

        public Builder tenantId(BigInteger tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(BigInteger branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public Builder agentId(BigInteger agentId) {
            instance.setAgentId(agentId);
            return this;
        }

        public Builder occurrenceTime(Date occurrenceTime) {
            instance.setOccurrenceTime(occurrenceTime);
            return this;
        }

        public Builder goodsId(BigInteger goodsId) {
            instance.setGoodsId(goodsId);
            return this;
        }

        public Builder goodsName(String goodsName) {
            instance.setGoodsName(goodsName);
            return this;
        }

        public Builder goodsSpecificationId(BigInteger goodsSpecificationId) {
            instance.setGoodsSpecificationId(goodsSpecificationId);
            return this;
        }

        public Builder goodsSpecificationName(String goodsSpecificationName) {
            instance.setGoodsSpecificationName(goodsSpecificationName);
            return this;
        }

        public Builder quantity(Integer quantity) {
            instance.setQuantity(quantity);
            return this;
        }

        public Builder paidType(Integer paidType) {
            instance.setPaidType(paidType);
            return this;
        }

        @Override
        public SaleFlow build() {
            SaleFlow saleFlow = super.build();
            saleFlow.setOrderId(instance.getOrderId());
            saleFlow.setType(instance.getType());
            saleFlow.setTenantId(instance.getTenantId());
            saleFlow.setBranchId(instance.getBranchId());
            saleFlow.setAgentId(instance.getAgentId());
            saleFlow.setOccurrenceTime(instance.getOccurrenceTime());
            saleFlow.setGoodsId(instance.getGoodsId());
            saleFlow.setGoodsName(instance.getGoodsName());
            saleFlow.setGoodsSpecificationId(instance.getGoodsSpecificationId());
            saleFlow.setGoodsSpecificationName(instance.getGoodsSpecificationName());
            saleFlow.setQuantity(instance.getQuantity());
            saleFlow.setPaidType(instance.getPaidType());
            return saleFlow;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String ORDER_ID = "order_id";
        public static final String TYPE = "type";
        public static final String TENANT_ID = "tenant_id";
        public static final String BRANCH_ID = "branch_id";
        public static final String AGENT_ID = "agent_id";
        public static final String OCCURRENCE_TIME = "occurrence_time";
        public static final String GOODS_ID = "goods_id";
        public static final String GOODS_NAME = "goods_name";
        public static final String GOODS_SPECIFICATION_ID = "goods_specification_id";
        public static final String GOODS_SPECIFICATION_NAME = "goods_specification_name";
        public static final String QUANTITY = "quantity";
        public static final String PAID_TYPE = "paid_type";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String ORDER_ID = "orderId";
        public static final String TYPE = "type";
        public static final String TENANT_ID = "tenantId";
        public static final String BRANCH_ID = "branchId";
        public static final String AGENT_ID = "agentId";
        public static final String OCCURRENCE_TIME = "occurrenceTime";
        public static final String GOODS_ID = "goodsId";
        public static final String GOODS_NAME = "goodsName";
        public static final String GOODS_SPECIFICATION_ID = "goodsSpecificationId";
        public static final String GOODS_SPECIFICATION_NAME = "goodsSpecificationName";
        public static final String QUANTITY = "quantity";
        public static final String PAID_TYPE = "paidType";
    }
}
