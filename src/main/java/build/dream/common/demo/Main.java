package build.dream.common.demo;

import build.dream.common.utils.DynamicProxyUtils;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        /*System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        Subject subject = (Subject) Proxy.newProxyInstance(Main.class.getClassLoader(), new Class[]{Subject.class}, new JdkDynamicProxy(new RealSubject()));
        subject.alert();

        System.out.println("================");*/

        RealSubject realSubject = DynamicProxyUtils.buildProxyObject(RealSubject.class, (object, method, objects, methodProxy) -> {
            System.out.println("before");
            Object result = null;
            try {
                result = methodProxy.invokeSuper(object, objects);
            } catch (Throwable throwable) {
                System.out.println(throwable.getClass().getName());
            } finally {
                System.out.println("after");
            }
            return result;
        });

        realSubject.alert();
    }
}
