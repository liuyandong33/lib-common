package build.dream.common.models.newland;

import build.dream.common.constants.Constants;
import build.dream.common.constraints.InList;
import build.dream.common.models.BasicModel;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class PubSigQryModel extends BasicModel {
    @NotNull
    @Length(max = 15)
    private String orgNo;

    @NotNull
    @Length(max = 15)
    private String mercId;

    @NotNull
    @Length(max = 8)
    private String trmNo;

    @NotNull
    @Length(min = 14, max = 14)
    private String txnTime;

    @NotNull
    @InList(value = {Constants.MD5})
    private String signType = Constants.MD5;

    @Length(max = 256)
    private String attach;

    @NotNull
    private String version = Constants.NEW_LAND_PAY_VERSION_1_0_0;

    @NotNull
    private String secretKey;

    public String getOrgNo() {
        return orgNo;
    }

    public void setOrgNo(String orgNo) {
        this.orgNo = orgNo;
    }

    public String getMercId() {
        return mercId;
    }

    public void setMercId(String mercId) {
        this.mercId = mercId;
    }

    public String getTrmNo() {
        return trmNo;
    }

    public void setTrmNo(String trmNo) {
        this.trmNo = trmNo;
    }

    public String getTxnTime() {
        return txnTime;
    }

    public void setTxnTime(String txnTime) {
        this.txnTime = txnTime;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
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

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public static class Builder {
        private final PubSigQryModel instance = new PubSigQryModel();

        public Builder orgNo(String orgNo) {
            instance.setOrgNo(orgNo);
            return this;
        }

        public Builder mercId(String mercId) {
            instance.setMercId(mercId);
            return this;
        }

        public Builder trmNo(String trmNo) {
            instance.setTrmNo(trmNo);
            return this;
        }

        public Builder txnTime(String txnTime) {
            instance.setTxnTime(txnTime);
            return this;
        }

        public Builder signType(String signType) {
            instance.setSignType(signType);
            return this;
        }

        public Builder attach(String attach) {
            instance.setAttach(attach);
            return this;
        }

        public Builder version(String version) {
            instance.setVersion(version);
            return this;
        }

        public Builder secretKey(String secretKey) {
            instance.setSecretKey(secretKey);
            return this;
        }

        public PubSigQryModel build() {
            PubSigQryModel pubSigQryModel = new PubSigQryModel();
            pubSigQryModel.setOrgNo(instance.getOrgNo());
            pubSigQryModel.setMercId(instance.getMercId());
            pubSigQryModel.setTrmNo(instance.getTrmNo());
            pubSigQryModel.setTxnTime(instance.getTxnTime());
            pubSigQryModel.setSignType(instance.getSignType());
            pubSigQryModel.setAttach(instance.getAttach());
            pubSigQryModel.setVersion(instance.getVersion());
            pubSigQryModel.setSecretKey(instance.getSecretKey());
            return pubSigQryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
