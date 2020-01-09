package build.dream.common.utils;

import build.dream.common.models.job.ScheduleCronJobModel;
import build.dream.common.models.job.ScheduleSimpleJobModel;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.quartz.*;
import org.quartz.impl.matchers.GroupMatcher;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.util.*;

public class JobUtils {
    private static SchedulerFactoryBean schedulerFactoryBean;

    public static SchedulerFactoryBean obtainSchedulerFactoryBean() {
        if (Objects.isNull(schedulerFactoryBean)) {
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
        Class<? extends Job> jobClass = scheduleSimpleJobModel.getJobClass();
        String jobDescription = scheduleSimpleJobModel.getJobDescription();
        Boolean durability = scheduleSimpleJobModel.getDurability();
        Boolean shouldRecover = scheduleSimpleJobModel.getShouldRecover();
        JobDataMap jobDataMap = scheduleSimpleJobModel.getJobDataMap();

        String triggerName = scheduleSimpleJobModel.getTriggerName();
        String triggerGroup = scheduleSimpleJobModel.getTriggerGroup();
        Integer interval = scheduleSimpleJobModel.getInterval();
        Integer repeatCount = scheduleSimpleJobModel.getRepeatCount();
        Integer misfireInstruction = scheduleSimpleJobModel.getMisfireInstruction();
        String triggerDescription = scheduleSimpleJobModel.getTriggerDescription();
        Date startTime = scheduleSimpleJobModel.getStartTime();
        Date endTime = scheduleSimpleJobModel.getEndTime();
        Integer priority = scheduleSimpleJobModel.getPriority();
        String calendarName = scheduleSimpleJobModel.getCalendarName();

        JobBuilder jobBuilder = JobBuilder.newJob();
        jobBuilder.withIdentity(jobName, jobGroup);
        jobBuilder.ofType(jobClass);
        if (Objects.nonNull(jobDescription)) {
            jobBuilder.withDescription(jobDescription);
        }
        if (Objects.nonNull(durability)) {
            jobBuilder.storeDurably(durability);
        }
        if (Objects.nonNull(shouldRecover)) {
            jobBuilder.requestRecovery(shouldRecover);
        }
        if (MapUtils.isNotEmpty(jobDataMap)) {
            jobBuilder.setJobData(jobDataMap);
        }

        JobDetail jobDetail = jobBuilder.build();

        SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.simpleSchedule();
        if (Objects.nonNull(interval)) {
            simpleScheduleBuilder.withIntervalInSeconds(interval);
        }

        if (Objects.nonNull(repeatCount)) {
            simpleScheduleBuilder.withRepeatCount(repeatCount);
        }

        if (Objects.nonNull(misfireInstruction)) {
            switch (misfireInstruction) {
                case SimpleTrigger.MISFIRE_INSTRUCTION_SMART_POLICY:
                    break;
                case SimpleTrigger.MISFIRE_INSTRUCTION_FIRE_NOW:
                    simpleScheduleBuilder.withMisfireHandlingInstructionFireNow();
                    break;
                case SimpleTrigger.MISFIRE_INSTRUCTION_RESCHEDULE_NOW_WITH_EXISTING_REPEAT_COUNT:
                    simpleScheduleBuilder.withMisfireHandlingInstructionNowWithExistingCount();
                    break;
                case SimpleTrigger.MISFIRE_INSTRUCTION_RESCHEDULE_NOW_WITH_REMAINING_REPEAT_COUNT:
                    simpleScheduleBuilder.withMisfireHandlingInstructionNowWithRemainingCount();
                    break;
                case SimpleTrigger.MISFIRE_INSTRUCTION_RESCHEDULE_NEXT_WITH_REMAINING_COUNT:
                    simpleScheduleBuilder.withMisfireHandlingInstructionNextWithRemainingCount();
                    break;
                case SimpleTrigger.MISFIRE_INSTRUCTION_RESCHEDULE_NEXT_WITH_EXISTING_COUNT:
                    simpleScheduleBuilder.withMisfireHandlingInstructionNextWithExistingCount();
                    break;
            }
        }

        TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
        triggerBuilder.withIdentity(triggerName, triggerGroup);
        triggerBuilder.withSchedule(simpleScheduleBuilder);
        if (StringUtils.isNotBlank(triggerDescription)) {
            triggerBuilder.withDescription(triggerDescription);
        }
        if (Objects.nonNull(startTime)) {
            triggerBuilder.startAt(startTime);
        }
        if (Objects.nonNull(endTime)) {
            triggerBuilder.endAt(endTime);
        }
        if (Objects.nonNull(priority)) {
            triggerBuilder.withPriority(priority);
        }
        if (Objects.nonNull(calendarName)) {
            triggerBuilder.modifiedByCalendar(calendarName);
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
        Class<? extends Job> jobClass = scheduleCronJobModel.getJobClass();
        String jobDescription = scheduleCronJobModel.getJobDescription();
        Boolean durability = scheduleCronJobModel.getDurability();
        Boolean shouldRecover = scheduleCronJobModel.getShouldRecover();
        JobDataMap jobDataMap = scheduleCronJobModel.getJobDataMap();

        String triggerName = scheduleCronJobModel.getTriggerName();
        String triggerGroup = scheduleCronJobModel.getTriggerGroup();
        String cronExpression = scheduleCronJobModel.getCronExpression();
        Integer misfireInstruction = scheduleCronJobModel.getMisfireInstruction();
        String triggerDescription = scheduleCronJobModel.getTriggerDescription();
        Date startTime = scheduleCronJobModel.getStartTime();
        Date endTime = scheduleCronJobModel.getEndTime();
        Integer priority = scheduleCronJobModel.getPriority();
        String calendarName = scheduleCronJobModel.getCalendarName();

        JobBuilder jobBuilder = JobBuilder.newJob();
        jobBuilder.ofType(jobClass);
        jobBuilder.withIdentity(jobName, jobGroup);
        if (MapUtils.isNotEmpty(jobDataMap)) {
            jobBuilder.setJobData(jobDataMap);
        }
        if (Objects.nonNull(jobDescription)) {
            jobBuilder.withDescription(jobDescription);
        }
        if (Objects.nonNull(durability)) {
            jobBuilder.storeDurably(durability);
        }
        if (Objects.nonNull(shouldRecover)) {
            jobBuilder.requestRecovery(shouldRecover);
        }
        JobDetail jobDetail = jobBuilder.build();
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);
        if (Objects.nonNull(misfireInstruction)) {
            switch (misfireInstruction) {
                case CronTrigger.MISFIRE_INSTRUCTION_SMART_POLICY:
                    break;
                case CronTrigger.MISFIRE_INSTRUCTION_IGNORE_MISFIRE_POLICY:
                    cronScheduleBuilder.withMisfireHandlingInstructionIgnoreMisfires();
                    break;
                case CronTrigger.MISFIRE_INSTRUCTION_FIRE_ONCE_NOW:
                    cronScheduleBuilder.withMisfireHandlingInstructionFireAndProceed();
                    break;
                case CronTrigger.MISFIRE_INSTRUCTION_DO_NOTHING:
                    cronScheduleBuilder.withMisfireHandlingInstructionDoNothing();
                    break;
            }
        }

        TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
        triggerBuilder.withIdentity(triggerName, triggerGroup);
        triggerBuilder.withSchedule(cronScheduleBuilder);
        if (StringUtils.isNotBlank(triggerDescription)) {
            triggerBuilder.withDescription(triggerDescription);
        }
        if (Objects.nonNull(startTime)) {
            triggerBuilder.startAt(startTime);
        }
        if (Objects.nonNull(endTime)) {
            triggerBuilder.endAt(endTime);
        }
        if (Objects.nonNull(priority)) {
            triggerBuilder.withPriority(priority);
        }
        if (Objects.nonNull(calendarName)) {
            triggerBuilder.modifiedByCalendar(calendarName);
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

    public static Set<TriggerKey> obtainAllTriggerKeys() throws SchedulerException {
        Set<TriggerKey> triggerKeys = new HashSet<TriggerKey>();
        Scheduler scheduler = obtainScheduler();
        List<String> triggerGroupNames = scheduler.getTriggerGroupNames();
        for (String triggerGroupName : triggerGroupNames) {
            GroupMatcher groupMatcher = GroupMatcher.groupEquals(triggerGroupName);
            triggerKeys.addAll(scheduler.getTriggerKeys(groupMatcher));
        }
        return triggerKeys;
    }

    public static Set<JobKey> obtainAllJobKeys() throws SchedulerException {
        Set<JobKey> jobKeys = new HashSet<JobKey>();
        Scheduler scheduler = obtainScheduler();
        List<String> jobGroupNames = scheduler.getJobGroupNames();
        for (String jobGroupName : jobGroupNames) {
            GroupMatcher groupMatcher = GroupMatcher.groupEquals(jobGroupName);
            jobKeys.addAll(scheduler.getJobKeys(groupMatcher));
        }
        return jobKeys;
    }

    public static void deleteAllJobs() throws SchedulerException {
        Set<TriggerKey> triggerKeys = obtainAllTriggerKeys();
        for (TriggerKey triggerKey : triggerKeys) {
            JobUtils.unscheduleJob(triggerKey);
        }

        Set<JobKey> jobKeys = obtainAllJobKeys();
        for (JobKey jobKey : jobKeys) {
            JobUtils.deleteJob(jobKey);
        }
    }
}
