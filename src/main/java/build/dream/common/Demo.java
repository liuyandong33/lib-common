package build.dream.common;

import build.dream.common.utils.WebUtils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Demo {
    private boolean deleted;

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public static void main(String[] args) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        BeanInfo beanInfo = Introspector.getBeanInfo(Demo.class);
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();

        Demo demo = new Demo();
        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
            Method writeMethod = propertyDescriptor.getWriteMethod();
            if (writeMethod == null) {
                continue;
            }
            writeMethod.invoke(demo, true);
        }
    }

    public static String callTouTiaoSystem(String userId, String maxBehotTime, String signature) throws IOException {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.139 Safari/537.36");

        Map<String, String> requestParameters = new HashMap<String, String>();
        requestParameters.put("page_type", "1");
        requestParameters.put("user_id", userId);
        requestParameters.put("max_behot_time", maxBehotTime);
        requestParameters.put("count", "20");
        requestParameters.put("tadrequire", "true");
        requestParameters.put("as", "A165BADF912673F");
        requestParameters.put("cp", "5AF1F667538FEE1");
        requestParameters.put("_signature", signature);
        String result = WebUtils.doGetWithRequestParameters("https://www.toutiao.com/c/user/article/", headers, requestParameters);
        return result;
    }
}
