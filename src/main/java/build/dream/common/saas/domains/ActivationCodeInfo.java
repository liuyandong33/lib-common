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
}
