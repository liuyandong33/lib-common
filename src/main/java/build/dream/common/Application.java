package build.dream.common;

import build.dream.common.utils.WebUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by liuyandong on 2017/7/25.
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) throws IOException {
//        SpringApplication.run(Application.class, args);
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.139 Safari/537.36");
        String result = WebUtils.doGetWithRequestParameters("https://www.toutiao.com/c/user/article/?page_type=1&user_id=6768100064&max_behot_time=1525162696&count=20&as=A1E5EA3F30B1D0A&cp=5AF0814D006A2E1&_signature=jjOkGBAY1NAkHOSYpblMB44zpQ", headers, (Map<String, String>) null);
        JSONObject resultJsonObject = JSONObject.fromObject(result);

        JSONArray data = resultJsonObject.getJSONArray("data");

        int size = data.size();
        for (int index = 0; index < size; index++) {
            JSONObject jsonObject = data.getJSONObject(index);
            String displayUrl = jsonObject.getString("display_url");
            System.out.println(displayUrl);
        }
    }
}
