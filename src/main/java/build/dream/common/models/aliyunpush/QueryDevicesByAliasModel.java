package build.dream.common.models.aliyunpush;

import build.dream.common.models.BasicModel;

import javax.validation.constraints.NotNull;

public class QueryDevicesByAliasModel extends BasicModel {
    @NotNull
    private String alias;

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}
