package build.dream.common.listeners;

import build.dream.common.constants.Constants;
import build.dream.common.utils.CacheUtils;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class BasicHttpSessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        HttpSession httpSession = httpSessionEvent.getSession();
        String sessionId = httpSession.getId();
        CacheUtils.delete(Constants.SESSION_ID_PREFIX + sessionId);
    }
}
