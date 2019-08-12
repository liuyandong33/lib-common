package build.dream.common.rocketmq;

public class RocketMQProperties {
    private String accessKey;
    private String secretKey;
    private String nameSrvAddr;
    private String producerGroupId;
    private String consumerGroupId;

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getNameSrvAddr() {
        return nameSrvAddr;
    }

    public void setNameSrvAddr(String nameSrvAddr) {
        this.nameSrvAddr = nameSrvAddr;
    }

    public String getProducerGroupId() {
        return producerGroupId;
    }

    public void setProducerGroupId(String producerGroupId) {
        this.producerGroupId = producerGroupId;
    }

    public String getConsumerGroupId() {
        return consumerGroupId;
    }

    public void setConsumerGroupId(String consumerGroupId) {
        this.consumerGroupId = consumerGroupId;
    }
}
