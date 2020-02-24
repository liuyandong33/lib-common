package build.dream.common.utils;

import build.dream.common.constants.Constants;
import build.dream.common.models.notify.SaveAsyncNotifyModel;
import build.dream.common.domains.saas.AsyncNotify;
import org.apache.commons.lang.StringUtils;

import java.math.BigInteger;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class NotifyUtils {
    /**
     * 获取回调地址
     *
     * @param notifyType
     * @param uuidKey
     * @return
     */
    public static String obtainNotifyUrl(String notifyType, String uuidKey) {
        return CommonUtils.getOutsideUrl(Constants.SERVICE_NAME_GATEWAY, "notify", "callback") + "/" + notifyType + "/" + uuidKey;
    }

    /**
     * 保存异步通知
     *
     * @param saveAsyncNotifyModel
     * @return
     */
    public static AsyncNotify saveAsyncNotify(SaveAsyncNotifyModel saveAsyncNotifyModel) {
        String uuid = saveAsyncNotifyModel.getUuid();
        String topic = saveAsyncNotifyModel.getTopic();
        String alipayPublicKey = saveAsyncNotifyModel.getAlipayPublicKey();
        String alipaySignType = saveAsyncNotifyModel.getAlipaySignType();
        String weiXinPayApiKey = saveAsyncNotifyModel.getWeiXinPayApiKey();
        String weiXinPaySignType = saveAsyncNotifyModel.getWeiXinPaySignType();

        BigInteger userId = CommonUtils.getServiceSystemUserId();

        SearchModel searchModel = new SearchModel(true);
        searchModel.addSearchCondition(AsyncNotify.ColumnName.UUID, Constants.SQL_OPERATION_SYMBOL_EQUAL, uuid);
        AsyncNotify asyncNotify = DatabaseHelper.find(AsyncNotify.class, searchModel);
        if (Objects.isNull(asyncNotify)) {
            asyncNotify = new AsyncNotify();
            asyncNotify.setUuid(uuid);
            asyncNotify.setTopic(topic);
            if (StringUtils.isNotBlank(alipayPublicKey)) {
                asyncNotify.setAlipayPublicKey(alipayPublicKey);
            }
            if (StringUtils.isNotBlank(alipaySignType)) {
                asyncNotify.setAlipaySignType(alipaySignType);
            }
            asyncNotify.setNotifyResult(Constants.NOTIFY_RESULT_NOT_NOTIFY);
            if (StringUtils.isNotBlank(weiXinPayApiKey)) {
                asyncNotify.setWeiXinPayApiKey(weiXinPayApiKey);
            }
            if (StringUtils.isNotBlank(weiXinPaySignType)) {
                asyncNotify.setWeiXinPaySignType(weiXinPaySignType);
            }
            asyncNotify.setCreatedUserId(userId);
            asyncNotify.setUpdatedUserId(userId);
            asyncNotify.setUpdatedRemark("保存异步通知！");
            DatabaseHelper.insert(asyncNotify);
        } else {
            asyncNotify.setTopic(topic);
            asyncNotify.setAlipayPublicKey(StringUtils.isNotBlank(alipayPublicKey) ? alipayPublicKey : Constants.VARCHAR_DEFAULT_VALUE);
            asyncNotify.setAlipaySignType(StringUtils.isNotBlank(alipaySignType) ? alipaySignType : Constants.VARCHAR_DEFAULT_VALUE);
            asyncNotify.setWeiXinPayApiKey(StringUtils.isNotBlank(weiXinPayApiKey) ? weiXinPayApiKey : Constants.VARCHAR_DEFAULT_VALUE);
            asyncNotify.setWeiXinPaySignType(StringUtils.isNotBlank(weiXinPaySignType) ? weiXinPaySignType : Constants.VARCHAR_DEFAULT_VALUE);
            asyncNotify.setUpdatedUserId(userId);
            asyncNotify.setUpdatedRemark("修改异步通知！");
            DatabaseHelper.update(asyncNotify);
        }

        return asyncNotify;
    }

    /**
     * 保存微信支付异步通知
     *
     * @param uuid
     * @param topic
     * @param apiKey
     * @param signType
     * @return
     */
    public static AsyncNotify saveWeiXinPayAsyncNotify(String uuid, String topic, String apiKey, String signType) {
        AsyncNotify asyncNotify = AsyncNotify.builder()
                .uuid(uuid)
                .topic(topic)
                .weiXinPayApiKey(apiKey)
                .weiXinPaySignType(signType)
                .build();
        CommonRedisUtils.setex(uuid, JacksonUtils.writeValueAsString(asyncNotify), 1, TimeUnit.DAYS);
        return asyncNotify;
    }

    /**
     * 保存微信退款异步通知
     *
     * @param uuid
     * @param topic
     * @param apiKey
     * @param signType
     * @return
     */
    public static AsyncNotify saveWeiXinRefundAsyncNotify(String uuid, String topic, String apiKey, String signType) {
        AsyncNotify asyncNotify = AsyncNotify.builder()
                .uuid(uuid)
                .topic(topic)
                .weiXinPayApiKey(apiKey)
                .weiXinPaySignType(signType)
                .build();
        CommonRedisUtils.setex(uuid, JacksonUtils.writeValueAsString(asyncNotify), 1, TimeUnit.DAYS);
        return asyncNotify;
    }

    /**
     * 保存支付宝异步通知
     *
     * @param uuid
     * @param topic
     * @param alipayPublicKey
     * @param signType
     * @return
     */
    private static AsyncNotify saveAlipayAsyncNotify(String uuid, String topic, String alipayPublicKey, String signType) {
        AsyncNotify asyncNotify = AsyncNotify.builder()
                .uuid(uuid)
                .topic(topic)
                .alipayPublicKey(alipayPublicKey)
                .alipaySignType(signType)
                .build();
        CommonRedisUtils.setex(uuid, JacksonUtils.writeValueAsString(asyncNotify), 1, TimeUnit.DAYS);
        return asyncNotify;
    }

    /**
     * 保存米雅支付异步通知
     *
     * @param uuid
     * @param topic
     * @param miyaKey
     * @return
     */
    public static AsyncNotify saveMiyaAsyncNotify(String uuid, String topic, String miyaKey) {
        AsyncNotify asyncNotify = AsyncNotify.builder()
                .uuid(uuid)
                .topic(topic)
                .miyaKey(miyaKey)
                .build();
        CommonRedisUtils.setex(uuid, JacksonUtils.writeValueAsString(asyncNotify), 1, TimeUnit.DAYS);
        return asyncNotify;
    }

    /**
     * 保存联动支付异步通知
     *
     * @param uuid
     * @param topic
     * @param umPayPrivateKey
     * @param umPayPlatformCertificate
     * @return
     */
    public static AsyncNotify saveUmPayAsyncNotify(String uuid, String topic, String umPayPrivateKey, String umPayPlatformCertificate) {
        AsyncNotify asyncNotify = AsyncNotify.builder()
                .uuid(uuid)
                .topic(topic)
                .umPayPrivateKey(umPayPrivateKey)
                .umPayPlatformCertificate(umPayPlatformCertificate)
                .build();
        CommonRedisUtils.setex(uuid, JacksonUtils.writeValueAsString(asyncNotify), 1, TimeUnit.DAYS);
        return asyncNotify;
    }

    /**
     * 保存达达订单异步通知
     *
     * @param uuid
     * @param topic
     * @return
     */
    public static AsyncNotify saveDadaOrderAsyncNotify(String uuid, String topic) {
        AsyncNotify asyncNotify = AsyncNotify.builder()
                .uuid(uuid)
                .topic(topic)
                .build();
        CommonRedisUtils.setex(uuid, JacksonUtils.writeValueAsString(asyncNotify), 1, TimeUnit.DAYS);
        return asyncNotify;
    }

    /**
     * 保存达达订单异步通知
     *
     * @param uuid
     * @param topic
     * @return
     */
    public static AsyncNotify saveAnubisOrderAsyncNotify(String uuid, String topic) {
        AsyncNotify asyncNotify = AsyncNotify.builder()
                .uuid(uuid)
                .topic(topic)
                .build();
        CommonRedisUtils.setex(uuid, JacksonUtils.writeValueAsString(asyncNotify), 1, TimeUnit.DAYS);
        return asyncNotify;
    }
}
