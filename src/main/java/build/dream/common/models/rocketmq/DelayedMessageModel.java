package build.dream.common.models.rocketmq;

import java.util.Map;

public class DelayedMessageModel {
    private DelayedType type;
    private Map<String, Object> data;

    public DelayedType getType() {
        return type;
    }

    public void setType(DelayedType type) {
        this.type = type;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
