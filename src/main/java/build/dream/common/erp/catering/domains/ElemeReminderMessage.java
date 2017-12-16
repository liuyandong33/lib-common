package build.dream.common.erp.catering.domains;

import build.dream.common.basic.BasicDomain;

import java.math.BigInteger;
import java.util.Date;

public class ElemeReminderMessage extends BasicDomain {
    /**
     * 饿了么订单ID,eleme_order.id
     */
    private BigInteger elemeOrderId;
    /**
     * 饿了么系统订单ID
     */
    private String orderId;
    /**
     * 饿了么店铺ID
     */
    private BigInteger shopId;
    /**
     * 饿了么系统催单ID
     */
    private BigInteger reminderId;
    /**
     * 发起催单的饿了么系统用户id
     */
    private BigInteger userId;
    /**
     * 消息发送时间戳
     */
    private Date updateTime;
    /**
     * 商户ID
     */
    private BigInteger tenantId;
    /**
     * 门店ID
     */
    private BigInteger branchId;

    public BigInteger getElemeOrderId() {
        return elemeOrderId;
    }

    public void setElemeOrderId(BigInteger elemeOrderId) {
        this.elemeOrderId = elemeOrderId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public BigInteger getShopId() {
        return shopId;
    }

    public void setShopId(BigInteger shopId) {
        this.shopId = shopId;
    }

    public BigInteger getReminderId() {
        return reminderId;
    }

    public void setReminderId(BigInteger reminderId) {
        this.reminderId = reminderId;
    }

    public BigInteger getUserId() {
        return userId;
    }

    public void setUserId(BigInteger userId) {
        this.userId = userId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public BigInteger getTenantId() {
        return tenantId;
    }

    public void setTenantId(BigInteger tenantId) {
        this.tenantId = tenantId;
    }

    public BigInteger getBranchId() {
        return branchId;
    }

    public void setBranchId(BigInteger branchId) {
        this.branchId = branchId;
    }
}
