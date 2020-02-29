package build.dream.common.beans;

public class MqConfig {
    /**
     * 消息队列类型
     */
    private String mqType;

    /**
     * 消息队列主题，kafka
     */
    private String topic;

    /**
     * 交换机rabbitmq 专用
     */
    private String exchange;

    /**
     * 路由rabbitmq 专用
     */
    private String routingKey;

    public String getMqType() {
        return mqType;
    }

    public void setMqType(String mqType) {
        this.mqType = mqType;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getRoutingKey() {
        return routingKey;
    }

    public void setRoutingKey(String routingKey) {
        this.routingKey = routingKey;
    }
}
