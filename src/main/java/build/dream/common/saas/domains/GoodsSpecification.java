package build.dream.common.saas.domains;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class GoodsSpecification {
    /**
     * ID
     */
    private BigInteger id;
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
    private Date createTime;
    private BigInteger createUserId;
    private Date lastUpdateTime;
    private BigInteger lastUpdateUserId;
    private String lastUpdateRemark;
    private boolean deleted;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public BigInteger getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(BigInteger createUserId) {
        this.createUserId = createUserId;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public BigInteger getLastUpdateUserId() {
        return lastUpdateUserId;
    }

    public void setLastUpdateUserId(BigInteger lastUpdateUserId) {
        this.lastUpdateUserId = lastUpdateUserId;
    }

    public String getLastUpdateRemark() {
        return lastUpdateRemark;
    }

    public void setLastUpdateRemark(String lastUpdateRemark) {
        this.lastUpdateRemark = lastUpdateRemark;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
