package build.dream.common.utils;

import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public interface Interceptor {
    Object intercept(Object object, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable;
}
