package build.dream.common.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class JdkDynamicProxy implements InvocationHandler {
    private Object object;

    public JdkDynamicProxy(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object result = null;
        try {
            result = method.invoke(object, args);
        } catch (Throwable throwable) {
            System.out.println("ex:" + throwable.getClass().getName());
            throw throwable;
        } finally {
            System.out.println("after");
        }
        return result;
    }
}
