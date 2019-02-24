package build.dream.common.utils;

import build.dream.common.auth.CustomUserDetails;
import build.dream.common.auth.VipUserDetails;
import build.dream.common.constants.Constants;
import org.springframework.expression.ExpressionParser;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.expression.ExpressionBasedFilterInvocationSecurityMetadataSource;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.LinkedHashMap;

public class WebSecurityUtils {
    public static void authorize(String loginName) {
        HttpServletRequest httpServletRequest = ApplicationHandler.getHttpServletRequest();
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(httpServletRequest.getServletContext());

        AuthenticationManager authenticationManager = webApplicationContext.getBean(AuthenticationManager.class);
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(loginName, Constants.SECURITY_DEFAULT_PASSWORD);
        usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetails(httpServletRequest));
        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    public static LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>> processMap(LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>> requestMap, ExpressionParser expressionParser) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<ExpressionBasedFilterInvocationSecurityMetadataSource> expressionBasedFilterInvocationSecurityMetadataSourceClass = ExpressionBasedFilterInvocationSecurityMetadataSource.class;
        Method expressionBasedFilterInvocationSecurityMetadataSourceClassProcessMapMethod = expressionBasedFilterInvocationSecurityMetadataSourceClass.getDeclaredMethod("processMap", LinkedHashMap.class, ExpressionParser.class);
        expressionBasedFilterInvocationSecurityMetadataSourceClassProcessMapMethod.setAccessible(true);
        return (LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>>) expressionBasedFilterInvocationSecurityMetadataSourceClassProcessMapMethod.invoke(null, requestMap, expressionParser);
    }

    public static CustomUserDetails obtainCustomUserDetails() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
        return customUserDetails;
    }

    public static VipUserDetails obtainVipUserDetails() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        VipUserDetails vipUserDetails = (VipUserDetails) authentication.getPrincipal();
        return vipUserDetails;
    }
}
