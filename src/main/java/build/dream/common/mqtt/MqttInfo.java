package build.dream.common.mqtt;

import java.util.Date;

public class MqttInfo {
    /**
     * 内网接入地址
     */
    private String internalEndPoint;
    /**
     * 连接点
     */
    private String endPoint;

    /**
     * Client Id
     */
    private String clientId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 需要订阅的topic
     */
    private String topic;

    /**
     * 过期时间
     */
    private Date expireTime;

    public String getInternalEndPoint() {
        return internalEndPoint;
    }

    public void setInternalEndPoint(String internalEndPoint) {
        this.internalEndPoint = internalEndPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }
}
