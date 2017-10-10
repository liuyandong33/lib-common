package build.dream.common.controllers;

import build.dream.common.annotations.ObtainWeChatOpenId;
import build.dream.common.api.ApiRest;
import build.dream.common.saas.domains.Tenant;
import build.dream.common.utils.ApplicationHandler;
import build.dream.common.utils.CacheUtils;
import build.dream.common.utils.GsonUtils;
import build.dream.common.utils.QueueUtils;
import org.apache.commons.lang.Validate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarOutputStream;

@Controller
@RequestMapping(value = "/demo")
public class DemoController {
    @RequestMapping(value = "/index")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("demo/index");
        return modelAndView;
    }

    @RequestMapping(value = "/set")
    @ResponseBody
    @ObtainWeChatOpenId
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

    @RequestMapping(value = "/createSession")
    @ResponseBody
    public String createSession() {
        ApiRest apiRest = null;
        Map<String, String> requestParameters = ApplicationHandler.getRequestParameters();
        try {
            HttpSession httpSession = ApplicationHandler.getHttpSession();
            apiRest = new ApiRest();
            apiRest.setData(httpSession.getId());
            apiRest.setMessage("创建session成功！");
            apiRest.setSuccessful(true);
        } catch (Exception e) {
            apiRest = new ApiRest(e);
        }
        return GsonUtils.toJson(apiRest);
    }

    @RequestMapping(value = "/invalidateSession")
    @ResponseBody
    public String invalidateSession() {
        ApiRest apiRest = null;
        Map<String, String> requestParameters = ApplicationHandler.getRequestParameters();
        try {
            HttpSession httpSession = ApplicationHandler.getHttpSession();
            String sessionId = httpSession.getId();
            httpSession.invalidate();
            apiRest = new ApiRest();
            apiRest.setData(sessionId);
            apiRest.setMessage("销毁session成功！");
            apiRest.setSuccessful(true);
        } catch (Exception e) {
            apiRest = new ApiRest(e);
        }
        return GsonUtils.toJson(apiRest);
    }

    @RequestMapping(value = "/setAttributesToSession")
    @ResponseBody
    public String setToSession() {
        ApiRest apiRest = null;
        Map<String, String> requestParameters = ApplicationHandler.getRequestParameters();
        try {
            String sessionId = ApplicationHandler.getSessionId();
            CacheUtils.setAttributesToSession(sessionId, requestParameters);
            apiRest = new ApiRest();
            apiRest.setData(sessionId);
            apiRest.setMessage("set to session success!");
            apiRest.setSuccessful(true);
        } catch (Exception e) {
            apiRest = new ApiRest(e);
        }
        return GsonUtils.toJson(apiRest);
    }

    @RequestMapping(value = "/buildJarPackage")
    @ResponseBody
    public String buildJarPackage() {
        ApiRest apiRest = null;
        Map<String, String> requestParameters = ApplicationHandler.getRequestParameters();
        try {
            String path = requestParameters.get("path");
            String fileName = requestParameters.get("fileName");
            JarFile jarFile = new JarFile(path + File.separator + fileName);
            Enumeration<JarEntry> entries = jarFile.entries();
            JarOutputStream jarOutputStream = new JarOutputStream(new FileOutputStream(path + File.separator + "copy_" + fileName));
            while (entries.hasMoreElements()) {
                JarEntry jarEntry = entries.nextElement();
                String name = jarEntry.getName();
                if ("WEB-INF/classes/application.properties".equals(name)) {
                    JarEntry applicationPropertiesJarEntry = new JarEntry("WEB-INF/classes/application.properties");
                    jarOutputStream.putNextEntry(applicationPropertiesJarEntry);
                    Properties properties = new Properties();
                    properties.setProperty("aa", "aa");
                    properties.store(jarOutputStream, "");
                } else if ("WEB-INF/classes/logback.xml".equals(name)) {

                } else {
                    jarOutputStream.putNextEntry(jarEntry);
                    InputStream inputStream = jarFile.getInputStream(jarEntry);
                    int length = 0;
                    byte[] buffer = new byte[1024];
                    while ((length = inputStream.read(buffer, 0, 1024)) != -1) {
                        jarOutputStream.write(buffer, 0, length);
                    }
                }
            }
            jarOutputStream.close();
            jarFile.close();
            new File(path + File.separator + fileName).delete();
            new File(path + File.separator + "copy_" + fileName).renameTo(new File(path + File.separator + fileName));
            apiRest = new ApiRest();
            apiRest.setMessage("jar包修改成功！");
            apiRest.setSuccessful(true);
        } catch (Exception e) {
            apiRest = new ApiRest(e);
        }
        return GsonUtils.toJson(apiRest);
    }
}
