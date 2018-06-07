package build.dream.common.utils;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

public class DynamicProxyUtils {
    public static <T> T buildProxyObject(Class<T> clazz, MethodInterceptor methodInterceptor) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(methodInterceptor);
        return (T) enhancer.create();
    }
}
