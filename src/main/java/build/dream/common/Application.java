package build.dream.common;

import build.dream.common.beans.WebResponse;
import build.dream.common.utils.GsonUtils;
import build.dream.common.utils.WebUtils;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.HmacUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by liuyandong on 2017/7/25.
 */
@SpringBootApplication
public class Application extends ClassLoader {
    public static void main(String[] args) throws IOException {
//        SpringApplication.run(Application.class, args);

        SimpleDateFormat rfc822DateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
        rfc822DateFormat.setTimeZone(new SimpleTimeZone(0, "GMT"));

        String dateString = rfc822DateFormat.format(new Date());
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("x-log-apiversion", "0.6.0");
        headers.put("x-log-signaturemethod", "hmac-sha1");
        headers.put("Date", dateString);

        Map<String, String> requestParameters = new LinkedHashMap<String, String>();
        requestParameters.put("type", "log");
        requestParameters.put("from", "0");
        requestParameters.put("to", String.valueOf(System.currentTimeMillis() / 1000));
        requestParameters.put("line", "20");
        requestParameters.put("offset", "0");

        Map<String, String> sortedRequestParameters = new TreeMap<String, String>(requestParameters);
        List<String> canonicalizedResource = new ArrayList<String>();
        for (Map.Entry<String, String> entry : sortedRequestParameters.entrySet()) {
            canonicalizedResource.add(entry.getKey() + "=" + entry.getValue());
        }

        Map<String, String> sortedMap = new TreeMap<String, String>(headers);
        List<String> canonicalizedLOGHeaders = new ArrayList<String>();
        for (Map.Entry<String, String> entry : sortedMap.entrySet()) {
            String key = entry.getKey();
            if (key.startsWith("x-log-")) {
                canonicalizedLOGHeaders.add(entry.getKey() + ":" + entry.getValue());
            }
        }

        String signatureString = "GET" + "\n" + "\n" + "\n" + dateString + "\n" + StringUtils.join(canonicalizedLOGHeaders, "\n") + "\n/logstores/testlog?" + StringUtils.join(canonicalizedResource, "&");

        String accessKeyId = "LTAIzWtJmkzU0Uex";
        String accessKeySecret = "6XIiGAie3fEPoUIhQpZMsXuPa80bwT";
        String signature = Base64.encodeBase64String(HmacUtils.hmacSha1(accessKeySecret, signatureString));

        headers.put("Authorization", "LOG " + accessKeyId + ":" + signature);

        WebResponse webResponse = WebUtils.doGetWithRequestParameters("http://logback.cn-qingdao.log.aliyuncs.com/logstores/testlog", headers, requestParameters);
        String result = webResponse.getResult();
        Map<String, List<String>> responseHeaders = webResponse.getHeaders();

        System.out.println(GsonUtils.toJson(responseHeaders));
        System.out.println(result);
    }
}
