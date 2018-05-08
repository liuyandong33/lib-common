package build.dream.common;

import build.dream.common.utils.WebUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Demo {
    public static void main(String[] args) throws IOException {
//        SpringApplication.run(Application.class, args);

        String userId = "6768100064";
        String maxBehotTime = "1528442279";


        String result = callTouTiaoSystem(userId, maxBehotTime, "BA8PlhATXwSuIE8WCYrfKgQPDo");
        System.out.println(result);
    }

    public static String callTouTiaoSystem(String userId, String maxBehotTime, String signature) throws IOException {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.139 Safari/537.36");

        Map<String, String> requestParameters = new HashMap<String, String>();
        requestParameters.put("page_type", "1");
        requestParameters.put("user_id", userId);
        requestParameters.put("max_behot_time", maxBehotTime);
        requestParameters.put("count", "20");
        requestParameters.put("tadrequire", "true");
        requestParameters.put("as", "A165BADF912673F");
        requestParameters.put("cp", "5AF1F667538FEE1");
        requestParameters.put("_signature", signature);
        String result = WebUtils.doGetWithRequestParameters("https://www.toutiao.com/c/user/article/", headers, requestParameters);
        return result;
    }
}
