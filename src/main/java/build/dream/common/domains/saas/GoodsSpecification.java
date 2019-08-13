package build.dream.common.domains.saas;

import build.dream.common.basic.BasicDomain;
import build.dream.common.constants.Constants;

import java.math.BigDecimal;
import java.math.BigInteger;

public class GoodsSpecification extends BasicDomain {
    public static final String TABLE_NAME = "goods_specification";
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
    private Integer renewalTime = Constants.INT_DEFAULT_VALUE;
    /**
     * 商户价格
     */
    private BigDecimal tenantPrice = Constants.DECIMAL_DEFAULT_VALUE;
    /**
     * 代理商价格
     */
    private BigDecimal agentPrice = Constants.DECIMAL_DEFAULT_VALUE;

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

    public static class Builder extends BasicDomain.Builder<Builder, GoodsSpecification> {
        public Builder name(String name) {
            instance.setName(name);
            return this;
        }

        public Builder goodsId(BigInteger goodsId) {
            instance.setGoodsId(goodsId);
            return this;
        }

        public Builder allowTenantBuy(boolean allowTenantBuy) {
            instance.setAllowTenantBuy(allowTenantBuy);
            return this;
        }

        public Builder allowAgentBuy(boolean allowAgentBuy) {
            instance.setAllowAgentBuy(allowAgentBuy);
            return this;
        }

        public Builder renewalTime(Integer renewalTime) {
            instance.setRenewalTime(renewalTime);
            return this;
        }

        public Builder tenantPrice(BigDecimal tenantPrice) {
            instance.setTenantPrice(tenantPrice);
            return this;
        }

        public Builder agentPrice(BigDecimal agentPrice) {
            instance.setAgentPrice(agentPrice);
            return this;
        }

        @Override
        public GoodsSpecification build() {
            GoodsSpecification goodsSpecification = super.build();
            goodsSpecification.setName(instance.getName());
            goodsSpecification.setGoodsId(instance.getGoodsId());
            goodsSpecification.setAllowTenantBuy(instance.isAllowTenantBuy());
            goodsSpecification.setAllowAgentBuy(instance.isAllowAgentBuy());
            goodsSpecification.setRenewalTime(instance.getRenewalTime());
            goodsSpecification.setTenantPrice(instance.getTenantPrice());
            goodsSpecification.setAgentPrice(instance.getAgentPrice());
            return goodsSpecification;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String NAME = "name";
        public static final String GOODS_ID = "goods_id";
        public static final String ALLOW_TENANT_BUY = "allow_tenant_buy";
        public static final String ALLOW_AGENT_BUY = "allow_agent_buy";
        public static final String RENEWAL_TIME = "renewal_time";
        public static final String TENANT_PRICE = "tenant_price";
        public static final String AGENT_PRICE = "agent_price";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String NAME = "name";
        public static final String GOODS_ID = "goodsId";
        public static final String ALLOW_TENANT_BUY = "allowTenantBuy";
        public static final String ALLOW_AGENT_BUY = "allowAgentBuy";
        public static final String RENEWAL_TIME = "renewalTime";
        public static final String TENANT_PRICE = "tenantPrice";
        public static final String AGENT_PRICE = "agentPrice";
    }
}
