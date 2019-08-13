package build.dream.common.push;

import build.dream.common.domains.catering.Pos;
import build.dream.common.constants.Constants;
import build.dream.common.models.aliyunpush.PushMessageModel;
import build.dream.common.utils.AliyunPushUtils;
import build.dream.common.utils.CommonRedisUtils;
import build.dream.common.utils.MqttUtils;
import build.dream.common.utils.ThreadUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PushPosMessageThread implements Runnable {
    private List<Pos> androidPoses = new ArrayList<Pos>();
    private List<Pos> iosPoses = new ArrayList<Pos>();
    private List<Pos> windowsPoses = new ArrayList<Pos>();

    private PushMessageModel androidPushMessageModel;
    private PushMessageModel iosPushMessageModel;

    private boolean continued = true;
    private String uuid;
    private int count;
    private int interval;
    private String message;

    public PushPosMessageThread(List<Pos> poses, String title, String message, String uuid, int count, int interval) {
        for (Pos pos : poses) {
            String posType = pos.getType();
            if (Constants.POS_TYPE_ANDROID.equals(posType)) {
                androidPoses.add(pos);
            } else if (Constants.POS_TYPE_IOS.equals(posType)) {
                iosPoses.add(pos);
            } else if (Constants.POS_TYPE_WINDOWS.equals(posType)) {
                windowsPoses.add(pos);
            }
        }
        this.uuid = uuid;
        this.count = count;
        this.interval = interval;
        this.message = message;
        CommonRedisUtils.set(uuid, message);

        if (CollectionUtils.isNotEmpty(androidPoses)) {
            List<String> cloudPushDeviceIds = androidPoses.stream().map(Pos::getCloudPushDeviceId).collect(Collectors.toList());
            androidPushMessageModel = PushMessageModel.builder()
                    .appKey(AliyunPushUtils.ANDROID_BUILD_DREAM_AERP_APP_KEY)
                    .target(AliyunPushUtils.TARGET_DEVICE)
                    .targetValue(StringUtils.join(cloudPushDeviceIds, ","))
                    .title(title)
                    .body(message)
                    .build();
        }

        if (CollectionUtils.isNotEmpty(iosPoses)) {
            List<String> cloudPushDeviceIds = iosPoses.stream().map(Pos::getCloudPushDeviceId).collect(Collectors.toList());
            iosPushMessageModel = PushMessageModel.builder()
                    .appKey(AliyunPushUtils.IOS_BUILD_DREAM_AERP_APP_KEY)
                    .target(AliyunPushUtils.TARGET_DEVICE)
                    .targetValue(StringUtils.join(cloudPushDeviceIds, ","))
                    .title(title)
                    .body(message)
                    .build();
        }
    }

    @Override
    public void run() {
        while (continued) {
            if (!CommonRedisUtils.exists(uuid)) {
                continued = false;
                return;
            }

            if (Objects.nonNull(androidPushMessageModel)) {
                AliyunPushUtils.pushMessageToAndroid(androidPushMessageModel);
            }

            if (Objects.nonNull(iosPushMessageModel)) {
                AliyunPushUtils.pushMessageToIos(iosPushMessageModel);
            }

            if (CollectionUtils.isNotEmpty(windowsPoses)) {
                MqttMessage mqttMessage = new MqttMessage(message.getBytes(Constants.CHARSET_UTF_8));
                mqttMessage.setQos(0);
                for (Pos pos : windowsPoses) {
                    MqttUtils.publish(MqttUtils.WPOS_MQTT_TOPIC + "/p2p/" + pos.getMqttClientId(), mqttMessage);
                }
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
