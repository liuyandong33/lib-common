package build.dream.common.controllers;

import build.dream.common.utils.ApplicationHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Controller
@RequestMapping(value = "/download")
public class DownloadController {
    @RequestMapping(value = "/app")
    @ResponseBody
    public void app() throws IOException {
        HttpServletResponse httpServletResponse = ApplicationHandler.getHttpServletResponse();
        OutputStream outputStream = httpServletResponse.getOutputStream();
        InputStream inputStream = new FileInputStream("C:\\Users\\liuyandong\\Desktop\\app-debug.apk");
        httpServletResponse.addHeader("Content-Disposition", "attachment;filename=app-debug.apk");
        int length = 0;
        byte[] buffer = new byte[1024];
        while ((length = inputStream.read(buffer, 0, 1024)) != -1) {
            outputStream.write(buffer, 0, length);
        }
        outputStream.close();
        inputStream.close();
    }
}
