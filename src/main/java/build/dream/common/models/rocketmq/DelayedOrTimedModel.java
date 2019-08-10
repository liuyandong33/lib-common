package build.dream.common.models.rocketmq;

import java.util.Map;

public class DelayedOrTimedModel {
    private Integer type;
    private Map<String, Object> data;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
