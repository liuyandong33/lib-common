package build.dream.common.models.suning;

import build.dream.common.utils.ObjectUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class SuningBasicModel {
    protected abstract static class Builder<BT extends Builder<BT, MT>, MT extends SuningBasicModel> {
        protected MT instance;
        private Class<MT> modelClass;

        public Builder() {
            Type type = this.getClass().getGenericSuperclass();
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            modelClass = (Class<MT>) actualTypeArguments[1];
            instance = ObjectUtils.newInstance(modelClass);
        }

        public MT build() {
            MT model = ObjectUtils.newInstance(modelClass);
            return model;
        }
    }
}
