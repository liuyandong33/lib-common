package build.dream.common.utils;

import build.dream.common.models.job.ScheduleCronJobModel;
import build.dream.common.models.job.ScheduleSimpleJobModel;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.quartz.*;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.util.Date;

public class JobUtils {
    private static SchedulerFactoryBean schedulerFactoryBean;

    public static SchedulerFactoryBean obtainSchedulerFactoryBean() {
        if (schedulerFactoryBean == null) {
            schedulerFactoryBean = ApplicationHandler.getBean(SchedulerFactoryBean.class);
        }
        return schedulerFactoryBean;
    }

    public static Scheduler obtainScheduler() {
        return obtainSchedulerFactoryBean().getScheduler();
    }

    /**
     * 安排简单定时任务
     *
     * @param scheduleSimpleJobModel
     * @throws SchedulerException
     */
    public static void scheduleSimpleJob(ScheduleSimpleJobModel scheduleSimpleJobModel) throws SchedulerException {
        String jobName = scheduleSimpleJobModel.getJobName();
        String jobGroup = scheduleSimpleJobModel.getJobGroup();
        String triggerName = scheduleSimpleJobModel.getTriggerName();
        String triggerGroup = scheduleSimpleJobModel.getTriggerGroup();
        Integer interval = scheduleSimpleJobModel.getInterval();
        Integer repeatCount = scheduleSimpleJobModel.getRepeatCount();
        Date startTime = scheduleSimpleJobModel.getStartTime();
        Date endTime = scheduleSimpleJobModel.getEndTime();
        String description = scheduleSimpleJobModel.getDescription();
        Class<? extends Job> jobClass = scheduleSimpleJobModel.getJobClass();
        JobDataMap jobDataMap = scheduleSimpleJobModel.getJobDataMap();

        JobBuilder jobBuilder = JobBuilder.newJob(jobClass);
        jobBuilder.withIdentity(jobName, jobGroup);
        JobDetail jobDetail = jobBuilder.build();
        if (MapUtils.isNotEmpty(jobDataMap)) {
            jobDetail.getJobDataMap().putAll(jobDataMap);
        }

        SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.simpleSchedule();
        if (interval != null) {
            simpleScheduleBuilder.withIntervalInSeconds(interval);
        }

        if (repeatCount != null) {
            simpleScheduleBuilder.withRepeatCount(repeatCount);
        }

        TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
        triggerBuilder.withIdentity(triggerName, triggerGroup);
        triggerBuilder.withSchedule(simpleScheduleBuilder);
        if (startTime != null) {
            triggerBuilder.startAt(startTime);
        }

        if (endTime != null) {
            triggerBuilder.endAt(endTime);
        }

        if (StringUtils.isNotBlank(description)) {
            triggerBuilder.withDescription(description);
        }

        Trigger trigger = triggerBuilder.build();
        obtainScheduler().scheduleJob(jobDetail, trigger);
    }

    /**
     * 安排cron表达式任务
     *
     * @param scheduleCronJobModel
     * @throws SchedulerException
     */
    public static void scheduleCronJob(ScheduleCronJobModel scheduleCronJobModel) throws SchedulerException {
        String jobName = scheduleCronJobModel.getJobName();
        String jobGroup = scheduleCronJobModel.getJobGroup();
        String triggerName = scheduleCronJobModel.getTriggerName();
        String triggerGroup = scheduleCronJobModel.getTriggerGroup();
        String cronExpression = scheduleCronJobModel.getCronExpression();
        Date startTime = scheduleCronJobModel.getStartTime();
        Date endTime = scheduleCronJobModel.getEndTime();
        String description = scheduleCronJobModel.getDescription();
        Class<? extends Job> jobClass = scheduleCronJobModel.getJobClass();
        JobDataMap jobDataMap = scheduleCronJobModel.getJobDataMap();

        JobBuilder jobBuilder = JobBuilder.newJob(jobClass);
        jobBuilder.withIdentity(jobName, jobGroup);
        JobDetail jobDetail = jobBuilder.build();
        if (MapUtils.isNotEmpty(jobDataMap)) {
            jobDetail.getJobDataMap().putAll(jobDataMap);
        }
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);

        TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
        triggerBuilder.withIdentity(triggerName, triggerGroup);
        triggerBuilder.withSchedule(cronScheduleBuilder);
        if (ObjectUtils.isNotNull(startTime)) {
            triggerBuilder.startAt(startTime);
        }

        if (ObjectUtils.isNotNull(endTime)) {
            triggerBuilder.endAt(endTime);
        }

        if (StringUtils.isNotBlank(description)) {
            triggerBuilder.withDescription(description);
        }

        Trigger trigger = triggerBuilder.build();
        obtainScheduler().scheduleJob(jobDetail, trigger);
    }

    public static boolean checkExists(JobKey jobKey) throws SchedulerException {
        return obtainScheduler().checkExists(jobKey);
    }

    public static boolean checkExists(TriggerKey triggerKey) throws SchedulerException {
        return obtainScheduler().checkExists(triggerKey);
    }

    public static void pauseTrigger(TriggerKey triggerKey) throws SchedulerException {
        obtainScheduler().pauseTrigger(triggerKey);
    }

    public static void pauseJob(JobKey jobKey) throws SchedulerException {
        obtainScheduler().pauseJob(jobKey);
    }

    public static void unscheduleJob(TriggerKey triggerKey) throws SchedulerException {
        obtainScheduler().unscheduleJob(triggerKey);
    }

    public static void deleteJob(JobKey jobKey) throws SchedulerException {
        obtainScheduler().deleteJob(jobKey);
    }
}
