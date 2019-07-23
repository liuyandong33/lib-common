package build.dream.common.models.aliyunpush;

import build.dream.common.models.BasicModel;

import javax.validation.constraints.NotNull;

public class UnbindAliasModel extends BasicModel {
    @NotNull
    private String deviceId;

    private boolean unbindAll;

    private String aliasName;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public boolean isUnbindAll() {
        return unbindAll;
    }

    public void setUnbindAll(boolean unbindAll) {
        this.unbindAll = unbindAll;
    }

    public String getAliasName() {
        return aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }
}
