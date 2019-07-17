package build.dream.common.utils;

import build.dream.common.beans.WebResponse;
import build.dream.common.constants.Constants;
import build.dream.common.models.aliyunpls.*;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;

import java.util.*;

public class AliyunPlsUtils {
    /**
     * 构造公共请求参数
     *
     * @param action：API 的名称
     * @return
     */
    public static Map<String, String> buildCommonRequestParameters(String action) {
        Map<String, String> commonRequestParameters = new HashMap<String, String>();
        commonRequestParameters.put("AccessKeyId", AliyunUtils.ACCESS_KEY_ID);
        commonRequestParameters.put("Action", action);
        commonRequestParameters.put("Format", Constants.LOWER_CASE_JSON);
        commonRequestParameters.put("RegionId", "cn-hangzhou");
        commonRequestParameters.put("SignatureMethod", Constants.HMAC_SHA1);
        commonRequestParameters.put("SignatureNonce", UUID.randomUUID().toString());
        commonRequestParameters.put("SignatureVersion", "1.0");
        commonRequestParameters.put("Timestamp", CustomDateUtils.buildISO8601SimpleDateFormat().format(new Date()));
        commonRequestParameters.put("Version", "2017-05-25");
        return commonRequestParameters;
    }

    /**
     * 调用阿里云隐私号保护api
     *
     * @param requestParameters
     * @return
     */
    public static Map<String, Object> callAliyunPlsApi(Map<String, String> requestParameters) {
        WebResponse webResponse = OutUtils.doPostWithRequestParameters(AliyunUtils.DY_PLS_API_URL, requestParameters);

        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(webResponse.getResult(), String.class, Object.class);
        String code = MapUtils.getString(resultMap, "Code");
        ValidateUtils.isTrue(Constants.OK.equals(code), MapUtils.getString(resultMap, "Message"));
        return resultMap;
    }

    /**
     * 添加AXB号码的绑定关系
     *
     * @param bindAxbModel
     * @return
     */
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

        Map<String, String> requestParameters = new HashMap<String, String>(buildCommonRequestParameters("BindAxb"));
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
        return callAliyunPlsApi(requestParameters);
    }

    /**
     * 添加AXN号码的绑定关系
     *
     * @param bindAxnModel
     * @return
     */
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

        Map<String, String> requestParameters = new HashMap<String, String>(buildCommonRequestParameters("BindAxn"));
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
        return callAliyunPlsApi(requestParameters);
    }

    /**
     * 添加AXN分机号码的绑定关系
     *
     * @param bindAxnExtensionModel
     * @return
     */
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

        Map<String, String> requestParameters = new HashMap<String, String>(buildCommonRequestParameters("BindAxnExtension"));
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
        return callAliyunPlsApi(requestParameters);
    }

    /**
     * 解除号码的绑定关系
     *
     * @param unbindSubscriptionModel
     * @return
     */
    public static Map<String, Object> unbindSubscription(UnbindSubscriptionModel unbindSubscriptionModel) {
        unbindSubscriptionModel.validateAndThrow();

        String poolKey = unbindSubscriptionModel.getPoolKey();
        String secretNo = unbindSubscriptionModel.getSecretNo();
        String subsId = unbindSubscriptionModel.getSubsId();
        String productType = unbindSubscriptionModel.getProductType();

        Map<String, String> requestParameters = new HashMap<String, String>(buildCommonRequestParameters("UnbindSubscription"));
        requestParameters.put("PoolKey", poolKey);
        requestParameters.put("SecretNo", secretNo);
        requestParameters.put("SubsId", subsId);

        if (StringUtils.isNotBlank(productType)) {
            requestParameters.put("ProductType", productType);
        }

        requestParameters.put("Signature", AliyunUtils.generateSignature(requestParameters, AliyunUtils.ACCESS_KEY_SECRET));
        return callAliyunPlsApi(requestParameters);
    }

    /**
     * 修改绑定关系
     *
     * @param updateSubscriptionModel
     * @return
     */
    public static Map<String, Object> updateSubscription(UpdateSubscriptionModel updateSubscriptionModel) {
        updateSubscriptionModel.validateAndThrow();

        String operateType = updateSubscriptionModel.getOperateType();
        String phoneNoX = updateSubscriptionModel.getPhoneNoX();
        String poolKey = updateSubscriptionModel.getPoolKey();
        String subsId = updateSubscriptionModel.getSubsId();
        String callRestrict = updateSubscriptionModel.getCallRestrict();
        String expiration = updateSubscriptionModel.getExpiration();
        String groupId = updateSubscriptionModel.getGroupId();
        String phoneNoA = updateSubscriptionModel.getPhoneNoA();
        String phoneNoB = updateSubscriptionModel.getPhoneNoB();
        String productType = updateSubscriptionModel.getProductType();

        Map<String, String> requestParameters = new HashMap<String, String>(buildCommonRequestParameters("UpdateSubscription"));
        requestParameters.put("OperateType", operateType);
        requestParameters.put("PhoneNoX", phoneNoX);
        requestParameters.put("PoolKey", poolKey);
        requestParameters.put("SubsId", subsId);

        if (StringUtils.isNotBlank(callRestrict)) {
            requestParameters.put("CallRestrict", callRestrict);
        }

        if (StringUtils.isNotBlank(expiration)) {
            requestParameters.put("Expiration", expiration);
        }

        if (StringUtils.isNotBlank(groupId)) {
            requestParameters.put("GroupId", groupId);
        }

        if (StringUtils.isNotBlank(phoneNoA)) {
            requestParameters.put("PhoneNoA", phoneNoA);
        }

        if (StringUtils.isNotBlank(phoneNoB)) {
            requestParameters.put("PhoneNoB", phoneNoB);
        }

        if (StringUtils.isNotBlank(productType)) {
            requestParameters.put("ProductType", productType);
        }

        requestParameters.put("Signature", AliyunUtils.generateSignature(requestParameters, AliyunUtils.ACCESS_KEY_SECRET));
        return callAliyunPlsApi(requestParameters);
    }
}
