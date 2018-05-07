package build.dream.common;

import build.dream.common.utils.WebUtils;
import net.sf.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by liuyandong on 2017/7/25.
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) throws IOException {
//        SpringApplication.run(Application.class, args);

        InputStream inputStream = new FileInputStream("/Users/liuyandong/Desktop/Hadoop学习笔记/sign.json");
        String sign = WebUtils.inputStreamToString(inputStream);
        JSONObject signJsonObject = JSONObject.fromObject(sign);

        String maxBehotTime = "1525190399";

        String result = callTouTiaoSystem(maxBehotTime, signJsonObject.getString(maxBehotTime));
        System.out.println(result);
        JSONObject resultJsonObject = JSONObject.fromObject(result);

        maxBehotTime = resultJsonObject.getJSONObject("next").getString("max_behot_time");

        result = callTouTiaoSystem(maxBehotTime, signJsonObject.getString(maxBehotTime));
        System.out.println(result);
        resultJsonObject = JSONObject.fromObject(result);

        maxBehotTime = resultJsonObject.getJSONObject("next").getString("max_behot_time");

        result = callTouTiaoSystem(maxBehotTime, signJsonObject.getString(maxBehotTime));
        System.out.println(result);
        resultJsonObject = JSONObject.fromObject(result);
    }

    public static String callTouTiaoSystem(String maxBehotTime, String signature) throws IOException {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.139 Safari/537.36");

        Map<String, String> requestParameters = new HashMap<String, String>();
        requestParameters.put("page_type", "1");
        requestParameters.put("user_id", "6768100064");
        requestParameters.put("max_behot_time", maxBehotTime);
        requestParameters.put("count", "20");
        requestParameters.put("tadrequire", "true");
        requestParameters.put("as", "A1954AAFE0F5977");
        requestParameters.put("cp", "5AF095E95787AE1");
        requestParameters.put("_signature", signature);
        String result = WebUtils.doGetWithRequestParameters("https://www.toutiao.com/c/user/article/", headers, requestParameters);
        return result;
    }
}
