package build.dream.common.models.anubis;

import build.dream.common.constants.ConfigurationKeys;
import build.dream.common.models.BasicModel;
import build.dream.common.utils.ConfigurationUtils;
import build.dream.common.utils.ObjectUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.RandomUtils;

import javax.validation.constraints.NotNull;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class AnubisBasicModel extends BasicModel {
    @NotNull
    @JsonIgnore
    private String appId = ConfigurationUtils.getConfiguration(ConfigurationKeys.ANUBIS_APP_ID);

    @NotNull
    @JsonIgnore
    private String appSecret = ConfigurationUtils.getConfiguration(ConfigurationKeys.ANUBIS_APP_SECRET);

    @NotNull
    @JsonIgnore
    private Integer salt = RandomUtils.nextInt(1000, 9999);

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public Integer getSalt() {
        return salt;
    }

    public void setSalt(Integer salt) {
        this.salt = salt;
    }

    protected abstract static class Builder<BT extends Builder<BT, MT>, MT extends AnubisBasicModel> {
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

        public BT appSecret(String appSecret) {
            instance.setAppSecret(appSecret);
            return (BT) this;
        }

        public BT salt(Integer salt) {
            instance.setSalt(salt);
            return (BT) this;
        }

        public MT build() {
            MT model = ObjectUtils.newInstance(modelClass);
            model.setAppId(instance.getAppId());
            model.setAppSecret(instance.getAppSecret());
            model.setSalt(instance.getSalt());
            return model;
        }
    }
}
