package build.dream.common.saas.domains;

import build.dream.common.basic.BasicDomain;

import java.util.Date;

public class Activity extends BasicDomain {
    public static final String TABLE_NAME = "activity";
    /**
     * 活动名称
     */
    private String name;
    /**
     * 开始时间
     */
    private Date startTime;
    /**
     * 结束时间
     */
    private Date endTime;
    /**
     * 活动类型，1-买A赠B活动，2-整单满减活动，3-特价商品活动
     */
    private Integer type;
    /**
     * 活动状态，1-未执行，2-执行中，3-已终止，4-已过期
     */
    private Integer status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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
        public Builder name(String name) {
            instance.setName(name);
            return this;
        }

        public Builder startTime(Date startTime) {
            instance.setStartTime(startTime);
            return this;
        }

        public Builder endTime(Date endTime) {
            instance.setEndTime(endTime);
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
            activity.setName(instance.getName());
            activity.setStartTime(instance.getStartTime());
            activity.setEndTime(instance.getEndTime());
            activity.setType(instance.getType());
            activity.setStatus(instance.getStatus());
            return activity;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String NAME = "name";
        public static final String START_TIME = "start_time";
        public static final String END_TIME = "end_time";
        public static final String TYPE = "type";
        public static final String STATUS = "status";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String NAME = "name";
        public static final String START_TIME = "startTime";
        public static final String END_TIME = "endTime";
        public static final String TYPE = "type";
        public static final String STATUS = "status";
    }
}
