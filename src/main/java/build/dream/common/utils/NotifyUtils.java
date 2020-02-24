package build.dream.common.utils;

import build.dream.common.constants.Constants;
import build.dream.common.domains.saas.AsyncNotify;

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
    public static AsyncNotify saveWeiXinRefundAsyncNotify(String uuid, String topic, String apiKey, String signType, String apiV3Key) {
        AsyncNotify asyncNotify = AsyncNotify.builder()
                .uuid(uuid)
                .topic(topic)
                .weiXinPayApiKey(apiKey)
                .weiXinPaySignType(signType)
                .weiXinPayApiV3Key(apiV3Key)
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
