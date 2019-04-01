package build.dream.common.auth;

import build.dream.common.catering.domains.Vip;
import build.dream.common.saas.domains.Tenant;

public class VipUserDetails extends AbstractUserDetails {
    private Tenant tenant;
    private Vip vip;
    private String publicKey;
    private String privateKey;

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public Vip getVip() {
        return vip;
    }

    public void setVip(Vip vip) {
        this.vip = vip;
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
