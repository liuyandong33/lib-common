package build.dream.common.utils;

import build.dream.common.beans.WebResponse;
import build.dream.common.constants.Constants;
import build.dream.common.models.aliyunpls.BindAxbModel;
import build.dream.common.models.aliyunpls.BindAxnExtensionModel;
import build.dream.common.models.aliyunpls.BindAxnModel;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;

import java.util.*;

public class AliyunPlsUtils {
    public static Map<String, Object> bindAxb(BindAxbModel bindAxbModel) {
        bindAxbModel.validateAndThrow();

        String expiration = bindAxbModel.getExpiration();
        String phoneNoA = bindAxbModel.getPhoneNoA();
        String phoneNoB = bindAxbModel.getPhoneNoB();
        String poolKey = bindAxbModel.getPoolKey();
        String expectCity = bindAxbModel.getExpectCity();
        Boolean isRecordingEnabled = bindAxbModel.getIsRecordingEnabled();
        String outId = bindAxbModel.getOutId();
        String outOrderId = bindAxbModel.getOutOrderId();
        String phoneNoX = bindAxbModel.getPhoneNoX();

        Map<String, String> requestParameters = new HashMap<String, String>();
        requestParameters.put("AccessKeyId", AliyunUtils.ACCESS_KEY_ID);
        requestParameters.put("Action", "BindAxb");
        requestParameters.put("Format", Constants.LOWER_CASE_JSON);
        requestParameters.put("RegionId", "cn-hangzhou");
        requestParameters.put("SignatureMethod", Constants.HMAC_SHA1);
        requestParameters.put("SignatureNonce", UUID.randomUUID().toString());
        requestParameters.put("SignatureVersion", "1.0");
        requestParameters.put("Timestamp", CustomDateUtils.buildISO8601SimpleDateFormat().format(new Date()));
        requestParameters.put("Version", "2017-05-25");
        requestParameters.put("Expiration", expiration);
        requestParameters.put("PhoneNoA", phoneNoA);
        requestParameters.put("PhoneNoB", phoneNoB);
        requestParameters.put("PoolKey", poolKey);

        ApplicationHandler.ifNotBlankPut(requestParameters, "ExpectCity", expectCity);

        if (Objects.nonNull(isRecordingEnabled)) {
            requestParameters.put("isRecordingEnabled", isRecordingEnabled.toString());
        }

        if (StringUtils.isNotBlank(outId)) {
            requestParameters.put("OutId", outId);
        }

        if (StringUtils.isNotBlank(outOrderId)) {
            requestParameters.put("OutOrderId", outOrderId);
        }

        if (StringUtils.isNotBlank(phoneNoX)) {
            requestParameters.put("PhoneNoX", phoneNoX);
        }

        requestParameters.put("Signature", AliyunUtils.generateSignature(requestParameters, AliyunUtils.ACCESS_KEY_SECRET));

        WebResponse webResponse = OutUtils.doPostWithRequestParameters(AliyunUtils.DY_PLS_API_URL, requestParameters);

        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(webResponse.getResult(), String.class, Object.class);
        String code = MapUtils.getString(resultMap, "Code");
        ValidateUtils.isTrue(Constants.OK.equals(code), MapUtils.getString(resultMap, "Message"));
        return resultMap;
    }

    public static Map<String, Object> bindAxn(BindAxnModel bindAxnModel) {
        bindAxnModel.validateAndThrow();

        String expiration = bindAxnModel.getExpiration();
        String phoneNoA = bindAxnModel.getPhoneNoA();
        String poolKey = bindAxnModel.getPoolKey();
        String expectCity = bindAxnModel.getExpectCity();
        Boolean isRecordingEnabled = bindAxnModel.getIsRecordingEnabled();
        String noType = bindAxnModel.getNoType();
        String outId = bindAxnModel.getOutId();
        String outOrderId = bindAxnModel.getOutOrderId();
        String phoneNoB = bindAxnModel.getPhoneNoB();
        String phoneNoX = bindAxnModel.getPhoneNoX();

        Map<String, String> requestParameters = new HashMap<String, String>();
        requestParameters.put("AccessKeyId", AliyunUtils.ACCESS_KEY_ID);
        requestParameters.put("Action", "BindAxn");
        requestParameters.put("Format", Constants.LOWER_CASE_JSON);
        requestParameters.put("RegionId", "cn-hangzhou");
        requestParameters.put("SignatureMethod", Constants.HMAC_SHA1);
        requestParameters.put("SignatureNonce", UUID.randomUUID().toString());
        requestParameters.put("SignatureVersion", "1.0");
        requestParameters.put("Timestamp", CustomDateUtils.buildISO8601SimpleDateFormat().format(new Date()));
        requestParameters.put("Version", "2017-05-25");
        requestParameters.put("Expiration", expiration);
        requestParameters.put("PhoneNoA", phoneNoA);
        requestParameters.put("PoolKey", poolKey);

        ApplicationHandler.ifNotBlankPut(requestParameters, "ExpectCity", expectCity);

        if (Objects.nonNull(isRecordingEnabled)) {
            requestParameters.put("isRecordingEnabled", isRecordingEnabled.toString());
        }

        if (StringUtils.isNotBlank(noType)) {
            requestParameters.put("NoType", noType);
        }

        if (StringUtils.isNotBlank(outId)) {
            requestParameters.put("OutId", outId);
        }

        if (StringUtils.isNotBlank(outOrderId)) {
            requestParameters.put("OutOrderId", outOrderId);
        }

        if (StringUtils.isNotBlank(phoneNoB)) {
            requestParameters.put("PhoneNoB", phoneNoB);
        }

        if (StringUtils.isNotBlank(phoneNoX)) {
            requestParameters.put("PhoneNoX", phoneNoX);
        }

        requestParameters.put("Signature", AliyunUtils.generateSignature(requestParameters, AliyunUtils.ACCESS_KEY_SECRET));

        WebResponse webResponse = OutUtils.doPostWithRequestParameters(AliyunUtils.DY_PLS_API_URL, requestParameters);

        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(webResponse.getResult(), String.class, Object.class);
        String code = MapUtils.getString(resultMap, "Code");
        ValidateUtils.isTrue(Constants.OK.equals(code), MapUtils.getString(resultMap, "Message"));
        return resultMap;
    }

    public static Map<String, Object> bindAxnExtension(BindAxnExtensionModel bindAxnExtensionModel) {
        bindAxnExtensionModel.validateAndThrow();

        String expiration = bindAxnExtensionModel.getExpiration();
        String phoneNoA = bindAxnExtensionModel.getPhoneNoA();
        String poolKey = bindAxnExtensionModel.getPoolKey();
        String expectCity = bindAxnExtensionModel.getExpectCity();
        String extension = bindAxnExtensionModel.getExtension();
        Boolean isRecordingEnabled = bindAxnExtensionModel.getIsRecordingEnabled();
        String outId = bindAxnExtensionModel.getOutId();
        String outOrderId = bindAxnExtensionModel.getOutOrderId();
        String phoneNoB = bindAxnExtensionModel.getPhoneNoB();
        String phoneNoX = bindAxnExtensionModel.getPhoneNoX();

        Map<String, String> requestParameters = new HashMap<String, String>();
        requestParameters.put("AccessKeyId", AliyunUtils.ACCESS_KEY_ID);
        requestParameters.put("Action", "BindAxnExtension");
        requestParameters.put("Format", Constants.LOWER_CASE_JSON);
        requestParameters.put("RegionId", "cn-hangzhou");
        requestParameters.put("SignatureMethod", Constants.HMAC_SHA1);
        requestParameters.put("SignatureNonce", UUID.randomUUID().toString());
        requestParameters.put("SignatureVersion", "1.0");
        requestParameters.put("Timestamp", CustomDateUtils.buildISO8601SimpleDateFormat().format(new Date()));
        requestParameters.put("Version", "2017-05-25");
        requestParameters.put("Expiration", expiration);
        requestParameters.put("PhoneNoA", phoneNoA);
        requestParameters.put("PoolKey", poolKey);

        ApplicationHandler.ifNotBlankPut(requestParameters, "ExpectCity", expectCity);
        ApplicationHandler.ifNotBlankPut(requestParameters, "Extension", extension);

        if (Objects.nonNull(isRecordingEnabled)) {
            requestParameters.put("isRecordingEnabled", isRecordingEnabled.toString());
        }

        if (StringUtils.isNotBlank(outId)) {
            requestParameters.put("OutId", outId);
        }

        if (StringUtils.isNotBlank(outOrderId)) {
            requestParameters.put("OutOrderId", outOrderId);
        }

        if (StringUtils.isNotBlank(phoneNoB)) {
            requestParameters.put("PhoneNoB", phoneNoB);
        }

        if (StringUtils.isNotBlank(phoneNoX)) {
            requestParameters.put("PhoneNoX", phoneNoX);
        }

        requestParameters.put("Signature", AliyunUtils.generateSignature(requestParameters, AliyunUtils.ACCESS_KEY_SECRET));

        WebResponse webResponse = OutUtils.doPostWithRequestParameters(AliyunUtils.DY_PLS_API_URL, requestParameters);

        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(webResponse.getResult(), String.class, Object.class);
        String code = MapUtils.getString(resultMap, "Code");
        ValidateUtils.isTrue(Constants.OK.equals(code), MapUtils.getString(resultMap, "Message"));
        return resultMap;
    }
}
