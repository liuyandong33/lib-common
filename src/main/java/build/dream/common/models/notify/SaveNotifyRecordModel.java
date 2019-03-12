package build.dream.common.models.notify;

import build.dream.common.models.BasicModel;

import javax.validation.constraints.NotNull;

public class SaveNotifyRecordModel extends BasicModel {
    @NotNull
    private String uuid;

    @NotNull
    private String notifyUrl;

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

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getNotifyUrl() {
        return notifyUrl;
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
        private SaveNotifyRecordModel instance = new SaveNotifyRecordModel();

        public Builder uuid(String uuid) {
            instance.setUuid(uuid);
            return this;
        }

        public Builder notifyUrl(String notifyUrl) {
            instance.setNotifyUrl(notifyUrl);
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

        public SaveNotifyRecordModel build() {
            SaveNotifyRecordModel saveNotifyRecordModel = new SaveNotifyRecordModel();
            saveNotifyRecordModel.setUuid(instance.getUuid());
            saveNotifyRecordModel.setNotifyUrl(instance.getNotifyUrl());
            saveNotifyRecordModel.setAlipayPublicKey(instance.getAlipayPublicKey());
            saveNotifyRecordModel.setAlipaySignType(instance.getAlipaySignType());
            saveNotifyRecordModel.setWeiXinPayApiSecretKey(instance.getWeiXinPayApiSecretKey());
            saveNotifyRecordModel.setWeiXinPaySignType(instance.getWeiXinPaySignType());
            return saveNotifyRecordModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
