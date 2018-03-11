package build.dream.common.saas.domains;

import build.dream.common.basic.BasicDomain;

import java.math.BigDecimal;
import java.math.BigInteger;

public class AgentContractPriceInfo extends BasicDomain {
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
}
