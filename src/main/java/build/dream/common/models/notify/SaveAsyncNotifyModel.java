package build.dream.common.models.notify;

import build.dream.common.beans.MqConfig;
import build.dream.common.models.BasicModel;

import javax.validation.constraints.NotNull;

public class SaveAsyncNotifyModel extends BasicModel {
    @NotNull
    private String uuid;

    @NotNull
    private MqConfig mqConfig;

    private String alipayPublicKey;

    private String alipaySignType;

    private String weiXinPayApiKey;

    private String weiXinPaySignType;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public MqConfig getMqConfig() {
        return mqConfig;
    }

    public void setMqConfig(MqConfig mqConfig) {
        this.mqConfig = mqConfig;
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

    public String getWeiXinPayApiKey() {
        return weiXinPayApiKey;
    }

    public void setWeiXinPayApiKey(String weiXinPayApiKey) {
        this.weiXinPayApiKey = weiXinPayApiKey;
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

        public Builder mqConfig(MqConfig mqConfig) {
            instance.setMqConfig(mqConfig);
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

        public Builder weiXinPayApiKey(String weiXinPayApiKey) {
            instance.setWeiXinPayApiKey(weiXinPayApiKey);
            return this;
        }

        public Builder weiXinPaySignType(String weiXinPaySignType) {
            instance.setWeiXinPaySignType(weiXinPaySignType);
            return this;
        }

        public SaveAsyncNotifyModel build() {
            SaveAsyncNotifyModel saveAsyncNotifyModel = new SaveAsyncNotifyModel();
            saveAsyncNotifyModel.setUuid(instance.getUuid());
            saveAsyncNotifyModel.setMqConfig(instance.getMqConfig());
            saveAsyncNotifyModel.setAlipayPublicKey(instance.getAlipayPublicKey());
            saveAsyncNotifyModel.setAlipaySignType(instance.getAlipaySignType());
            saveAsyncNotifyModel.setWeiXinPayApiKey(instance.getWeiXinPayApiKey());
            saveAsyncNotifyModel.setWeiXinPaySignType(instance.getWeiXinPaySignType());
            return saveAsyncNotifyModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
