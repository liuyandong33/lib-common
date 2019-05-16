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
    private String triggerName;

    @NotNull
    private String triggerGroup;

    @NotNull
    private String cronExpression;

    private Date startTime;
    private Date endTime;
    private String description;

    @NotNull
    private Class<? extends Job> jobClass;

    private JobDataMap jobDataMap;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Class<? extends Job> getJobClass() {
        return jobClass;
    }

    public void setJobClass(Class<? extends Job> jobClass) {
        this.jobClass = jobClass;
    }

    public JobDataMap getJobDataMap() {
        return jobDataMap;
    }

    public void setJobDataMap(JobDataMap jobDataMap) {
        this.jobDataMap = jobDataMap;
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

        public Builder startTime(Date startTime) {
            instance.setStartTime(startTime);
            return this;
        }

        public Builder endTime(Date endTime) {
            instance.setEndTime(endTime);
            return this;
        }

        public Builder description(String description) {
            instance.setDescription(description);
            return this;
        }

        public Builder jobClass(Class<? extends Job> jobClass) {
            instance.setJobClass(jobClass);
            return this;
        }

        public Builder jobDataMap(JobDataMap jobDataMap) {
            instance.setJobDataMap(jobDataMap);
            return this;
        }

        public ScheduleCronJobModel build() {
            ScheduleCronJobModel scheduleCronJobModel = new ScheduleCronJobModel();
            scheduleCronJobModel.setJobName(instance.getJobName());
            scheduleCronJobModel.setJobGroup(instance.getJobGroup());
            scheduleCronJobModel.setTriggerName(instance.getTriggerName());
            scheduleCronJobModel.setTriggerGroup(instance.getTriggerGroup());
            scheduleCronJobModel.setCronExpression(instance.getCronExpression());
            scheduleCronJobModel.setStartTime(instance.getStartTime());
            scheduleCronJobModel.setEndTime(instance.getEndTime());
            scheduleCronJobModel.setDescription(instance.getDescription());
            scheduleCronJobModel.setJobClass(instance.getJobClass());
            scheduleCronJobModel.setJobDataMap(instance.getJobDataMap());
            return scheduleCronJobModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
