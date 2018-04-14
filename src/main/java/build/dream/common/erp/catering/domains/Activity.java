package build.dream.common.erp.catering.domains;

import build.dream.common.basic.BasicDomain;

import java.math.BigInteger;
import java.sql.Time;
import java.util.Date;

public class Activity extends BasicDomain {
    /**
     * 商户id
     */
    private BigInteger tenantId;
    /**
     * 商户编码
     */
    private String tenantCode;
    /**
     * 门店id
     */
    private BigInteger branchId;
    /**
     * 活动名称
     */
    private String name;
    /**
     * 开始日期
     */
    private Date startDate;
    /**
     * 开始时间
     */
    private Time startTime;
    /**
     * 结束日期
     */
    private Date endDate;
    /**
     * 结束时间
     */
    private Time endTime;
    /**
     * 周一是否生效
     */
    private boolean applyMonday;
    /**
     * 周二是否生效
     */
    private boolean applyTuesday;
    /**
     * 周三是否生效
     */
    private boolean applyWednesday;
    /**
     * 周四是否生效
     */
    private boolean applyThursday;
    /**
     * 周五是否生效
     */
    private boolean applyFriday;
    /**
     * 周六是否生效
     */
    private boolean applySaturday;
    /**
     * 周日是否生效
     */
    private boolean applySunday;
    /**
     * 活动类型，1-买A赠B活动，2-整单满减活动，3-特价商品活动
     */
    private Integer type;
    /**
     * 活动状态，1-未执行，2-执行中，3-已终止，4-已过期
     */
    private Integer status;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public boolean isApplyMonday() {
        return applyMonday;
    }

    public void setApplyMonday(boolean applyMonday) {
        this.applyMonday = applyMonday;
    }

    public boolean isApplyTuesday() {
        return applyTuesday;
    }

    public void setApplyTuesday(boolean applyTuesday) {
        this.applyTuesday = applyTuesday;
    }

    public boolean isApplyWednesday() {
        return applyWednesday;
    }

    public void setApplyWednesday(boolean applyWednesday) {
        this.applyWednesday = applyWednesday;
    }

    public boolean isApplyThursday() {
        return applyThursday;
    }

    public void setApplyThursday(boolean applyThursday) {
        this.applyThursday = applyThursday;
    }

    public boolean isApplyFriday() {
        return applyFriday;
    }

    public void setApplyFriday(boolean applyFriday) {
        this.applyFriday = applyFriday;
    }

    public boolean isApplySaturday() {
        return applySaturday;
    }

    public void setApplySaturday(boolean applySaturday) {
        this.applySaturday = applySaturday;
    }

    public boolean isApplySunday() {
        return applySunday;
    }

    public void setApplySunday(boolean applySunday) {
        this.applySunday = applySunday;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
