package build.dream.common.utils;

import build.dream.common.constants.Constants;
import build.dream.common.jobs.JobWrapper;
import build.dream.common.jobs.UniversalJob;
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

    public static void scheduleSimpleJob(JobWrapper jobWrapper, JobKey jobKey, TriggerKey triggerKey, Date startTime, String jobName) throws SchedulerException {
        Scheduler scheduler = obtainSchedulerFactoryBean().getScheduler();

        JobBuilder jobBuilder = JobBuilder.newJob(UniversalJob.class);
        jobBuilder.withIdentity(jobKey);
        JobDetail jobDetail = jobBuilder.build();
        JobDataMap jobDataMap = jobDetail.getJobDataMap();
        jobDataMap.put(Constants.JOB_NAME, jobName);
        jobDataMap.put(Constants.JOB_WRAPPER_INSTANCE, jobWrapper);

        SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.simpleSchedule();

        TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
        triggerBuilder.withIdentity(triggerKey);
        triggerBuilder.withSchedule(simpleScheduleBuilder);
        triggerBuilder.startAt(startTime);

        Trigger trigger = triggerBuilder.build();
        scheduler.scheduleJob(jobDetail, trigger);
    }

    public static void scheduleCronJob(JobWrapper jobWrapper, JobKey jobKey, TriggerKey triggerKey, String cronExpression, String jobName) throws SchedulerException {
        JobBuilder jobBuilder = JobBuilder.newJob(UniversalJob.class);
        jobBuilder.storeDurably(true);
        jobBuilder.withIdentity(jobKey);
        JobDetail jobDetail = jobBuilder.build();
        JobDataMap jobDataMap = jobDetail.getJobDataMap();
        jobDataMap.put(Constants.JOB_NAME, jobName);
        jobDataMap.put(Constants.JOB_WRAPPER_INSTANCE, jobWrapper);
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);

        TriggerBuilder triggerBuilder = TriggerBuilder.newTrigger();
        triggerBuilder.withIdentity(triggerKey);
        triggerBuilder.withSchedule(cronScheduleBuilder);
        Trigger trigger = triggerBuilder.build();

        Scheduler scheduler = obtainSchedulerFactoryBean().getScheduler();
        scheduler.scheduleJob(jobDetail, trigger);
    }

    public static boolean checkExists(JobKey jobKey) throws SchedulerException {
        Scheduler scheduler = obtainSchedulerFactoryBean().getScheduler();
        return scheduler.checkExists(jobKey);
    }

    public static boolean checkExists(TriggerKey triggerKey) throws SchedulerException {
        Scheduler scheduler = obtainSchedulerFactoryBean().getScheduler();
        return scheduler.checkExists(triggerKey);
    }

    public static void pauseTrigger(TriggerKey triggerKey) throws SchedulerException {
        obtainSchedulerFactoryBean().getScheduler().pauseTrigger(triggerKey);
    }

    public static void pauseJob(JobKey jobKey) throws SchedulerException {
        obtainSchedulerFactoryBean().getScheduler().pauseJob(jobKey);
    }

    public static void unscheduleJob(TriggerKey triggerKey) throws SchedulerException {
        obtainSchedulerFactoryBean().getScheduler().unscheduleJob(triggerKey);
    }

    public static void deleteJob(JobKey jobKey) throws SchedulerException {
        obtainSchedulerFactoryBean().getScheduler().deleteJob(jobKey);
    }
}
