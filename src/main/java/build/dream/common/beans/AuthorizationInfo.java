package build.dream.common.beans;

import java.util.List;
import java.util.Map;

public class AuthorizationInfo {
    private String authorizerAppId;
    private String authorizerAccessToken;
    private Integer expiresIn;
    private String authorizerRefreshToken;
    private List<Map<String, FuncScopeCategory>> funcInfo;

    public String getAuthorizerAppId() {
        return authorizerAppId;
    }

    public void setAuthorizerAppId(String authorizerAppId) {
        this.authorizerAppId = authorizerAppId;
    }

    public String getAuthorizerAccessToken() {
        return authorizerAccessToken;
    }

    public void setAuthorizerAccessToken(String authorizerAccessToken) {
        this.authorizerAccessToken = authorizerAccessToken;
    }

    public Integer getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getAuthorizerRefreshToken() {
        return authorizerRefreshToken;
    }

    public void setAuthorizerRefreshToken(String authorizerRefreshToken) {
        this.authorizerRefreshToken = authorizerRefreshToken;
    }

    public List<Map<String, FuncScopeCategory>> getFuncInfo() {
        return funcInfo;
    }

    public void setFuncInfo(List<Map<String, FuncScopeCategory>> funcInfo) {
        this.funcInfo = funcInfo;
    }

    public static class FuncScopeCategory {
        private Integer id;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }
    }
}
