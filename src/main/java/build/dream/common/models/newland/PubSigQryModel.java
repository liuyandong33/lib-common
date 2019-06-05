package build.dream.common.models.newland;

import build.dream.common.constants.Constants;
import build.dream.common.models.BasicModel;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class PubSigQryModel extends BasicModel {
    @NotNull
    private String tenantId;

    @NotNull
    private String branchId;

    @NotNull
    @Length(min = 14, max = 14)
    private String txnTime;

    @Length(max = 256)
    private String attach;

    @NotNull
    private String version = Constants.NEW_LAND_PAY_VERSION_1_0_0;

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

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

    public static class Builder {
        private final PubSigQryModel instance = new PubSigQryModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public Builder txnTime(String txnTime) {
            instance.setTxnTime(txnTime);
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

        public PubSigQryModel build() {
            PubSigQryModel pubSigQryModel = new PubSigQryModel();
            pubSigQryModel.setTenantId(instance.getTenantId());
            pubSigQryModel.setBranchId(instance.getBranchId());
            pubSigQryModel.setTxnTime(instance.getTxnTime());
            pubSigQryModel.setAttach(instance.getAttach());
            pubSigQryModel.setVersion(instance.getVersion());
            return pubSigQryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
