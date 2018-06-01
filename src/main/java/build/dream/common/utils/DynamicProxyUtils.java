package build.dream.common.utils;

public class DynamicProxyUtils {
    public static <T> T buildProxyObject(Class<T> clazz, Interceptor interceptor) {
        Proxy<T> proxy = new Proxy<T>(clazz, interceptor);
        return proxy.getObject();
    }
}
