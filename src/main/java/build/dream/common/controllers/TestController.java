package build.dream.common.controllers;

import build.dream.common.annotations.ObtainWeChatOpenId;
import build.dream.common.api.ApiRest;
import build.dream.common.utils.GsonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * Created by liuyandong on 2017/7/24.
 */
@Controller
@RequestMapping(value = "/test")
public class TestController {
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    @ResponseBody
    @ObtainWeChatOpenId
    public String test() {
        ApiRest apiRest = new ApiRest();
        return GsonUtils.toJson(apiRest);
    }
}
