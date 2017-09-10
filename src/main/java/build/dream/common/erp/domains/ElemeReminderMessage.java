package build.dream.common.erp.domains;

import build.dream.common.annotations.SQLType;
import build.dream.common.constants.SQLConstants;

import java.math.BigInteger;
import java.util.Date;

public class ElemeReminderMessage {
    /**
     * ID
     */
    @SQLType(value = SQLConstants.SQL_TYPE_BIGINT, notNull = true, autoIncrement = true, primaryKey = true, comment = "ID")
    private BigInteger id;
    /**
     * 饿了么订单ID,eleme_order.id
     */
    @SQLType(value = SQLConstants.SQL_TYPE_BIGINT, comment = "饿了么订单ID,eleme_order.id")
    private BigInteger elemeOrderId;
    /**
     * 饿了么系统订单ID
     */
    @SQLType(value = SQLConstants.SQL_TYPE_VARCHAR, length = "(50)", comment = "饿了么系统订单ID")
    private String orderId;
    /**
     * 饿了么系统催单ID
     */
    @SQLType(value = SQLConstants.SQL_TYPE_BIGINT, comment = "饿了么系统催单ID")
    private BigInteger elemeReminderId;
    /**
     * 发起催单的饿了么系统用户id
     */
    @SQLType(value = SQLConstants.SQL_TYPE_BIGINT, comment = "发起催单的饿了么系统用户id")
    private BigInteger userId;
    /**
     * 饿了么店铺ID
     */
    @SQLType(value = SQLConstants.SQL_TYPE_BIGINT, comment = "饿了么店铺ID")
    private BigInteger shopId;
    /**
     * 消息发送时间戳
     */
    @SQLType(value = SQLConstants.SQL_TYPE_DATETIME, comment = "消息发送时间戳")
    private Date updateTime;
    /**
     * 商户ID
     */
    @SQLType(value = SQLConstants.SQL_TYPE_BIGINT, notNull = true, comment = "商户ID")
    private BigInteger tenantId;
    /**
     * 门店ID
     */
    @SQLType(value = SQLConstants.SQL_TYPE_BIGINT, notNull = true, comment = "门店ID")
    private BigInteger branchId;
    @SQLType(value = SQLConstants.SQL_TYPE_DATETIME, notNull = true, defaultValue = "NOW()", comment = "创建时间")
    private Date createTime;
    @SQLType(value = SQLConstants.SQL_TYPE_BIGINT, notNull = true, comment = "创建用户ID")
    private BigInteger createUserId;
    @SQLType(value = SQLConstants.SQL_TYPE_DATETIME, notNull = true, defaultValue = "NOE()", onUpdate = "NOW()", comment = "最后更新时间")
    private Date lastUpdateTime;
    @SQLType(value = SQLConstants.SQL_TYPE_BIGINT, notNull = true, comment = "最后更新用户ID")
    private BigInteger lastUpdateUserId;
    @SQLType(value = SQLConstants.SQL_TYPE_VARCHAR, length = "(255)", comment = "最后更新备注")
    private String lastUpdateRemark;
    @SQLType(value = SQLConstants.SQL_TYPE_TINYINT, notNull = true, defaultValue = "0", comment = "是否删除，0-为删除，1-已删除")
    private boolean deleted;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

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

    public BigInteger getElemeReminderId() {
        return elemeReminderId;
    }

    public void setElemeReminderId(BigInteger elemeReminderId) {
        this.elemeReminderId = elemeReminderId;
    }

    public BigInteger getUserId() {
        return userId;
    }

    public void setUserId(BigInteger userId) {
        this.userId = userId;
    }

    public BigInteger getShopId() {
        return shopId;
    }

    public void setShopId(BigInteger shopId) {
        this.shopId = shopId;
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
