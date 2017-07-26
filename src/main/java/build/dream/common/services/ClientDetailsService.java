package build.dream.common.services;

import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

@Service
public class ClientDetailsService implements org.springframework.security.oauth2.provider.ClientDetailsService {
    public static final String RESOURCE_ID = "SERVICE-ROUTER";
    public static final String RESOURCE_IDS = "SERVICE-ROUTER,POS-SERVICE";
    private static final String SCOPES = "USER";
    private static final String GRANT_TYPES = "client_credentials";
    public static final int ACCESS_TOKEN_VALIDITY_SECONDS = 1800;

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        int a = 100;
        return null;
    }
}
