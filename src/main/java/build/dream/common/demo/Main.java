package build.dream.common.demo;

import build.dream.common.erp.catering.domains.Branch;
import build.dream.common.utils.DynamicProxyUtils;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
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

        Class<?> domainClass = Branch.class;
        StringBuilder stringBuilder = new StringBuilder("public static class Builder {private final Branch instance = new Branch();");

        String simpleName = domainClass.getSimpleName();

        StringBuilder callString = new StringBuilder(simpleName);
        callString.append(" ");
        callString.append(simpleName.substring(0, 1).toLowerCase());
        callString.append(simpleName.substring(1, simpleName.length()));
        callString.append(" = ");
        callString.append(simpleName);
        callString.append(".builder()");
        while (domainClass != Object.class) {
            Field[] fields = domainClass.getDeclaredFields();
            for (Field field : fields) {
                int modifiers = field.getModifiers();
                if (Modifier.isStatic(modifiers) || Modifier.isFinal(modifiers) || Modifier.isNative(modifiers)) {
                    continue;
                }

                String fieldName = field.getName();
                stringBuilder.append("public Builder ");
                stringBuilder.append(fieldName);
                stringBuilder.append("(");
                stringBuilder.append(field.getType().getSimpleName());
                stringBuilder.append(" ");
                stringBuilder.append(fieldName);
                stringBuilder.append(") {instance.set");
                stringBuilder.append(fieldName.substring(0, 1).toUpperCase());
                stringBuilder.append(fieldName.substring(1, fieldName.length()));
                stringBuilder.append("(");
                stringBuilder.append(fieldName);
                stringBuilder.append(");return this;}");

                callString.append(".");
                callString.append(fieldName);
                callString.append("(null)");
            }
            domainClass = domainClass.getSuperclass();
        }
        stringBuilder.append("public ");
        stringBuilder.append(simpleName);
        stringBuilder.append(" build() {return instance;}}");
        callString.append(".build();");

        System.out.println(stringBuilder.toString());
        System.out.println(callString.toString());

        Branch branch = Branch.builder()
                .tenantId(null)
                .tenantCode(null)
                .code(null)
                .name(null)
                .type(null)
                .status(null)
                .provinceCode(null)
                .provinceName(null)
                .cityCode(null)
                .cityName(null)
                .districtCode(null)
                .districtName(null)
                .address(null)
                .longitude(null)
                .latitude(null)
                .linkman(null)
                .contactPhone(null)
                .elemeAccountType(null)
                .shopId(null)
                .smartRestaurantStatus(null)
                .appAuthToken(null)
                .poiId(null)
                .poiName(null)
                .id(null)
                .createTime(null)
                .createUserId(null)
                .lastUpdateTime(null)
                .lastUpdateUserId(null)
                .lastUpdateRemark(null)
                .deleted(false)
                .build();
    }
}
