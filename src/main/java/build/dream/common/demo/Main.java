package build.dream.common.demo;

import build.dream.common.utils.DynamicProxyUtils;

import java.io.InputStream;
import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        Subject subject = (Subject) Proxy.newProxyInstance(Main.class.getClassLoader(), new Class[]{Subject.class}, new JdkDynamicProxy(new RealSubject()));
        subject.alert();

        System.out.println("================");

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

        ClassLoader classLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream inputStream = getClass().getResourceAsStream(fileName);
                    if (inputStream == null) {
                        return super.loadClass(name);
                    }
                    byte[] bytes = new byte[inputStream.available()];
                    inputStream.read(bytes);
                    return defineClass(name, bytes, 0, bytes.length);
                } catch (Exception e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };

        Object object = classLoader.loadClass("build.dream.common.demo.Main");
        System.out.println(object);
    }
}
