package build.dream.common.utils;

import build.dream.common.constants.Constants;
import com.jcraft.jsch.*;

import java.io.IOException;
import java.io.InputStream;

public class JSchUtils {
    public static Session createSession(String userName, String password, String ipAddress, int port) throws JSchException {
        JSch jsch = new JSch();
        Session session = jsch.getSession(userName, ipAddress, port);
        session.setConfig("PreferredAuthentications", "password");
        session.setConfig("StrictHostKeyChecking", "no");
        session.setPassword(password);
        session.connect(3000);
        return session;
    }

    public static void disconnectSession(Session session) {
        if (session != null) {
            session.disconnect();
        }
    }

    public static Channel openChannel(Session session, String type) throws JSchException {
        return session.openChannel(type);
    }

    public static void disconnectChannel(Channel channel) {
        if (channel != null) {
            channel.disconnect();
        }
    }

    public static String executeCommand(Session session, String command) throws JSchException, IOException {
        ChannelExec channelExec = (ChannelExec) openChannel(session, Constants.CHANNEL_TYPE_EXEC);
        channelExec.setCommand(command);
        channelExec.connect();
        InputStream inputStream = channelExec.getInputStream();
        String result = IOUtils.toString(inputStream);

        int exitStatus = channelExec.getExitStatus();
        ValidateUtils.isTrue(exitStatus == 0, result);

        disconnectChannel(channelExec);
        return result;
    }
}
