package build.dream.common.domains.catering;

import java.sql.Time;

public class BusinessTime {
    public static final String TABLE_NAME = "business_time";
    private Long id;

    /**
     * 商户ID
     */
    private Long tenantId;

    /**
     * 商户号
     */
    private String tenantCode;

    /**
     * 门店ID
     */
    private Long branchId;

    /**
     * 星期标记，素数原理
     */
    private Integer weekSign;

    /**
     * 开始时间
     */
    private Time startTime;

    /**
     * 结束时间
     */
    private Time endTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public String getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    public Integer getWeekSign() {
        return weekSign;
    }

    public void setWeekSign(Integer weekSign) {
        this.weekSign = weekSign;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }
}
