package build.dream.common.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

public class ObjectUtils {
    public static <T> T clone(Class<T> beanClass, Object originalBean) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        T t = beanClass.newInstance();
        BeanUtils.copyProperties(t, originalBean);
        return t;
    }
}
