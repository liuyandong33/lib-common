package build.dream.common.saas.domains;

import build.dream.common.basic.BasicDomain;
import build.dream.common.constants.Constants;

import java.math.BigInteger;
import java.util.Date;

public class ActivationCodeInfo extends BasicDomain {
    /**
     * 代理商id
     */
    private BigInteger agentId;
    /**
     * 购买激活码订单id
     */
    private BigInteger orderId;
    /**
     * 使用激活码订单id
     */
    private BigInteger useOrderId = Constants.BIGINT_DEFAULT_VALUE;
    /**
     * 使用时间
     */
    private Date useTime = Constants.DATETIME_DEFAULT_VALUE;
    /**
     * 过期时间
     */
    private Date expireTime = Constants.DATETIME_DEFAULT_VALUE;
    /**
     * 状态：1-未使用，2-已使用，3-已作废（已过期）
     */
    private Integer status;
    /**
     * 备注
     */
    private String remark;
    /**
     * 激活码
     */
    private String activationCode;
    /**
     * 商品id
     */
    private BigInteger goodsId;
    /**
     * 商品规格id
     */
    private BigInteger goodsSpecificationId;

    public BigInteger getAgentId() {
        return agentId;
    }

    public void setAgentId(BigInteger agentId) {
        this.agentId = agentId;
    }

    public BigInteger getOrderId() {
        return orderId;
    }

    public void setOrderId(BigInteger orderId) {
        this.orderId = orderId;
    }

    public BigInteger getUseOrderId() {
        return useOrderId;
    }

    public void setUseOrderId(BigInteger useOrderId) {
        this.useOrderId = useOrderId;
    }

    public Date getUseTime() {
        return useTime;
    }

    public void setUseTime(Date useTime) {
        this.useTime = useTime;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
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

    public static class Builder {
        private final ActivationCodeInfo instance = new ActivationCodeInfo();

        public Builder agentId(BigInteger agentId) {
            instance.setAgentId(agentId);
            return this;
        }

        public Builder orderId(BigInteger orderId) {
            instance.setOrderId(orderId);
            return this;
        }

        public Builder useOrderId(BigInteger useOrderId) {
            instance.setUseOrderId(useOrderId);
            return this;
        }

        public Builder useTime(Date useTime) {
            instance.setUseTime(useTime);
            return this;
        }

        public Builder expireTime(Date expireTime) {
            instance.setExpireTime(expireTime);
            return this;
        }

        public Builder status(Integer status) {
            instance.setStatus(status);
            return this;
        }

        public Builder remark(String remark) {
            instance.setRemark(remark);
            return this;
        }

        public Builder activationCode(String activationCode) {
            instance.setActivationCode(activationCode);
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

        public Builder id(BigInteger id) {
            instance.setId(id);
            return this;
        }

        public Builder createTime(Date createTime) {
            instance.setCreateTime(createTime);
            return this;
        }

        public Builder createUserId(BigInteger createUserId) {
            instance.setCreateUserId(createUserId);
            return this;
        }

        public Builder lastUpdateTime(Date lastUpdateTime) {
            instance.setLastUpdateTime(lastUpdateTime);
            return this;
        }

        public Builder lastUpdateUserId(BigInteger lastUpdateUserId) {
            instance.setLastUpdateUserId(lastUpdateUserId);
            return this;
        }

        public Builder lastUpdateRemark(String lastUpdateRemark) {
            instance.setLastUpdateRemark(lastUpdateRemark);
            return this;
        }

        public Builder deleteTime(Date deleteTime) {
            instance.setDeleteTime(deleteTime);
            return this;
        }

        public Builder deleted(boolean deleted) {
            instance.setDeleted(deleted);
            return this;
        }

        public ActivationCodeInfo build() {
            return instance;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String AGENT_ID = "agent_id";
        public static final String ORDER_ID = "order_id";
        public static final String USE_ORDER_ID = "use_order_id";
        public static final String USE_TIME = "use_time";
        public static final String EXPIRE_TIME = "expire_time";
        public static final String STATUS = "status";
        public static final String REMARK = "remark";
        public static final String ACTIVATION_CODE = "activation_code";
        public static final String GOODS_ID = "goods_id";
        public static final String GOODS_SPECIFICATION_ID = "goods_specification_id";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String AGENT_ID = "agentId";
        public static final String ORDER_ID = "orderId";
        public static final String USE_ORDER_ID = "useOrderId";
        public static final String USE_TIME = "useTime";
        public static final String EXPIRE_TIME = "expireTime";
        public static final String STATUS = "status";
        public static final String REMARK = "remark";
        public static final String ACTIVATION_CODE = "activationCode";
        public static final String GOODS_ID = "goodsId";
        public static final String GOODS_SPECIFICATION_ID = "goodsSpecificationId";
    }
}
