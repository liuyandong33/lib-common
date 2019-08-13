package build.dream.common.domains.saas;

import build.dream.common.basic.BasicDomain;

import java.math.BigDecimal;
import java.math.BigInteger;

public class AgentContractPriceInfo extends BasicDomain {
    public static final String TABLE_NAME = "agent_contract_price_info";
    /**
     * 代理商合同ID
     */
    private BigInteger agentContractId;
    /**
     * 产品ID
     */
    private BigInteger goodsId;
    /**
     * 产品规格ID
     */
    private BigInteger goodsSpecificationId;
    /**
     * 合同价格
     */
    private BigDecimal contractPrice;

    public BigInteger getAgentContractId() {
        return agentContractId;
    }

    public void setAgentContractId(BigInteger agentContractId) {
        this.agentContractId = agentContractId;
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

    public BigDecimal getContractPrice() {
        return contractPrice;
    }

    public void setContractPrice(BigDecimal contractPrice) {
        this.contractPrice = contractPrice;
    }

    public static class Builder extends BasicDomain.Builder<Builder, AgentContractPriceInfo> {
        public Builder agentContractId(BigInteger agentContractId) {
            instance.setAgentContractId(agentContractId);
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

        public Builder contractPrice(BigDecimal contractPrice) {
            instance.setContractPrice(contractPrice);
            return this;
        }

        @Override
        public AgentContractPriceInfo build() {
            AgentContractPriceInfo agentContractPriceInfo = super.build();
            agentContractPriceInfo.setAgentContractId(instance.getAgentContractId());
            agentContractPriceInfo.setGoodsId(instance.getGoodsId());
            agentContractPriceInfo.setGoodsSpecificationId(instance.getGoodsSpecificationId());
            agentContractPriceInfo.setContractPrice(instance.getContractPrice());
            return agentContractPriceInfo;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String AGENT_CONTRACT_ID = "agent_contract_id";
        public static final String GOODS_ID = "goods_id";
        public static final String GOODS_SPECIFICATION_ID = "goods_specification_id";
        public static final String CONTRACT_PRICE = "contract_price";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String AGENT_CONTRACT_ID = "agentContractId";
        public static final String GOODS_ID = "goodsId";
        public static final String GOODS_SPECIFICATION_ID = "goodsSpecificationId";
        public static final String CONTRACT_PRICE = "contractPrice";
    }
}
