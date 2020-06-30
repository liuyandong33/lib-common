package build.dream.common;

import build.dream.common.okhttp.InputStreamRequestBody;
import build.dream.common.utils.JacksonUtils;
import build.dream.common.utils.OkHttpUtils;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.apache.tomcat.util.codec.binary.Base64;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class DemoController {
    public static void main(String[] args) throws IOException {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization", "Basic " + Base64.encodeBase64String("liuyandong:Lyd96373354005".getBytes()));
        headers.put("X-DCE-TENANT", "default");

        String result = OkHttpUtils.doPostWithForm("https://console-qingdao.cosmoplat.com/dce/sso/login", null, headers);
        Map<String, Object> resultMap = JacksonUtils.readValueAsMap(result, String.class, Object.class);

        String stopResult = stop(resultMap.get("access_token").toString(), "cosmoplat-appstore", "kstore-test-tomcat");
        System.out.println(stopResult);

        String startResult = start(resultMap.get("access_token").toString(), "cosmoplat-appstore", "kstore-test-tomcat");
        System.out.println(startResult);
    }

    public static String stop(String accessToken, String tenant, String appName) throws IOException {
        String body = "{\"spec\":{\"replicas\":0}}";

        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
        okHttpClientBuilder.connectTimeout(0, TimeUnit.SECONDS);
        okHttpClientBuilder.readTimeout(0, TimeUnit.SECONDS);

        InputStreamRequestBody inputStreamRequestBody = new InputStreamRequestBody(new ByteArrayInputStream(body.getBytes()), "application/strategic-merge-patch+json");
        Request.Builder requestBuilder = new Request.Builder();
        requestBuilder.patch(inputStreamRequestBody);
        requestBuilder.url("https://console-qingdao.cosmoplat.com/apis/apps/v1/namespaces/" + tenant + "/deployments/" + appName);
        requestBuilder.header("X-DCE-Access-Token", accessToken);
        requestBuilder.header("X-DCE-TENANT", tenant);
        return okHttpClientBuilder.build().newCall(requestBuilder.build()).execute().body().string();
    }

    public static String start(String accessToken, String tenant, String appName) throws IOException {
        String body = "{\"spec\":{\"replicas\":1}}";

        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
        okHttpClientBuilder.connectTimeout(0, TimeUnit.SECONDS);
        okHttpClientBuilder.readTimeout(0, TimeUnit.SECONDS);

        InputStreamRequestBody inputStreamRequestBody = new InputStreamRequestBody(new ByteArrayInputStream(body.getBytes()), "application/strategic-merge-patch+json");
        Request.Builder requestBuilder = new Request.Builder();
        requestBuilder.patch(inputStreamRequestBody);
        requestBuilder.url("https://console-qingdao.cosmoplat.com/apis/apps/v1/namespaces/" + tenant + "/deployments/" + appName);
        requestBuilder.header("X-DCE-Access-Token", accessToken);
        requestBuilder.header("X-DCE-TENANT", tenant);
        return okHttpClientBuilder.build().newCall(requestBuilder.build()).execute().body().string();
    }
}
