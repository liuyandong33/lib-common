package build.dream.common.models.newland;

import build.dream.common.constants.Constants;
import build.dream.common.models.BasicModel;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class PubSigQryModel extends BasicModel {
    @NotNull
    @Length(min = 14, max = 14)
    private String txnTime;

    @Length(max = 256)
    private String attach;

    @NotNull
    private String version = Constants.NEW_LAND_PAY_VERSION_1_0_0;

    public String getTxnTime() {
        return txnTime;
    }

    public void setTxnTime(String txnTime) {
        this.txnTime = txnTime;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
