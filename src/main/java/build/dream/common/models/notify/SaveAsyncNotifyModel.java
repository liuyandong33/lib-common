package build.dream.common.models.notify;

import build.dream.common.models.BasicModel;

import javax.validation.constraints.NotNull;

public class SaveAsyncNotifyModel extends BasicModel {
    @NotNull
    private String uuid;

    @NotNull
    private String topic;

    private String alipayPublicKey;

    private String alipaySignType;

    private String weiXinPayApiSecretKey;

    private String weiXinPaySignType;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getAlipayPublicKey() {
        return alipayPublicKey;
    }

    public void setAlipayPublicKey(String alipayPublicKey) {
        this.alipayPublicKey = alipayPublicKey;
    }

    public String getAlipaySignType() {
        return alipaySignType;
    }

    public void setAlipaySignType(String alipaySignType) {
        this.alipaySignType = alipaySignType;
    }

    public String getWeiXinPayApiSecretKey() {
        return weiXinPayApiSecretKey;
    }

    public void setWeiXinPayApiSecretKey(String weiXinPayApiSecretKey) {
        this.weiXinPayApiSecretKey = weiXinPayApiSecretKey;
    }

    public String getWeiXinPaySignType() {
        return weiXinPaySignType;
    }

    public void setWeiXinPaySignType(String weiXinPaySignType) {
        this.weiXinPaySignType = weiXinPaySignType;
    }

    public static class Builder {
        private SaveAsyncNotifyModel instance = new SaveAsyncNotifyModel();

        public Builder uuid(String uuid) {
            instance.setUuid(uuid);
            return this;
        }

        public Builder topic(String topic) {
            instance.setTopic(topic);
            return this;
        }

        public Builder alipayPublicKey(String alipayPublicKey) {
            instance.setAlipayPublicKey(alipayPublicKey);
            return this;
        }

        public Builder alipaySignType(String alipaySignType) {
            instance.setAlipaySignType(alipaySignType);
            return this;
        }

        public Builder weiXinPayApiSecretKey(String weiXinPayApiSecretKey) {
            instance.setWeiXinPayApiSecretKey(weiXinPayApiSecretKey);
            return this;
        }

        public Builder weiXinPaySignType(String weiXinPaySignType) {
            instance.setWeiXinPaySignType(weiXinPaySignType);
            return this;
        }

        public SaveAsyncNotifyModel build() {
            SaveAsyncNotifyModel saveAsyncNotifyModel = new SaveAsyncNotifyModel();
            saveAsyncNotifyModel.setUuid(instance.getUuid());
            saveAsyncNotifyModel.setTopic(instance.getTopic());
            saveAsyncNotifyModel.setAlipayPublicKey(instance.getAlipayPublicKey());
            saveAsyncNotifyModel.setAlipaySignType(instance.getAlipaySignType());
            saveAsyncNotifyModel.setWeiXinPayApiSecretKey(instance.getWeiXinPayApiSecretKey());
            saveAsyncNotifyModel.setWeiXinPaySignType(instance.getWeiXinPaySignType());
            return saveAsyncNotifyModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
