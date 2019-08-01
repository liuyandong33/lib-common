package build.dream.common.models.mqtt;

import build.dream.common.models.BasicModel;

import javax.validation.constraints.NotNull;

public class QueryTokenModel extends BasicModel {
    @NotNull
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public static class Builder {
        private final QueryTokenModel instance = new QueryTokenModel();

        public Builder token(String token) {
            instance.setToken(token);
            return this;
        }

        public QueryTokenModel build() {
            QueryTokenModel queryTokenModel = new QueryTokenModel();
            queryTokenModel.setToken(instance.getToken());
            return queryTokenModel;
        }

    }

    public static Builder builder() {
        return new Builder();
    }
}
