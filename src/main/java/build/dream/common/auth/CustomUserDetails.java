package build.dream.common.auth;

import build.dream.common.saas.domains.SystemUser;
import build.dream.common.saas.domains.Tenant;

import java.util.Map;

public class CustomUserDetails extends AbstractUserDetails {
    private SystemUser systemUser;
    private Tenant tenant;
    private Map<String, Object> branchInfo;
    private String publicKey;
    private String privateKey;

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

    public Map<String, Object> getBranchInfo() {
        return branchInfo;
    }

    public void setBranchInfo(Map<String, Object> branchInfo) {
        this.branchInfo = branchInfo;
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
