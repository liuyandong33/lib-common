package build.dream.common.utils;

import build.dream.common.saas.domains.Tenant;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.UUID;

public class DynamicProxyUtils {
    public static <T> T buildProxyObject(Class<T> clazz, Interceptor interceptor) {
        Proxy<T> proxy = new Proxy<T>(clazz, interceptor);
        return proxy.getObject();
    }

    public static void main(String[] args) {
        Tenant tenant = DynamicProxyUtils.buildProxyObject(Tenant.class, new Interceptor() {
            @Override
            public Object intercept(Object object, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                return methodProxy.invokeSuper(object, objects);
            }
        });

        tenant.setBusiness(UUID.randomUUID().toString());
    }
}
