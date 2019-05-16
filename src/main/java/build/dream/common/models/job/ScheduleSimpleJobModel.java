package build.dream.common.models.job;

import build.dream.common.models.BasicModel;
import org.quartz.Job;
import org.quartz.JobDataMap;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class ScheduleSimpleJobModel extends BasicModel {
    @NotNull
    private String jobName;
    @NotNull
    private String jobGroup;
    @NotNull
    private Class<? extends Job> jobClass;
    private String jobDescription;
    private Boolean durability;
    private Boolean shouldRecover;
    private JobDataMap jobDataMap;

    @NotNull
    private String triggerName;
    @NotNull
    private String triggerGroup;
    private Integer interval;
    private Integer repeatCount;
    private Integer misfireInstruction;
    private String triggerDescription;
    private Date startTime;
    private Date endTime;
    private Integer priority;
    private String calendarName;

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobGroup() {
        return jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

    public Class<? extends Job> getJobClass() {
        return jobClass;
    }

    public void setJobClass(Class<? extends Job> jobClass) {
        this.jobClass = jobClass;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public Boolean getDurability() {
        return durability;
    }

    public void setDurability(Boolean durability) {
        this.durability = durability;
    }

    public Boolean getShouldRecover() {
        return shouldRecover;
    }

    public void setShouldRecover(Boolean shouldRecover) {
        this.shouldRecover = shouldRecover;
    }

    public JobDataMap getJobDataMap() {
        return jobDataMap;
    }

    public void setJobDataMap(JobDataMap jobDataMap) {
        this.jobDataMap = jobDataMap;
    }

    public String getTriggerName() {
        return triggerName;
    }

    public void setTriggerName(String triggerName) {
        this.triggerName = triggerName;
    }

    public String getTriggerGroup() {
        return triggerGroup;
    }

    public void setTriggerGroup(String triggerGroup) {
        this.triggerGroup = triggerGroup;
    }

    public Integer getInterval() {
        return interval;
    }

    public void setInterval(Integer interval) {
        this.interval = interval;
    }

    public Integer getRepeatCount() {
        return repeatCount;
    }

    public void setRepeatCount(Integer repeatCount) {
        this.repeatCount = repeatCount;
    }

    public Integer getMisfireInstruction() {
        return misfireInstruction;
    }

    public void setMisfireInstruction(Integer misfireInstruction) {
        this.misfireInstruction = misfireInstruction;
    }

    public String getTriggerDescription() {
        return triggerDescription;
    }

    public void setTriggerDescription(String triggerDescription) {
        this.triggerDescription = triggerDescription;
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

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getCalendarName() {
        return calendarName;
    }

    public void setCalendarName(String calendarName) {
        this.calendarName = calendarName;
    }

    public static class Builder {
        private final ScheduleSimpleJobModel instance = new ScheduleSimpleJobModel();

        public Builder jobName(String jobName) {
            instance.setJobName(jobName);
            return this;
        }

        public Builder jobGroup(String jobGroup) {
            instance.setJobGroup(jobGroup);
            return this;
        }

        public Builder jobClass(Class<? extends Job> jobClass) {
            instance.setJobClass(jobClass);
            return this;
        }

        public Builder jobDescription(String jobDescription) {
            instance.setJobDescription(jobDescription);
            return this;
        }

        public Builder durability(Boolean durability) {
            instance.setDurability(durability);
            return this;
        }

        public Builder shouldRecover(Boolean shouldRecover) {
            instance.setShouldRecover(shouldRecover);
            return this;
        }

        public Builder jobDataMap(JobDataMap jobDataMap) {
            instance.setJobDataMap(jobDataMap);
            return this;
        }

        public Builder triggerName(String triggerName) {
            instance.setTriggerName(triggerName);
            return this;
        }

        public Builder triggerGroup(String triggerGroup) {
            instance.setTriggerGroup(triggerGroup);
            return this;
        }

        public Builder interval(Integer interval) {
            instance.setInterval(interval);
            return this;
        }

        public Builder repeatCount(Integer repeatCount) {
            instance.setRepeatCount(repeatCount);
            return this;
        }

        public Builder misfireInstruction(Integer misfireInstruction) {
            instance.setMisfireInstruction(misfireInstruction);
            return this;
        }

        public Builder triggerDescription(String triggerDescription) {
            instance.setTriggerDescription(triggerDescription);
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

        public Builder priority(Integer priority) {
            instance.setPriority(priority);
            return this;
        }

        public Builder calendarName(String calendarName) {
            instance.setCalendarName(calendarName);
            return this;
        }

        public ScheduleSimpleJobModel build() {
            ScheduleSimpleJobModel scheduleSimpleJobModel = new ScheduleSimpleJobModel();
            scheduleSimpleJobModel.setJobName(instance.getJobName());
            scheduleSimpleJobModel.setJobGroup(instance.getJobGroup());
            scheduleSimpleJobModel.setJobClass(instance.getJobClass());
            scheduleSimpleJobModel.setJobDescription(instance.getJobDescription());
            scheduleSimpleJobModel.setDurability(instance.getDurability());
            scheduleSimpleJobModel.setShouldRecover(instance.getShouldRecover());
            scheduleSimpleJobModel.setJobDataMap(instance.getJobDataMap());
            scheduleSimpleJobModel.setTriggerName(instance.getTriggerName());
            scheduleSimpleJobModel.setTriggerGroup(instance.getTriggerGroup());
            scheduleSimpleJobModel.setInterval(instance.getInterval());
            scheduleSimpleJobModel.setRepeatCount(instance.getRepeatCount());
            scheduleSimpleJobModel.setMisfireInstruction(instance.getMisfireInstruction());
            scheduleSimpleJobModel.setTriggerDescription(instance.getTriggerDescription());
            scheduleSimpleJobModel.setStartTime(instance.getStartTime());
            scheduleSimpleJobModel.setEndTime(instance.getEndTime());
            scheduleSimpleJobModel.setPriority(instance.getPriority());
            scheduleSimpleJobModel.setCalendarName(instance.getCalendarName());
            return scheduleSimpleJobModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
