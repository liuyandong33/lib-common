package build.dream.common.aliyunpush;

import build.dream.common.models.aliyunpush.PushMessageModel;
import build.dream.common.utils.AliyunPushUtils;
import build.dream.common.utils.CommonRedisUtils;
import build.dream.common.utils.JacksonUtils;
import build.dream.common.utils.ThreadUtils;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang.StringUtils;

public class AliyunPushMessageThread implements Runnable {
    private boolean continued = true;
    private String uuid;
    private int count;
    private int interval;

    public AliyunPushMessageThread(PushMessageModel pushMessageModel, String uuid, int count, int interval) {
        pushMessageModel.validateAndThrow();
        this.uuid = uuid;
        this.count = count;
        this.interval = interval;
        CommonRedisUtils.set(uuid, JacksonUtils.writeValueAsString(pushMessageModel, JsonInclude.Include.NON_NULL));
    }

    @Override
    public void run() {
        while (continued) {
            String message = CommonRedisUtils.get(uuid);
            if (StringUtils.isBlank(message)) {
                continued = false;
                return;
            }

            try {
                PushMessageModel pushMessageModel = JacksonUtils.readValue(message, PushMessageModel.class);
                AliyunPushUtils.pushMessageToAndroid(pushMessageModel);
            } catch (Exception e) {
                e.printStackTrace();
            }
            count = count - 1;
            if (count <= 0) {
                CommonRedisUtils.del(uuid);
                continued = false;
                return;
            }
            ThreadUtils.sleepSafe(interval);
        }
    }

    public void start() {
        new Thread(this).start();
    }
}
