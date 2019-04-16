package build.dream.common.utils;

import build.dream.common.api.ApiRest;
import build.dream.common.constants.Constants;
import org.apache.commons.collections.MapUtils;
import org.quartz.*;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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

    public static void scheduleSimpleJob(Class<? extends Job> jobClass, JobKey jobKey, TriggerKey triggerKey, Date startTime, JobDataMap jobDataMap) throws SchedulerException {
        Scheduler scheduler = obtainSchedulerFactoryBean().getScheduler();

        JobBuilder jobBuilder = JobBuilder.newJob(jobClass);
        jobBuilder.withIdentity(jobKey);
        JobDetail jobDetail = jobBuilder.build();
        if (MapUtils.isNotEmpty(jobDataMap)) {
            jobDetail.getJobDataMap().putAll(jobDataMap);
        }

        SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.simpleSchedule();

        TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
        triggerBuilder.withIdentity(triggerKey);
        triggerBuilder.withSchedule(simpleScheduleBuilder);
        triggerBuilder.startAt(startTime);

        Trigger trigger = triggerBuilder.build();
        scheduler.scheduleJob(jobDetail, trigger);
    }

    public static void scheduleCronJob(Class<? extends Job> jobClass, JobKey jobKey, TriggerKey triggerKey, String cronExpression, JobDataMap jobDataMap) throws SchedulerException {
        JobBuilder jobBuilder = JobBuilder.newJob(jobClass);
        jobBuilder.withIdentity(jobKey);
        JobDetail jobDetail = jobBuilder.build();
        if (MapUtils.isNotEmpty(jobDataMap)) {
            jobDetail.getJobDataMap().putAll(jobDataMap);
        }
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);

        TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
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

    public static void startOrderInvalidJob(BigInteger tenantId, BigInteger branchId, BigInteger orderId, Date startTime) {
        String partitionCode = ConfigurationUtils.getConfiguration(Constants.PARTITION_CODE);
        Map<String, String> requestParameters = new HashMap<String, String>();
        requestParameters.put("tenantId", tenantId.toString());
        requestParameters.put("branchId", branchId.toString());
        requestParameters.put("orderId", orderId.toString());
        requestParameters.put("startTime", CustomDateUtils.format(startTime, Constants.DEFAULT_DATE_PATTERN));
        ApiRest apiRest = ProxyUtils.doPostWithRequestParameters(partitionCode, Constants.SERVICE_NAME_JOB, "order", "startOrderInvalidJob", requestParameters);
        ValidateUtils.isTrue(apiRest.isSuccessful(), apiRest.getError());
    }

    public static void stopOrderInvalidJob(BigInteger tenantId, BigInteger branchId, BigInteger orderId) {
        String partitionCode = ConfigurationUtils.getConfiguration(Constants.PARTITION_CODE);
        Map<String, String> requestParameters = new HashMap<String, String>();
        requestParameters.put("tenantId", tenantId.toString());
        requestParameters.put("branchId", branchId.toString());
        requestParameters.put("orderId", orderId.toString());
        ApiRest apiRest = ProxyUtils.doPostWithRequestParameters(partitionCode, Constants.SERVICE_NAME_JOB, "order", "stopOrderInvalidJob", requestParameters);
        ValidateUtils.isTrue(apiRest.isSuccessful(), apiRest.getError());
    }
}
