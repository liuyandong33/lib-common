package build.dream.common.utils;

import org.springframework.jms.core.JmsMessagingTemplate;

public class ActiveMQUtils {
    private static JmsMessagingTemplate jmsMessagingTemplate;

    private static JmsMessagingTemplate obtainJmsMessagingTemplate() {
        if (jmsMessagingTemplate == null) {
            jmsMessagingTemplate = ApplicationHandler.getBean(JmsMessagingTemplate.class);
        }
        return jmsMessagingTemplate;
    }
}
