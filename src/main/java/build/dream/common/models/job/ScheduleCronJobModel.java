package build.dream.common.models.job;

import build.dream.common.models.BasicModel;
import org.quartz.Job;
import org.quartz.JobDataMap;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class ScheduleCronJobModel extends BasicModel {
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
    @NotNull
    private String cronExpression;
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

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
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
        private final ScheduleCronJobModel instance = new ScheduleCronJobModel();

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

        public Builder cronExpression(String cronExpression) {
            instance.setCronExpression(cronExpression);
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

        public ScheduleCronJobModel build() {
            ScheduleCronJobModel scheduleCronJobModel = new ScheduleCronJobModel();
            scheduleCronJobModel.setJobName(instance.getJobName());
            scheduleCronJobModel.setJobGroup(instance.getJobGroup());
            scheduleCronJobModel.setJobClass(instance.getJobClass());
            scheduleCronJobModel.setJobDescription(instance.getJobDescription());
            scheduleCronJobModel.setDurability(instance.getDurability());
            scheduleCronJobModel.setShouldRecover(instance.getShouldRecover());
            scheduleCronJobModel.setJobDataMap(instance.getJobDataMap());
            scheduleCronJobModel.setTriggerName(instance.getTriggerName());
            scheduleCronJobModel.setTriggerGroup(instance.getTriggerGroup());
            scheduleCronJobModel.setCronExpression(instance.getCronExpression());
            scheduleCronJobModel.setMisfireInstruction(instance.getMisfireInstruction());
            scheduleCronJobModel.setTriggerDescription(instance.getTriggerDescription());
            scheduleCronJobModel.setStartTime(instance.getStartTime());
            scheduleCronJobModel.setEndTime(instance.getEndTime());
            scheduleCronJobModel.setPriority(instance.getPriority());
            scheduleCronJobModel.setCalendarName(instance.getCalendarName());
            return scheduleCronJobModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
