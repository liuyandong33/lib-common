package build.dream.common.sockets;

import java.io.IOException;
import java.net.Socket;

public class Client {
    private String name;
    private String uploadResultUrl;
    private String serverHost;
    private int serverPort;
    private Socket socket;

    public Client() {

    }

    public Client(String name, String uploadResultUrl, String serverHost, int serverPort) {
        this.name = name;
        this.uploadResultUrl = uploadResultUrl;
        this.serverHost = serverHost;
        this.serverPort = serverPort;
    }

    public void start() throws IOException {
        this.socket = new Socket(serverHost, serverPort);
        new HeartbeatThread(this).start();

        ReadThread readThread = new ReadThread(this);
        new Thread(readThread).start();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUploadResultUrl() {
        return uploadResultUrl;
    }

    public void setUploadResultUrl(String uploadResultUrl) {
        this.uploadResultUrl = uploadResultUrl;
    }

    public String getServerHost() {
        return serverHost;
    }

    public void setServerHost(String serverHost) {
        this.serverHost = serverHost;
    }

    public int getServerPort() {
        return serverPort;
    }

    public void setServerPort(int serverPort) {
        this.serverPort = serverPort;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
}
