package build.dream.common.sockets;

import build.dream.common.utils.JacksonUtils;
import build.dream.common.utils.ThreadUtils;

import java.io.DataOutputStream;
import java.util.HashMap;
import java.util.Map;

public class HeartbeatThread implements Runnable {
    private Client client;
    private boolean continued = true;

    public HeartbeatThread() {

    }

    public HeartbeatThread(Client client) {
        this.client = client;

    }

    public void start() {
        new Thread(this).start();
    }

    public void stop() {
        continued = false;
    }

    @Override
    public void run() {
        while (continued) {
            try {
                Map<String, Object> heartbeatPackage = new HashMap<String, Object>();
                heartbeatPackage.put("code", "1001");
                heartbeatPackage.put("name", client.getName());

                DataOutputStream dataOutputStream = new DataOutputStream(client.getSocket().getOutputStream());
                dataOutputStream.writeUTF(JacksonUtils.writeValueAsString(heartbeatPackage));

                ThreadUtils.sleepSafe(10000);
            } catch (Exception e) {
                continued = false;
            }
        }
    }
}
