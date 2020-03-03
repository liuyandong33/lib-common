package build.dream.common.domains.saas;

import build.dream.common.basic.BasicDomain;
import build.dream.common.constants.Constants;

import java.util.Date;

public class ActivationCodeInfo extends BasicDomain {
    public static final String TABLE_NAME = "activation_code_info";
    /**
     * 代理商id
     */
    private Long agentId;
    /**
     * 购买激活码订单id
     */
    private Long orderId;
    /**
     * 使用激活码订单id
     */
    private Long useOrderId = Constants.BIGINT_DEFAULT_VALUE;
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
    private Long goodsId;
    /**
     * 商品规格id
     */
    private Long goodsSpecificationId;

    public Long getAgentId() {
        return agentId;
    }

    public void setAgentId(Long agentId) {
        this.agentId = agentId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getUseOrderId() {
        return useOrderId;
    }

    public void setUseOrderId(Long useOrderId) {
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

    public static class Builder extends BasicDomain.Builder<Builder, ActivationCodeInfo> {
        public Builder agentId(Long agentId) {
            instance.setAgentId(agentId);
            return this;
        }

        public Builder orderId(Long orderId) {
            instance.setOrderId(orderId);
            return this;
        }

        public Builder useOrderId(Long useOrderId) {
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

        public Builder goodsId(Long goodsId) {
            instance.setGoodsId(goodsId);
            return this;
        }

        public Builder goodsSpecificationId(Long goodsSpecificationId) {
            instance.setGoodsSpecificationId(goodsSpecificationId);
            return this;
        }

        @Override
        public ActivationCodeInfo build() {
            ActivationCodeInfo activationCodeInfo = super.build();
            activationCodeInfo.setAgentId(instance.getAgentId());
            activationCodeInfo.setOrderId(instance.getOrderId());
            activationCodeInfo.setUseOrderId(instance.getUseOrderId());
            activationCodeInfo.setUseTime(instance.getUseTime());
            activationCodeInfo.setExpireTime(instance.getExpireTime());
            activationCodeInfo.setStatus(instance.getStatus());
            activationCodeInfo.setRemark(instance.getRemark());
            activationCodeInfo.setActivationCode(instance.getActivationCode());
            activationCodeInfo.setGoodsId(instance.getGoodsId());
            activationCodeInfo.setGoodsSpecificationId(instance.getGoodsSpecificationId());
            return activationCodeInfo;
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
