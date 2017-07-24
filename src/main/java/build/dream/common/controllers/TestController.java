package build.dream.common.controllers;

import build.dream.common.utils.SystemPartitionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * Created by liuyandong on 2017/7/24.
 */
@Controller
@RequestMapping(value = "/test")
public class TestController {
    @RequestMapping(value = "/test")
    @ResponseBody
    public String test() throws IOException {
        return SystemPartitionUtils.getUrl("za1", "out", "weiXinPay", "unifiedOrder");
    }
}
