package build.dream.common.utils;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class Proxy<T> implements MethodInterceptor {
    private Enhancer enhancer = new Enhancer();
    private T object;
    private Interceptor interceptor;

    public Proxy(Class<T> clazz, Interceptor interceptor) {
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        this.object = (T) enhancer.create();
        this.interceptor = interceptor;
    }

    public T getObject() {
        return object;
    }

    @Override
    public Object intercept(Object object, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        return interceptor.intercept(object, method, objects, methodProxy);
    }
}
