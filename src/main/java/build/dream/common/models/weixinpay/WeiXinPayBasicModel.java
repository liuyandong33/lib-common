package build.dream.common.models.weixinpay;

import build.dream.common.models.BasicModel;
import build.dream.common.utils.ApplicationHandler;
import build.dream.common.utils.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class WeiXinPayBasicModel extends BasicModel {
    @NotNull
    @Length(max = 32)
    private String appId;
    /**
     * 微信支付商户号
     */
    @NotNull
    @Length(max = 32)
    private String mchId;
    /**
     * api 秘钥
     */
    @NotNull
    private String apiSecretKey;
    /**
     * 微信分配的子商户公众账号ID
     */
    @Length(max = 32)
    private String subAppId;
    /**
     * 子商户商户号
     */
    @Length(max = 32)
    private String subMchId;

    /**
     * 是否为受理关系
     */
    private boolean acceptanceModel;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getApiSecretKey() {
        return apiSecretKey;
    }

    public void setApiSecretKey(String apiSecretKey) {
        this.apiSecretKey = apiSecretKey;
    }

    public String getSubAppId() {
        return subAppId;
    }

    public void setSubAppId(String subAppId) {
        this.subAppId = subAppId;
    }

    public String getSubMchId() {
        return subMchId;
    }

    public void setSubMchId(String subMchId) {
        this.subMchId = subMchId;
    }

    public boolean isAcceptanceModel() {
        return acceptanceModel;
    }

    public void setAcceptanceModel(boolean acceptanceModel) {
        this.acceptanceModel = acceptanceModel;
    }

    @Override
    public boolean validate() {
        if (!super.validate()) {
            return false;
        }
        if (acceptanceModel) {
            return StringUtils.isNotBlank(subMchId);
        }
        return true;
    }

    @Override
    public void validateAndThrow() {
        super.validateAndThrow();
        if (acceptanceModel) {
            ApplicationHandler.notBlank(subMchId, "subMchId");
        }
    }

    public static abstract class Builder<BT extends Builder<BT, MT>, MT extends WeiXinPayBasicModel> {
        protected MT instance;
        private Class<MT> modelClass;

        public Builder() {
            Type type = this.getClass().getGenericSuperclass();
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            modelClass = (Class<MT>) actualTypeArguments[1];
            instance = ObjectUtils.newInstance(modelClass);
        }

        public BT appId(String appId) {
            instance.setAppId(appId);
            return (BT) this;
        }

        public BT mchId(String mchId) {
            instance.setMchId(mchId);
            return (BT) this;
        }

        public BT apiSecretKey(String apiSecretKey) {
            instance.setApiSecretKey(apiSecretKey);
            return (BT) this;
        }

        public BT subAppId(String subAppId) {
            instance.setSubAppId(subAppId);
            return (BT) this;
        }

        public BT subMchId(String subMchId) {
            instance.setSubMchId(subMchId);
            return (BT) this;
        }

        public BT acceptanceModel(boolean acceptanceModel) {
            instance.setAcceptanceModel(acceptanceModel);
            return (BT) this;
        }

        public MT build() {
            MT model = ObjectUtils.newInstance(modelClass);
            model.setAppId(instance.getAppId());
            model.setMchId(instance.getMchId());
            model.setApiSecretKey(instance.getApiSecretKey());
            model.setSubAppId(instance.getSubAppId());
            model.setSubMchId(instance.getSubMchId());
            model.setAcceptanceModel(instance.isAcceptanceModel());
            return model;
        }
    }
}
