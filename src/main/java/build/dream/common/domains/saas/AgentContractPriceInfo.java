package build.dream.common.domains.saas;

import build.dream.common.basic.BasicDomain;

public class AgentContractPriceInfo extends BasicDomain {
    public static final String TABLE_NAME = "agent_contract_price_info";
    /**
     * 代理商合同ID
     */
    private Long agentContractId;
    /**
     * 产品ID
     */
    private Long goodsId;
    /**
     * 产品规格ID
     */
    private Long goodsSpecificationId;
    /**
     * 合同价格
     */
    private Double contractPrice;

    public Long getAgentContractId() {
        return agentContractId;
    }

    public void setAgentContractId(Long agentContractId) {
        this.agentContractId = agentContractId;
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

    public Double getContractPrice() {
        return contractPrice;
    }

    public void setContractPrice(Double contractPrice) {
        this.contractPrice = contractPrice;
    }

    public static class Builder extends BasicDomain.Builder<Builder, AgentContractPriceInfo> {
        public Builder agentContractId(Long agentContractId) {
            instance.setAgentContractId(agentContractId);
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

        public Builder contractPrice(Double contractPrice) {
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
