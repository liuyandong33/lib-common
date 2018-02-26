package build.dream.common.saas.domains;

import build.dream.common.basic.BasicDomain;

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
    private BigInteger useOrderId;
    /**
     * 使用时间
     */
    private Date useTime;
    /**
     * 过期时间
     */
    private Date expireAt;
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

    public Date getExpireAt() {
        return expireAt;
    }

    public void setExpireAt(Date expireAt) {
        this.expireAt = expireAt;
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
}
