package build.dream.common.domains.catering;

import build.dream.common.annotations.ShardingColumn;
import build.dream.common.basic.BasicDomain;

import java.math.BigInteger;
import java.sql.Time;
import java.util.Date;

@ShardingColumn(fieldName = Activity.FieldName.TENANT_ID, columnName = Activity.ColumnName.TENANT_ID)
public class Activity extends BasicDomain {
    public static final String TABLE_NAME = "activity";
    /**
     * 商户id
     */
    private BigInteger tenantId;
    /**
     * 商户编码
     */
    private String tenantCode;
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
     * 星期标记，素数原理
     */
    private Integer weekSign;
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

    public Integer getWeekSign() {
        return weekSign;
    }

    public void setWeekSign(Integer weekSign) {
        this.weekSign = weekSign;
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

    public static class Builder extends BasicDomain.Builder<Builder, Activity> {
        public Builder tenantId(BigInteger tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder tenantCode(String tenantCode) {
            instance.setTenantCode(tenantCode);
            return this;
        }

        public Builder name(String name) {
            instance.setName(name);
            return this;
        }

        public Builder startDate(Date startDate) {
            instance.setStartDate(startDate);
            return this;
        }

        public Builder startTime(Time startTime) {
            instance.setStartTime(startTime);
            return this;
        }

        public Builder endDate(Date endDate) {
            instance.setEndDate(endDate);
            return this;
        }

        public Builder endTime(Time endTime) {
            instance.setEndTime(endTime);
            return this;
        }

        public Builder weekSign(Integer weekSign) {
            instance.setWeekSign(weekSign);
            return this;
        }

        public Builder type(Integer type) {
            instance.setType(type);
            return this;
        }

        public Builder status(Integer status) {
            instance.setStatus(status);
            return this;
        }

        @Override
        public Activity build() {
            Activity activity = super.build();
            activity.setTenantId(instance.getTenantId());
            activity.setTenantCode(instance.getTenantCode());
            activity.setName(instance.getName());
            activity.setStartDate(instance.getStartDate());
            activity.setStartTime(instance.getStartTime());
            activity.setEndDate(instance.getEndDate());
            activity.setEndTime(instance.getEndTime());
            activity.setWeekSign(instance.weekSign);
            activity.setType(instance.getType());
            activity.setStatus(instance.getStatus());
            return activity;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String TENANT_ID = "tenant_id";
        public static final String TENANT_CODE = "tenant_code";
        public static final String NAME = "name";
        public static final String START_DATE = "start_date";
        public static final String START_TIME = "start_time";
        public static final String END_DATE = "end_date";
        public static final String END_TIME = "end_time";
        public static final String WEEK_SIGN = "week_sign";
        public static final String TYPE = "type";
        public static final String STATUS = "status";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String TENANT_ID = "tenantId";
        public static final String TENANT_CODE = "tenantCode";
        public static final String NAME = "name";
        public static final String START_DATE = "startDate";
        public static final String START_TIME = "startTime";
        public static final String END_DATE = "endDate";
        public static final String END_TIME = "endTime";
        public static final String WEEK_SIGN = "weekSign";
        public static final String TYPE = "type";
        public static final String STATUS = "status";
    }
}
