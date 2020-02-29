package build.dream.common.utils;

import build.dream.common.beans.MqConfig;
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
     * @param mqConfig
     * @param apiKey
     * @param signType
     * @return
     */
    public static AsyncNotify saveWeiXinPayAsyncNotify(String uuid, MqConfig mqConfig, String apiKey, String signType) {
        AsyncNotify asyncNotify = AsyncNotify.builder()
                .uuid(uuid)
                .mqConfig(mqConfig)
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
     * @param mqConfig
     * @param apiKey
     * @param signType
     * @return
     */
    public static AsyncNotify saveWeiXinRefundAsyncNotify(String uuid, MqConfig mqConfig, String apiKey, String signType, String apiV3Key) {
        AsyncNotify asyncNotify = AsyncNotify.builder()
                .uuid(uuid)
                .mqConfig(mqConfig)
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
     * @param mqConfig
     * @param alipayPublicKey
     * @param signType
     * @return
     */
    private static AsyncNotify saveAlipayAsyncNotify(String uuid, MqConfig mqConfig, String alipayPublicKey, String signType) {
        AsyncNotify asyncNotify = AsyncNotify.builder()
                .uuid(uuid)
                .mqConfig(mqConfig)
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
     * @param mqConfig
     * @param miyaKey
     * @return
     */
    public static AsyncNotify saveMiyaAsyncNotify(String uuid, MqConfig mqConfig, String miyaKey) {
        AsyncNotify asyncNotify = AsyncNotify.builder()
                .uuid(uuid)
                .mqConfig(mqConfig)
                .miyaKey(miyaKey)
                .build();
        CommonRedisUtils.setex(uuid, JacksonUtils.writeValueAsString(asyncNotify), 1, TimeUnit.DAYS);
        return asyncNotify;
    }

    /**
     * 保存联动支付异步通知
     *
     * @param uuid
     * @param mqConfig
     * @param umPayPrivateKey
     * @param umPayPlatformCertificate
     * @return
     */
    public static AsyncNotify saveUmPayAsyncNotify(String uuid, MqConfig mqConfig, String umPayPrivateKey, String umPayPlatformCertificate) {
        AsyncNotify asyncNotify = AsyncNotify.builder()
                .uuid(uuid)
                .mqConfig(mqConfig)
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
     * @param mqConfig
     * @return
     */
    public static AsyncNotify saveDadaOrderAsyncNotify(String uuid, MqConfig mqConfig) {
        AsyncNotify asyncNotify = AsyncNotify.builder()
                .uuid(uuid)
                .mqConfig(mqConfig)
                .build();
        CommonRedisUtils.setex(uuid, JacksonUtils.writeValueAsString(asyncNotify), 1, TimeUnit.DAYS);
        return asyncNotify;
    }

    /**
     * 保存达达订单异步通知
     *
     * @param uuid
     * @param mqConfig
     * @return
     */
    public static AsyncNotify saveAnubisOrderAsyncNotify(String uuid, MqConfig mqConfig) {
        AsyncNotify asyncNotify = AsyncNotify.builder()
                .uuid(uuid)
                .mqConfig(mqConfig)
                .build();
        CommonRedisUtils.setex(uuid, JacksonUtils.writeValueAsString(asyncNotify), 1, TimeUnit.DAYS);
        return asyncNotify;
    }
}
