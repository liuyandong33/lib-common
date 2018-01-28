package build.dream.common.saas.domains;

import build.dream.common.basic.BasicDomain;

import java.math.BigDecimal;
import java.math.BigInteger;

public class GoodsSpecification extends BasicDomain {
    /**
     * 规格名称
     */
    private String name;
    /**
     * 产品ID
     */
    private BigInteger goodsId;
    /**
     * 是否允许商户购买
     */
    private boolean allowTenantBuy;
    /**
     * 是否允许代理商购买
     */
    private boolean allowAgentBuy;
    /**
     * 续费时间
     */
    private Integer renewalTime;
    /**
     * 商户价格
     */
    private BigDecimal tenantPrice;
    /**
     * 代理商价格
     */
    private BigDecimal agentPrice;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigInteger getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(BigInteger goodsId) {
        this.goodsId = goodsId;
    }

    public boolean isAllowTenantBuy() {
        return allowTenantBuy;
    }

    public void setAllowTenantBuy(boolean allowTenantBuy) {
        this.allowTenantBuy = allowTenantBuy;
    }

    public boolean isAllowAgentBuy() {
        return allowAgentBuy;
    }

    public void setAllowAgentBuy(boolean allowAgentBuy) {
        this.allowAgentBuy = allowAgentBuy;
    }

    public Integer getRenewalTime() {
        return renewalTime;
    }

    public void setRenewalTime(Integer renewalTime) {
        this.renewalTime = renewalTime;
    }

    public BigDecimal getTenantPrice() {
        return tenantPrice;
    }

    public void setTenantPrice(BigDecimal tenantPrice) {
        this.tenantPrice = tenantPrice;
    }

    public BigDecimal getAgentPrice() {
        return agentPrice;
    }

    public void setAgentPrice(BigDecimal agentPrice) {
        this.agentPrice = agentPrice;
    }
}
