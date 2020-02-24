package build.dream.common.utils;

import build.dream.common.models.cuba.FindMdmCustomerModel;
import build.dream.common.models.cuba.GetCustomerFormMdmModel;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;

import java.util.*;

public class CubaUtils {
    public static String generateCipherText(Map<String, String> params, String key) {
        Map<String, String> sortedMap = new TreeMap<String, String>(params);

        List<String> pairs = new ArrayList<String>();
        for (Map.Entry<String, String> entry : sortedMap.entrySet()) {
            pairs.add(entry.getKey() + "=" + entry.getValue());
        }
        pairs.add("key=" + key);
        String str = StringUtils.join(pairs, "&");

        char[] charArray = str.toCharArray();
        byte[] bytes = new byte[charArray.length];

        for (int index = 0; index < charArray.length; index++) {
            bytes[index] = (byte) charArray[index];
        }

        return DigestUtils.md5Hex(bytes);
    }

    public static Map<String, Object> getCustomerFormMdm(GetCustomerFormMdmModel getCustomerFormMdmModel) {
        return null;
    }

    public static Map<String, Object> findMdmCustomer(FindMdmCustomerModel findMdmCustomerModel) {
        String customerCode = findMdmCustomerModel.getCustomerCode();
        String customerName = findMdmCustomerModel.getCustomerName();
        String taxCode = findMdmCustomerModel.getTaxCode();
        String key = findMdmCustomerModel.getKey();

        Map<String, String> signedMap = new HashMap<String, String>();
        signedMap.put("customerCode", customerCode);
        signedMap.put("customerName", customerName);
        signedMap.put("taxCode", taxCode);

        Map<String, String> requestParameters = new HashMap<String, String>();
        if (StringUtils.isNotBlank(customerCode)) {
            requestParameters.put("customerCode", customerCode);
        }

        if (StringUtils.isNotBlank(customerName)) {
            requestParameters.put("customerName", customerName);
        }

        requestParameters.put("taxCode", taxCode);
        requestParameters.put("cipherText", generateCipherText(signedMap, key));
        String result = OutUtils.doPostWithForm("https://cuba.cosmoplat.com/cuba/service/plat/mdm/gateway/findMdmCustomer", requestParameters);
        return JacksonUtils.readValueAsMap(result, String.class, Object.class);
    }
}
