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


    public SendResult send(Message message) {
        return obtainProducerBean().send(message);
    }

    public void sendOneway(Message message) {
        obtainProducerBean().sendOneway(message);
    }

    public void sendAsync(Message message, SendCallback sendCallback) {
        obtainProducerBean().sendAsync(message, sendCallback);
    }
}
