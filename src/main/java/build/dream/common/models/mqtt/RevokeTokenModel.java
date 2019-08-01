package build.dream.common.models.mqtt;

import build.dream.common.models.BasicModel;

import javax.validation.constraints.NotNull;

public class RevokeTokenModel extends BasicModel {
    @NotNull
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public static class Builder {
        private final RevokeTokenModel instance = new RevokeTokenModel();

        public Builder token(String token) {
            instance.setToken(token);
            return this;
        }

        public RevokeTokenModel build() {
            RevokeTokenModel revokeTokenModel = new RevokeTokenModel();
            revokeTokenModel.setToken(instance.getToken());
            return revokeTokenModel;
        }

    }

    public static Builder builder() {
        return new Builder();
    }
}
