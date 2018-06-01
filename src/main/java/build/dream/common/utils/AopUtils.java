package build.dream.common.utils;

public class AopUtils {
    public static <T> T buildProxyObject(Class<T> clazz, Interceptor interceptor) {
        Proxy<T> proxy = new Proxy<T>(clazz, interceptor);
        return proxy.getObject();
    }
}
