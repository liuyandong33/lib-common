package build.dream.common.models.dingtalk;

import build.dream.common.models.BasicModel;
import build.dream.common.utils.ObjectUtils;

import javax.validation.constraints.NotNull;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class DingtalkBasicModel extends BasicModel {
    @NotNull
    private String appKey;

    @NotNull
    private String appSecret;

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    protected abstract static class Builder<BT extends Builder<BT, MT>, MT extends DingtalkBasicModel> {
        protected MT instance;
        private Class<MT> modelClass;

        public Builder() {
            Type type = this.getClass().getGenericSuperclass();
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            modelClass = (Class<MT>) actualTypeArguments[1];
            instance = ObjectUtils.newInstance(modelClass);
        }

        public BT appKey(String appKey) {
            instance.setAppKey(appKey);
            return (BT) this;
        }

        public BT appSecret(String appSecret) {
            instance.setAppSecret(appSecret);
            return (BT) this;
        }

        public MT build() {
            MT model = ObjectUtils.newInstance(modelClass);
            model.setAppKey(instance.getAppKey());
            model.setAppSecret(instance.getAppSecret());
            return model;
        }
    }
}
