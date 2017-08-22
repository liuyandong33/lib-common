package build.dream.common.interceptors;

import build.dream.common.Application;
import build.dream.common.annotations.ObtainWeChatOpenId;
import build.dream.common.api.ApiRest;
import build.dream.common.utils.ApplicationHandler;
import build.dream.common.utils.GsonUtils;
import build.dream.common.utils.PropertyUtils;
import build.dream.common.utils.WeChatUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HandlerInterceptor implements org.springframework.web.servlet.HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String sessionId = ApplicationHandler.getSessionId();
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        ObtainWeChatOpenId obtainWeChatOpenId = handlerMethod.getMethodAnnotation(ObtainWeChatOpenId.class);
        if (obtainWeChatOpenId != null) {
            String openId = "";
            if (StringUtils.isNotBlank(openId)) {
                return true;
            } else {
                Map<String, String> requestParameters = ApplicationHandler.getRequestParameters();
                String isAuthorizationCallback = requestParameters.get("isAuthorizationCallback");

                String appid = "wx7f39242a4fd5bf0a";
                if (StringUtils.isNotBlank(isAuthorizationCallback)) {
                    String secret = "dc3ba603115c02c8704cdeebb616bbfa";
                    String code = requestParameters.get("code");
                    ApiRest apiRest = WeChatUtils.oAuthAccessToken(appid, secret, code);
                    Validate.isTrue(apiRest.isSuccessful(), apiRest.getError());
                    Map<String, String> data = (Map<String, String>) apiRest.getData();
                    System.out.println(GsonUtils.toJson(data));
                    return true;
                } else {
                    requestParameters.put("isAuthorizationCallback", "true");
                    List<String> requestParameterPairs = new ArrayList<String>();
                    for (Map.Entry<String, String> entry : requestParameters.entrySet()) {
                        requestParameterPairs.add(entry.getKey() + "=" + entry.getValue());
                    }
                    String redirectUrl = ApplicationHandler.getRequestUrl();
                    if (CollectionUtils.isNotEmpty(requestParameterPairs)) {
                        redirectUrl = redirectUrl + "?" + StringUtils.join(requestParameterPairs, "&");
                    }
                    response.sendRedirect(WeChatUtils.generateAuthorizeUrl(appid, null, redirectUrl, null));
                    return false;
                }
            }
        } else {
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
