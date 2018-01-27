package build.dream.common.erp.catering.domains;

import build.dream.common.basic.BasicDomain;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class DietOrderActivity extends BasicDomain {
    /**
     * 商户ID
     */
    private BigInteger tenantId;
    /**
     * 商户编码
     */
    private String tenantCode;
    /**
     * 门店ID
     */
    private BigInteger branchId;
    /**
     * diet_order.id
     */
    private BigInteger dietOrderId;
    /**
     * 活动id
     */
    private BigInteger activityId;
    /**
     * 活动名称
     */
    private String activityName;
    /**
     * 活动类型，activity.type
     */
    private Integer activityType;
    /**
     * 金额
     */
    private BigDecimal amount;
    /**
     * 本地ID
     */
    private String localId;
    /**
     * 本地订单ID
     */
    private String localDietOrderId;
    /**
     * 本地创建时间
     */
    private Date localCreateTime;
    /**
     * 本地最后更新时间
     */
    private Date localLastUpdateTime;

    public BigInteger getTenantId() {
        return tenantId;
    }

    public void setTenantId(BigInteger tenantId) {
        this.tenantId = tenantId;
    }

    public String getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }

    public BigInteger getBranchId() {
        return branchId;
    }

    public void setBranchId(BigInteger branchId) {
        this.branchId = branchId;
    }

    public BigInteger getDietOrderId() {
        return dietOrderId;
    }

    public void setDietOrderId(BigInteger dietOrderId) {
        this.dietOrderId = dietOrderId;
    }

    public BigInteger getActivityId() {
        return activityId;
    }

    public void setActivityId(BigInteger activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public Integer getActivityType() {
        return activityType;
    }

    public void setActivityType(Integer activityType) {
        this.activityType = activityType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getLocalId() {
        return localId;
    }

    public void setLocalId(String localId) {
        this.localId = localId;
    }

    public String getLocalDietOrderId() {
        return localDietOrderId;
    }

    public void setLocalDietOrderId(String localDietOrderId) {
        this.localDietOrderId = localDietOrderId;
    }

    public Date getLocalCreateTime() {
        return localCreateTime;
    }

    public void setLocalCreateTime(Date localCreateTime) {
        this.localCreateTime = localCreateTime;
    }

    public Date getLocalLastUpdateTime() {
        return localLastUpdateTime;
    }

    public void setLocalLastUpdateTime(Date localLastUpdateTime) {
        this.localLastUpdateTime = localLastUpdateTime;
    }
}
