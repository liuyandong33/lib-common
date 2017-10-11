package build.dream.common.utils;

import build.dream.common.constants.Constants;
import net.sf.json.JSONArray;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

public class WebSecurityUtils {
    public static void authorize(String loginName, String sessionId, Collection<String> authorities) {
        HttpServletRequest httpServletRequest = ApplicationHandler.getHttpServletRequest();
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(httpServletRequest.getServletContext());

        AuthenticationManager authenticationManager = webApplicationContext.getBean(AuthenticationManager.class);
        RequestContextHolder.currentRequestAttributes().setAttribute(Constants.SECURITY_GRANTED_AUTHORITY, JSONArray.fromObject(authorities).toString(), RequestAttributes.SCOPE_SESSION);
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(loginName, Constants.SECURITY_DEFAULT_PASSWORD);
        usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetails(httpServletRequest));
        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        try {
            SessionRegistry sessionRegistry = webApplicationContext.getBean(SessionRegistry.class);
            sessionRegistry.registerNewSession(sessionId, authentication.getPrincipal());
        } catch (Exception e) {}
    }
}
