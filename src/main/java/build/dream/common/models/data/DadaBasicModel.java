package build.dream.common.models.data;

import build.dream.common.constants.Constants;
import build.dream.common.models.BasicModel;
import build.dream.common.utils.ConfigurationUtils;
import build.dream.common.utils.ObjectUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class DadaBasicModel extends BasicModel {
    @NotNull
    @JsonIgnore
    private String appKey = ConfigurationUtils.getConfiguration(Constants.DADA_APP_KEY);

    @NotNull
    @JsonIgnore
    private String timestamp = String.valueOf(System.currentTimeMillis() / 1000);

    @NotNull
    @JsonIgnore
    private String format = "json";

    @NotNull
    @JsonIgnore
    private String v = "1.0";

    @NotNull
    @JsonIgnore
    private String sourceId;

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    protected abstract static class Builder<BT extends Builder<BT, MT>, MT extends DadaBasicModel> {
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

        public BT timestamp(String timestamp) {
            instance.setTimestamp(timestamp);
            return (BT) this;
        }

        public BT format(String format) {
            instance.setFormat(format);
            return (BT) this;
        }

        public BT v(String v) {
            instance.setV(v);
            return (BT) this;
        }

        public BT sourceId(String sourceId) {
            instance.setSourceId(sourceId);
            return (BT) this;
        }

        protected MT build() {
            MT model = ObjectUtils.newInstance(modelClass);
            model.setAppKey(instance.getAppKey());
            model.setTimestamp(instance.getTimestamp());
            model.setFormat(instance.getFormat());
            model.setV(instance.getV());
            model.setSourceId(instance.getSourceId());
            return model;
        }
    }
}
