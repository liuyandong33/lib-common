package build.dream.common.models;

import build.dream.common.annotations.InstantiateObjectIgnore;
import org.springframework.security.core.context.SecurityContextHolder;

public class DeviceBasicModel extends OAuthBasicModel {
    @InstantiateObjectIgnore
    private String $clientId;

    public DeviceBasicModel() {
        this.$clientId = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
    }

    public String obtainClientId() {
        return $clientId;
    }
}
