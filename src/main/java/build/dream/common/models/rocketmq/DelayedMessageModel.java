package build.dream.common.models.rocketmq;

import java.util.Map;

public class DelayedMessageModel {
    private DelayedOrTimedType type;
    private Map<String, Object> data;

    public DelayedOrTimedType getType() {
        return type;
    }

    public void setType(DelayedOrTimedType type) {
        this.type = type;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
