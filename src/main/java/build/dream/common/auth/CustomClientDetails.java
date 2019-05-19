package build.dream.common.auth;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

import java.util.*;

public class CustomClientDetails implements ClientDetails {
    private String clientId;
    private String clientSecret;
    private Set<String> scope = Collections.emptySet();
    private Set<String> resourceIds = Collections.emptySet();
    private Set<String> authorizedGrantTypes = Collections.emptySet();
    private Set<String> registeredRedirectUris;
    private Set<String> autoApproveScopes;
    private List<GrantedAuthority> authorities = Collections.emptyList();
    private Integer accessTokenValiditySeconds;
    private Integer refreshTokenValiditySeconds;
    private Map<String, Object> additionalInformation = new LinkedHashMap<String, Object>();

    @Override
    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    @Override
    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    @Override
    public Set<String> getScope() {
        return scope;
    }

    public void setScope(Set<String> scope) {
        this.scope = scope;
    }

    @Override
    public Set<String> getResourceIds() {
        return resourceIds;
    }

    public void setResourceIds(Set<String> resourceIds) {
        this.resourceIds = resourceIds;
    }

    @Override
    public Set<String> getAuthorizedGrantTypes() {
        return authorizedGrantTypes;
    }

    public void setAuthorizedGrantTypes(Set<String> authorizedGrantTypes) {
        this.authorizedGrantTypes = authorizedGrantTypes;
    }

    public Set<String> getRegisteredRedirectUris() {
        return registeredRedirectUris;
    }

    public void setRegisteredRedirectUris(Set<String> registeredRedirectUris) {
        this.registeredRedirectUris = registeredRedirectUris;
    }

    public Set<String> getAutoApproveScopes() {
        return autoApproveScopes;
    }

    public void setAutoApproveScopes(Set<String> autoApproveScopes) {
        this.autoApproveScopes = autoApproveScopes;
    }

    @Override
    public List<GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public Integer getAccessTokenValiditySeconds() {
        return accessTokenValiditySeconds;
    }

    public void setAccessTokenValiditySeconds(Integer accessTokenValiditySeconds) {
        this.accessTokenValiditySeconds = accessTokenValiditySeconds;
    }

    @Override
    public Integer getRefreshTokenValiditySeconds() {
        return refreshTokenValiditySeconds;
    }

    public void setRefreshTokenValiditySeconds(Integer refreshTokenValiditySeconds) {
        this.refreshTokenValiditySeconds = refreshTokenValiditySeconds;
    }

    @Override
    public Map<String, Object> getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(Map<String, Object> additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    @Override
    public boolean isAutoApprove(String scope) {
        if (CollectionUtils.isEmpty(autoApproveScopes)) {
            return false;
        }
        return autoApproveScopes.contains(scope);
    }

    @Override
    public boolean isSecretRequired() {
        return StringUtils.isNoneBlank(clientSecret);
    }

    @Override
    public boolean isScoped() {
        return CollectionUtils.isNotEmpty(scope);
    }

    @Override
    public Set<String> getRegisteredRedirectUri() {
        return registeredRedirectUris;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((accessTokenValiditySeconds == null) ? 0 : accessTokenValiditySeconds);
        result = prime * result + ((refreshTokenValiditySeconds == null) ? 0 : refreshTokenValiditySeconds);
        result = prime * result + ((authorities == null) ? 0 : authorities.hashCode());
        result = prime * result + ((authorizedGrantTypes == null) ? 0 : authorizedGrantTypes.hashCode());
        result = prime * result + ((clientId == null) ? 0 : clientId.hashCode());
        result = prime * result + ((clientSecret == null) ? 0 : clientSecret.hashCode());
        result = prime * result + ((registeredRedirectUris == null) ? 0 : registeredRedirectUris.hashCode());
        result = prime * result + ((resourceIds == null) ? 0 : resourceIds.hashCode());
        result = prime * result + ((scope == null) ? 0 : scope.hashCode());
        result = prime * result + ((additionalInformation == null) ? 0 : additionalInformation.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        CustomClientDetails other = (CustomClientDetails) obj;
        if (accessTokenValiditySeconds == null) {
            if (other.accessTokenValiditySeconds != null) {
                return false;
            }
        } else if (!accessTokenValiditySeconds.equals(other.accessTokenValiditySeconds)) {
            return false;
        }
        if (refreshTokenValiditySeconds == null) {
            if (other.refreshTokenValiditySeconds != null) {
                return false;
            }
        } else if (!refreshTokenValiditySeconds.equals(other.refreshTokenValiditySeconds)) {
            return false;
        }
        if (authorities == null) {
            if (other.authorities != null) {
                return false;
            }
        } else if (!authorities.equals(other.authorities)) {
            return false;
        }
        if (authorizedGrantTypes == null) {
            if (other.authorizedGrantTypes != null) {
                return false;
            }
        } else if (!authorizedGrantTypes.equals(other.authorizedGrantTypes)) {
            return false;
        }
        if (clientId == null) {
            if (other.clientId != null) {
                return false;
            }
        } else if (!clientId.equals(other.clientId)) {
            return false;
        }
        if (clientSecret == null) {
            if (other.clientSecret != null) {
                return false;
            }
        } else if (!clientSecret.equals(other.clientSecret)) {
            return false;
        }
        if (registeredRedirectUris == null) {
            if (other.registeredRedirectUris != null) {
                return false;
            }
        } else if (!registeredRedirectUris.equals(other.registeredRedirectUris)) {
            return false;
        }
        if (resourceIds == null) {
            if (other.resourceIds != null) {
                return false;
            }
        } else if (!resourceIds.equals(other.resourceIds)) {
            return false;
        }
        if (scope == null) {
            if (other.scope != null) {
                return false;
            }
        } else if (!scope.equals(other.scope)) {
            return false;
        }
        if (additionalInformation == null) {
            if (other.additionalInformation != null) {
                return false;
            }
        } else if (!additionalInformation.equals(other.additionalInformation)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BaseClientDetails [clientId=" + clientId + ", clientSecret="
                + clientSecret + ", scope=" + scope + ", resourceIds="
                + resourceIds + ", authorizedGrantTypes="
                + authorizedGrantTypes + ", registeredRedirectUris="
                + registeredRedirectUris + ", authorities=" + authorities
                + ", accessTokenValiditySeconds=" + accessTokenValiditySeconds
                + ", refreshTokenValiditySeconds="
                + refreshTokenValiditySeconds + ", additionalInformation="
                + additionalInformation + "]";
    }
}
