package build.dream.common.logback;

import build.dream.common.constants.ConfigurationKeys;
import build.dream.common.utils.PropertyUtils;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.encoder.Encoder;
import com.aliyun.openservices.log.logback.LoghubAppender;
import org.apache.commons.lang3.StringUtils;

public class ALiyunLoghubAppender extends LoghubAppender<ILoggingEvent> {
    public ALiyunLoghubAppender() {
        String endpoint = PropertyUtils.getProperty(ConfigurationKeys.ALIYUN_LOGBACK_ENDPOINT);
        String accessKeyId = PropertyUtils.getProperty(ConfigurationKeys.ALIYUN_LOGBACK_ACCESS_KEY_ID);
        String accessKeySecret = PropertyUtils.getProperty(ConfigurationKeys.ALIYUN_LOGBACK_ACCESS_KEY_SECRET);
        String project = PropertyUtils.getProperty(ConfigurationKeys.ALIYUN_LOGBACK_PROJECT);
        String logStore = PropertyUtils.getProperty(ConfigurationKeys.ALIYUN_LOGBACK_LOG_STORE);

        String topic = PropertyUtils.getProperty(ConfigurationKeys.ALIYUN_LOGBACK_TOPIC);
        String source = PropertyUtils.getProperty(ConfigurationKeys.ALIYUN_LOGBACK_SOURCE);
        String totalSizeInBytes = PropertyUtils.getProperty(ConfigurationKeys.ALIYUN_LOGBACK_TOTAL_SIZE_IN_BYTES);
        String maxBlockMs = PropertyUtils.getProperty(ConfigurationKeys.ALIYUN_LOGBACK_MAX_BLOCK_MS);
        String ioThreadCount = PropertyUtils.getProperty(ConfigurationKeys.ALIYUN_LOGBACK_IO_THREAD_COUNT);
        String batchSizeThresholdInBytes = PropertyUtils.getProperty(ConfigurationKeys.ALIYUN_LOGBACK_BATCH_SIZE_THRESHOLD_IN_BYTES);
        String batchCountThreshold = PropertyUtils.getProperty(ConfigurationKeys.ALIYUN_LOGBACK_BATCH_COUNT_THRESHOLD);
        String lingerMs = PropertyUtils.getProperty(ConfigurationKeys.ALIYUN_LOGBACK_LINGER_MS);
        String retries = PropertyUtils.getProperty(ConfigurationKeys.ALIYUN_LOGBACK_RETRIES);
        String baseRetryBackoffMs = PropertyUtils.getProperty(ConfigurationKeys.ALIYUN_LOGBACK_BASE_RETRY_BACKOFF_MS);
        String maxRetryBackoffMs = PropertyUtils.getProperty(ConfigurationKeys.ALIYUN_LOGBACK_MAX_RETRY_BACKOFF_MS);
        String encoderPattern = PropertyUtils.getProperty(ConfigurationKeys.ALIYUN_LOGBACK_ENCODER_PATTERN);
        String timeFormat = PropertyUtils.getProperty(ConfigurationKeys.ALIYUN_LOGBACK_TIME_FORMAT);
        String timeZone = PropertyUtils.getProperty(ConfigurationKeys.ALIYUN_LOGBACK_TIME_ZONE);

        this.setEndpoint(endpoint);
        this.setAccessKeyId(accessKeyId);
        this.setAccessKeySecret(accessKeySecret);
        this.setProject(project);
        this.setLogStore(logStore);

        if (StringUtils.isNotBlank(topic)) {
            this.setTopic(topic);
        }

        if (StringUtils.isNotBlank(source)) {
            this.setSource(source);
        }

        if (StringUtils.isNotBlank(totalSizeInBytes)) {
            this.setTotalSizeInBytes(Integer.parseInt(totalSizeInBytes));
        }

        if (StringUtils.isNotBlank(maxBlockMs)) {
            this.setMaxBlockMs(Long.parseLong(maxBlockMs));
        }

        if (StringUtils.isNotBlank(ioThreadCount)) {
            this.setIoThreadCount(Integer.parseInt(ioThreadCount));
        }

        if (StringUtils.isNotBlank(batchSizeThresholdInBytes)) {
            this.setBatchSizeThresholdInBytes(Integer.parseInt(batchSizeThresholdInBytes));
        }

        if (StringUtils.isNotBlank(batchCountThreshold)) {
            this.setBatchCountThreshold(Integer.parseInt(batchCountThreshold));
        }

        if (StringUtils.isNotBlank(lingerMs)) {
            this.setLingerMs(Integer.parseInt(lingerMs));
        }

        if (StringUtils.isNotBlank(retries)) {
            this.setRetries(Integer.parseInt(retries));
        }

        if (StringUtils.isNotBlank(baseRetryBackoffMs)) {
            this.setBaseRetryBackoffMs(Long.parseLong(baseRetryBackoffMs));
        }

        if (StringUtils.isNotBlank(maxRetryBackoffMs)) {
            this.setMaxRetryBackoffMs(Long.parseLong(maxRetryBackoffMs));
        }

        if (StringUtils.isNotBlank(timeFormat)) {
            this.setTimeFormat(timeFormat);
        }

        if (StringUtils.isNotBlank(timeZone)) {
            this.setTimeZone(timeZone);
        }

        if (StringUtils.isNotBlank(encoderPattern)) {
            PatternLayoutEncoder patternLayoutEncoder = new PatternLayoutEncoder();
            patternLayoutEncoder.setPattern(encoderPattern);
            this.setEncoder(encoder);
        }
    }
}
