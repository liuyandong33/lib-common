package build.dream.common.saas.domains;

import build.dream.common.basic.BasicDomain;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

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

    public static class Builder {
        private final AgentContractPriceInfo instance = new AgentContractPriceInfo();

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

        public AgentContractPriceInfo build() {
            return instance;
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
