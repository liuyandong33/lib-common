package build.dream.common.models.aliyunpush;

import build.dream.common.models.BasicModel;

import javax.validation.constraints.NotNull;

public class QueryAliasesModel extends BasicModel {
    @NotNull
    private String deviceId;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
}
