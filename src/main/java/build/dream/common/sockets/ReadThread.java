package build.dream.common.sockets;

import build.dream.common.beans.WebResponse;
import build.dream.common.utils.GsonUtils;
import build.dream.common.utils.JacksonUtils;
import build.dream.common.utils.WebUtils;
import org.apache.commons.collections.MapUtils;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadThread implements Runnable {
    private Client client;
    private boolean continued = true;
    private DataInputStream dataInputStream;

    public ReadThread() {

    }

    public ReadThread(Client client) {
        this.client = client;
        try {
            dataInputStream = new DataInputStream(client.getSocket().getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (continued) {
            try {
                String command = dataInputStream.readUTF();
                Map<String, Object> commandMap = JacksonUtils.readValueAsMap(command, String.class, Object.class);
                String code = MapUtils.getString(commandMap, "code");
                if ("1002".equals(code)) {
                    Map<String, String> headers = MapUtils.getMap(commandMap, "headers");
                    Map<String, String> params = MapUtils.getMap(commandMap, "params");
                    String url = MapUtils.getString(commandMap, "url");
                    String method = MapUtils.getString(commandMap, "method");
                    String uuid = MapUtils.getString(commandMap, "uuid");

                    url = "http://www.smartpos.top/portal/tenantWebService/showTenantInfo";

                    String result = null;
                    WebResponse webResponse = null;
                    if ("GET".equals(method)) {
                        webResponse = WebUtils.doGetWithRequestParameters(url, params);
                    } else if ("POST".equals(method)) {
                        webResponse = WebUtils.doPostWithRequestParameters(url, params, null);
                    }

                    Map<String, String> body = new HashMap<String, String>();
                    body.put("uuid", uuid);
                    body.put("result", GsonUtils.toJson(webResponse));
                    WebUtils.doPostWithRequestParameters(client.getUploadResultUrl(), body);
                }
            } catch (IOException e) {
                continued = false;
            }
        }
    }

    public void start() {
        new Thread(this).start();
    }

    public void stop() {
        continued = false;
    }
}
