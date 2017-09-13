package build.dream.common.controllers;

import build.dream.common.api.ApiRest;
import build.dream.common.saas.domains.Tenant;
import build.dream.common.utils.ApplicationHandler;
import build.dream.common.utils.GsonUtils;
import build.dream.common.utils.QueueUtils;
import org.apache.commons.lang.Validate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping(value = "/demo")
public class DemoController {
    @RequestMapping(value = "/set")
    @ResponseBody
    public String set() {
        ApiRest apiRest = null;
        Map<String, String> requestParameters = ApplicationHandler.getRequestParameters();
        try {
            String key = requestParameters.get("key");
            Validate.notNull(key, "参数(key)不能为空！");

            String value = requestParameters.get("value");

            QueueUtils.convertAndSend(key, GsonUtils.toJson(new Tenant()));

            apiRest = new ApiRest();
            apiRest.setMessage("设置值成功！");
            apiRest.setSuccessful(true);
        } catch (Exception e) {
            apiRest = new ApiRest(e);
        }
        return GsonUtils.toJson(apiRest);
    }
}
