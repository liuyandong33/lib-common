package build.dream.common.utils;

import build.dream.common.constants.Constants;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;

public class AliyunOSSUtils {
    public static Map<String, String> obtainPolicy(String accessId, String accessKey, String host, String dir, Date expiration, List<Object[]> conditions, Map<String, String> callback) {
        SimpleDateFormat simpleDateFormat = CustomDateUtils.buildISO8601SimpleDateFormat();
        Map<String, Object> policyMap = new HashMap<String, Object>();
        policyMap.put("expiration", simpleDateFormat.format(expiration));
        policyMap.put("conditions", conditions);

        String policy = Base64.encodeBase64String(JacksonUtils.writeValueAsString(policyMap).getBytes(Constants.CHARSET_UTF_8));
        String signature = Base64.encodeBase64String(new HmacUtils(HmacAlgorithms.HMAC_SHA_1, accessKey).hmac(policy));

        Map<String, String> data = new HashMap<String, String>();
        data.put("accessId", accessId);
        data.put("policy", policy);
        data.put("signature", signature);
        data.put("dir", dir);
        data.put("host", host);
        data.put("callback", Base64.encodeBase64String(JacksonUtils.writeValueAsString(callback).getBytes(Constants.CHARSET_UTF_8)));
        return data;
    }

    public static String putObject(String bucketName, String key, InputStream inputStream) {
        String endpoint = "http://oss-cn-beijing.aliyuncs.com";
        String accessKeyId = "LTAI13Q9MtL90vHh";
        String accessKeySecret = "xL9bYrZ6MqyzYkAwjwGqQE4NGaDPlt";
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        ossClient.putObject("build-dream", "test.jpg", inputStream);
        ossClient.shutdown();

        return null;
    }

    public static void main(String[] args) {
        InputStream inputStream = new ByteArrayInputStream(UUID.randomUUID().toString().getBytes());
    }
}
