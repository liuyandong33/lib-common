package build.dream.common.saas.domains;

import build.dream.common.basic.BasicDomain;

import java.math.BigInteger;
import java.util.Date;

public class NewLandAccount extends BasicDomain {
    /**
     * 商户ID
     */
    private BigInteger tenantId;
    /**
     * 门店ID
     */
    private BigInteger branchId;
    /**
     * 新大陆支付商户号
     */
    private String mchId;
    /**
     * 新大陆支付设备号
     */
    private String trmNo;
    /**
     * 新大陆支付机构号
     */
    private String orgNo;
    /**
     * 新大陆支付密钥
     */
    private String secretKey;

    public BigInteger getTenantId() {
        return tenantId;
    }

    public void setTenantId(BigInteger tenantId) {
        this.tenantId = tenantId;
    }

    public BigInteger getBranchId() {
        return branchId;
    }

    public void setBranchId(BigInteger branchId) {
        this.branchId = branchId;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getTrmNo() {
        return trmNo;
    }

    public void setTrmNo(String trmNo) {
        this.trmNo = trmNo;
    }

    public String getOrgNo() {
        return orgNo;
    }

    public void setOrgNo(String orgNo) {
        this.orgNo = orgNo;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public static class Builder {
        private final NewLandAccount instance = new NewLandAccount();

        public Builder tenantId(BigInteger tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(BigInteger branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public Builder mchId(String mchId) {
            instance.setMchId(mchId);
            return this;
        }

        public Builder trmNo(String trmNo) {
            instance.setTrmNo(trmNo);
            return this;
        }

        public Builder orgNo(String orgNo) {
            instance.setOrgNo(orgNo);
            return this;
        }

        public Builder secretKey(String secretKey) {
            instance.setSecretKey(secretKey);
            return this;
        }

        public Builder id(BigInteger id) {
            instance.setId(id);
            return this;
        }

        public Builder createdTime(Date createdTime) {
            instance.setCreatedTime(createdTime);
            return this;
        }

        public Builder createdUserId(BigInteger createdUserId) {
            instance.setCreatedUserId(createdUserId);
            return this;
        }

        public Builder updatedTime(Date updatedTime) {
            instance.setUpdatedTime(updatedTime);
            return this;
        }

        public Builder updatedUserId(BigInteger updatedUserId) {
            instance.setUpdatedUserId(updatedUserId);
            return this;
        }

        public Builder updatedRemark(String updatedRemark) {
            instance.setUpdatedRemark(updatedRemark);
            return this;
        }

        public Builder deletedTime(Date deletedTime) {
            instance.setDeletedTime(deletedTime);
            return this;
        }

        public Builder deleted(boolean deleted) {
            instance.setDeleted(deleted);
            return this;
        }

        public NewLandAccount build() {
            return instance;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String TENANT_ID = "tenant_id";
        public static final String BRANCH_ID = "branch_id";
        public static final String MCH_ID = "mch_id";
        public static final String TRM_NO = "trm_no";
        public static final String ORG_NO = "org_no";
        public static final String SECRET_KEY = "secret_key";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String TENANT_ID = "tenantId";
        public static final String BRANCH_ID = "branchId";
        public static final String MCH_ID = "mchId";
        public static final String TRM_NO = "trmNo";
        public static final String ORG_NO = "orgNo";
        public static final String SECRET_KEY = "secretKey";
    }
}
