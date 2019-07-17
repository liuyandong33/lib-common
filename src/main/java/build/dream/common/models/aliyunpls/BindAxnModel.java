package build.dream.common.models.aliyunpls;

import build.dream.common.models.BasicModel;

import javax.validation.constraints.NotNull;

public class BindAxnModel extends BasicModel {
    /**
     * 绑定关系的过期时间。必须晚于当前时间1分钟以上。
     */
    @NotNull
    private String expiration;

    /**
     * AXN中的A号码。
     * A号码可设置为手机号码或固定电话，固定电话需要加区号，区号和号码中间不需要加连字符，例如057188992688。
     */
    @NotNull
    private String phoneNoA;

    /**
     * 码池Key。请登录号码隐私保护控制台，在号码池管理中查看号码池Key。
     */
    @NotNull
    private String poolKey;

    /**
     * 指定城市进行X号码的选号。
     * 如果当前号池中没有该城市的可用号码，或未指定此参数，将从当前号码池中随机分配一个其他城市的号码作为X号码。
     * 如果配置了严格模式，则不存在符合条件的号码时会提示分配错误。
     */
    private String expectCity;

    /**
     * 是否需要针对该绑定关系产生的所有通话录制通话录音。
     */
    private Boolean isRecordingEnabled;

    /**
     * 号码类型。
     * 说明: 适用于原阿里大于客户，阿里云用户可忽略。
     */
    private String noType;

    /**
     * 外部业务扩展字段，通话记录回执消息中会回传此参数。
     */
    private String outId;

    /**
     * 外部业务ID。
     */
    private String outOrderId;

    /**
     * AXN中的B号码，A号码拨打X号码时会转接到B号码，可通过接口UpdateSubscription更新B号码。
     * B号码可设置为手机号码或固定电话，固定电话需要加区号，区号和号码中间不需要加连字符，例如057188992688。
     */
    private String phoneNoB;

    /**
     * AXN中的X号码。未指定X号码时，将根据参数ExpectCity从指定号码池中随机指定一个号码作为X号码。
     * X号码是您绑定号码前在控制台或通过接口BuySecretNo购买的电话号码，用于转接电话。
     */
    private String phoneNoX;

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public String getPhoneNoA() {
        return phoneNoA;
    }

    public void setPhoneNoA(String phoneNoA) {
        this.phoneNoA = phoneNoA;
    }

    public String getPoolKey() {
        return poolKey;
    }

    public void setPoolKey(String poolKey) {
        this.poolKey = poolKey;
    }

    public String getExpectCity() {
        return expectCity;
    }

    public void setExpectCity(String expectCity) {
        this.expectCity = expectCity;
    }

    public Boolean getIsRecordingEnabled() {
        return isRecordingEnabled;
    }

    public void setIsRecordingEnabled(Boolean isRecordingEnabled) {
        this.isRecordingEnabled = isRecordingEnabled;
    }

    public String getNoType() {
        return noType;
    }

    public void setNoType(String noType) {
        this.noType = noType;
    }

    public String getOutId() {
        return outId;
    }

    public void setOutId(String outId) {
        this.outId = outId;
    }

    public String getOutOrderId() {
        return outOrderId;
    }

    public void setOutOrderId(String outOrderId) {
        this.outOrderId = outOrderId;
    }

    public String getPhoneNoB() {
        return phoneNoB;
    }

    public void setPhoneNoB(String phoneNoB) {
        this.phoneNoB = phoneNoB;
    }

    public String getPhoneNoX() {
        return phoneNoX;
    }

    public void setPhoneNoX(String phoneNoX) {
        this.phoneNoX = phoneNoX;
    }

    public static class Builder {
        private final BindAxnModel instance = new BindAxnModel();

        public Builder expiration(String expiration) {
            instance.setExpiration(expiration);
            return this;
        }

        public Builder phoneNoA(String phoneNoA) {
            instance.setPhoneNoA(phoneNoA);
            return this;
        }

        public Builder poolKey(String poolKey) {
            instance.setPoolKey(poolKey);
            return this;
        }

        public Builder expectCity(String expectCity) {
            instance.setExpectCity(expectCity);
            return this;
        }

        public Builder isRecordingEnabled(Boolean isRecordingEnabled) {
            instance.setIsRecordingEnabled(isRecordingEnabled);
            return this;
        }

        public Builder noType(String noType) {
            instance.setNoType(noType);
            return this;
        }

        public Builder outId(String outId) {
            instance.setOutId(outId);
            return this;
        }

        public Builder outOrderId(String outOrderId) {
            instance.setOutOrderId(outOrderId);
            return this;
        }

        public Builder phoneNoB(String phoneNoB) {
            instance.setPhoneNoB(phoneNoB);
            return this;
        }

        public Builder phoneNoX(String phoneNoX) {
            instance.setPhoneNoX(phoneNoX);
            return this;
        }

        public BindAxnModel build() {
            BindAxnModel bindAxnModel = new BindAxnModel();
            bindAxnModel.setExpiration(instance.getExpiration());
            bindAxnModel.setPhoneNoA(instance.getPhoneNoA());
            bindAxnModel.setPoolKey(instance.getPoolKey());
            bindAxnModel.setExpectCity(instance.getExpectCity());
            bindAxnModel.setIsRecordingEnabled(instance.getIsRecordingEnabled());
            bindAxnModel.setNoType(instance.getNoType());
            bindAxnModel.setOutId(instance.getOutId());
            bindAxnModel.setOutOrderId(instance.getOutOrderId());
            bindAxnModel.setPhoneNoB(instance.getPhoneNoB());
            bindAxnModel.setPhoneNoX(instance.getPhoneNoX());
            return bindAxnModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
