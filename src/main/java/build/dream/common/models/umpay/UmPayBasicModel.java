package build.dream.common.models.umpay;

import build.dream.common.constants.Constants;
import build.dream.common.constraints.InList;
import build.dream.common.models.BasicModel;
import build.dream.common.utils.ObjectUtils;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class UmPayBasicModel extends BasicModel {
    @NotNull
    @InList(value = {Constants.CHARSET_NAME_UTF_8, Constants.CHARSET_NAME_GBK, Constants.CHARSET_NAME_GB2312, Constants.CHARSET_NAME_GB18030})
    private String charset = Constants.CHARSET_NAME_UTF_8;

    @NotNull
    @Length(max = 8)
    private String merId;

    @NotNull
    @InList(value = {Constants.RSA})
    private String signType = Constants.RSA;

    @NotNull
    @InList(value = Constants.HTML)
    private String resFormat = Constants.HTML;

    @NotNull
    @Length(max = 3)
    private String version = Constants.UM_PAY_VERSION;

    @NotNull
    private String privateKey;

    @NotNull
    private String platformPublicKey;

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getMerId() {
        return merId;
    }

    public void setMerId(String merId) {
        this.merId = merId;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getResFormat() {
        return resFormat;
    }

    public void setResFormat(String resFormat) {
        this.resFormat = resFormat;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getPlatformPublicKey() {
        return platformPublicKey;
    }

    public void setPlatformPublicKey(String platformPublicKey) {
        this.platformPublicKey = platformPublicKey;
    }

    protected abstract static class Builder<BT extends Builder<BT, MT>, MT extends UmPayBasicModel> {
        protected MT instance;
        private Class<MT> modelClass;

        public Builder() {
            Type type = this.getClass().getGenericSuperclass();
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            modelClass = (Class<MT>) actualTypeArguments[1];
            instance = ObjectUtils.newInstance(modelClass);
        }

        public BT charset(String charset) {
            instance.setCharset(charset);
            return (BT) this;
        }

        public BT merId(String merId) {
            instance.setMerId(merId);
            return (BT) this;
        }

        public BT signType(String signType) {
            instance.setSignType(signType);
            return (BT) this;
        }

        public BT resFormat(String resFormat) {
            instance.setResFormat(resFormat);
            return (BT) this;
        }

        public BT version(String version) {
            instance.setVersion(version);
            return (BT) this;
        }

        public BT privateKey(String privateKey) {
            instance.setPrivateKey(privateKey);
            return (BT) this;
        }

        public BT platformPublicKey(String platformPublicKey) {
            instance.setPlatformPublicKey(platformPublicKey);
            return (BT) this;
        }

        protected MT build() {
            MT model = ObjectUtils.newInstance(modelClass);
            model.setCharset(instance.getCharset());
            model.setMerId(instance.getMerId());
            model.setSignType(instance.getSignType());
            model.setResFormat(instance.getResFormat());
            model.setVersion(instance.getVersion());
            model.setPrivateKey(instance.getPrivateKey());
            model.setPlatformPublicKey(instance.getPlatformPublicKey());
            return model;
        }
    }
}
