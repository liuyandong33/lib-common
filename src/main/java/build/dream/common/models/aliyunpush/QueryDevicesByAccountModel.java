package build.dream.common.models.aliyunpush;

import build.dream.common.models.BasicModel;

import javax.validation.constraints.NotNull;

public class QueryDevicesByAccountModel extends BasicModel {
    @NotNull
    private String account;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
