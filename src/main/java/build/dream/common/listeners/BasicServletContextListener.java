package build.dream.common.listeners;

import build.dream.common.utils.ApplicationHandler;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class BasicServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
        webApplicationContext.getAutowireCapableBeanFactory().autowireBean(this);
        ApplicationHandler.setApplicationContext(webApplicationContext);
        ApplicationHandler.setServletContext(servletContext);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

    public void previousInjectionBean(ServletContext servletContext, Class<?>... beanClasses) {
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
        for (Class<?> beanClass : beanClasses) {
            webApplicationContext.getBean(beanClass);
        }
    }
}
