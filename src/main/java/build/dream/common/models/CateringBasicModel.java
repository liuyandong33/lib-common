package build.dream.common.models;

import build.dream.common.auth.CustomUserDetails;
import build.dream.common.erp.catering.domains.Branch;
import build.dream.common.saas.domains.SystemUser;
import build.dream.common.saas.domains.Tenant;
import build.dream.common.utils.ApplicationHandler;
import build.dream.common.utils.WebSecurityUtils;

public class CateringBasicModel implements BasicModel {
    private SystemUser systemUser;
    private Tenant tenant;
    private Branch branch;
    private String publicKey;
    private String privateKey;

    public CateringBasicModel() {
        CustomUserDetails customUserDetails = WebSecurityUtils.obtainCustomUserDetails();
        this.systemUser = customUserDetails.getSystemUser();
        this.tenant = customUserDetails.getTenant();
        this.branch = ApplicationHandler.buildObject(Branch.class, customUserDetails.getBranchInfo());
        this.publicKey = customUserDetails.getPublicKey();
        this.privateKey = customUserDetails.getPrivateKey();
    }

    public SystemUser getSystemUser() {
        return systemUser;
    }

    public void setSystemUser(SystemUser systemUser) {
        this.systemUser = systemUser;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }
}
