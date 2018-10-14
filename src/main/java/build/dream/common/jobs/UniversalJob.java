package build.dream.common.jobs;

import build.dream.common.constants.Constants;
import build.dream.common.utils.LogUtils;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class UniversalJob extends QuartzJobBean {
    private String className = this.getClass().getName();

    @Override
    protected void executeInternal(JobExecutionContext context) {
        JobDetail jobDetail = context.getJobDetail();
        JobDataMap jobDataMap = jobDetail.getJobDataMap();
        JobWrapper jobWrapper = (JobWrapper) jobDataMap.get(Constants.JOB_WRAPPER_INSTANCE);
        String jobName = jobDataMap.getString(Constants.JOB_NAME);
        try {
            jobWrapper.execute();
        } catch (Exception e) {
            LogUtils.error(jobName + "执行失败", className, "execute", e);
        }
    }
}
