package build.dream.common.utils;

import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.SendCallback;
import com.aliyun.openservices.ons.api.SendResult;
import com.aliyun.openservices.ons.api.bean.ProducerBean;

import java.util.Objects;

public class RocketMQUtils {
    private static ProducerBean producerBean;

    private static ProducerBean obtainProducerBean() {
        if (Objects.isNull(producerBean)) {
            producerBean = ApplicationHandler.getBean(ProducerBean.class);
        }
        return producerBean;
    }


    public static SendResult send(Message message) {
        return obtainProducerBean().send(message);
    }

    public static void sendOneway(Message message) {
        obtainProducerBean().sendOneway(message);
    }

    public static void sendAsync(Message message, SendCallback sendCallback) {
        obtainProducerBean().sendAsync(message, sendCallback);
    }
}
