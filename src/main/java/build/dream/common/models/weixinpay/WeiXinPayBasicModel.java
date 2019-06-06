package build.dream.common.models.weixinpay;

import build.dream.common.models.BasicModel;
import build.dream.common.utils.ApplicationHandler;
import org.apache.commons.lang.StringUtils;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

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
    private String key;
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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
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

    public static class Builder<T extends Builder<T>> {
        private WeiXinPayBasicModel instance;

        public void setWeiXinPayBasicModel(WeiXinPayBasicModel weiXinPayBasicModel) {
            instance = weiXinPayBasicModel;
        }

        public T appId(String appId) {
            instance.setAppId(appId);
            return (T) this;
        }

        public T mchId(String mchId) {
            instance.setMchId(mchId);
            return (T) this;
        }

        public T key(String key) {
            instance.setKey(key);
            return (T) this;
        }

        public T subAppId(String subAppId) {
            instance.setSubAppId(subAppId);
            return (T) this;
        }

        public T subMchId(String subMchId) {
            instance.setSubMchId(subMchId);
            return (T) this;
        }

        public T acceptanceModel(boolean acceptanceModel) {
            instance.setAcceptanceModel(acceptanceModel);
            return (T) this;
        }

        protected void build(WeiXinPayBasicModel weiXinPayBasicModel) {
            weiXinPayBasicModel.setAppId(instance.getAppId());
            weiXinPayBasicModel.setMchId(instance.getMchId());
            weiXinPayBasicModel.setKey(instance.getKey());
            weiXinPayBasicModel.setSubAppId(instance.getSubAppId());
            weiXinPayBasicModel.setSubMchId(instance.getSubMchId());
            weiXinPayBasicModel.setAcceptanceModel(instance.isAcceptanceModel());
        }
    }
}
