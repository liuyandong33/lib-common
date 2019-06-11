package build.dream.common.beans;

import java.util.Map;

public class BatchProcessingInfo {
    private Integer type;

    private Map<String, Object> info;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Map<String, Object> getInfo() {
        return info;
    }

    public void setInfo(Map<String, Object> info) {
        this.info = info;
    }
}
