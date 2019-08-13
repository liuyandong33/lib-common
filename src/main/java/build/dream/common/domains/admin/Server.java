package build.dream.common.domains.admin;

import build.dream.common.basic.BasicDomain;

import java.math.BigInteger;
import java.util.Date;

public class Server extends BasicDomain {
    /**
     * 主机名称
     */
    private String hostName;
    /**
     * ip 地址
     */
    private String ipAddress;
    /**
     * ssh 连接端口号
     */
    private Integer sshPort;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String password;

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public Integer getSshPort() {
        return sshPort;
    }

    public void setSshPort(Integer sshPort) {
        this.sshPort = sshPort;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static class Builder {
        private final Server instance = new Server();

        public Builder hostName(String hostName) {
            instance.setHostName(hostName);
            return this;
        }

        public Builder ipAddress(String ipAddress) {
            instance.setIpAddress(ipAddress);
            return this;
        }

        public Builder sshPort(int sshPort) {
            instance.setSshPort(sshPort);
            return this;
        }

        public Builder userName(String userName) {
            instance.setUserName(userName);
            return this;
        }

        public Builder password(String password) {
            instance.setPassword(password);
            return this;
        }

        public Builder id(BigInteger id) {
            instance.setId(id);
            return this;
        }

        public Builder createdTime(Date createdTime) {
            instance.setCreatedTime(createdTime);
            return this;
        }

        public Builder createdUserId(BigInteger createdUserId) {
            instance.setCreatedUserId(createdUserId);
            return this;
        }

        public Builder updatedTime(Date updatedTime) {
            instance.setUpdatedTime(updatedTime);
            return this;
        }

        public Builder updatedUserId(BigInteger updatedUserId) {
            instance.setUpdatedUserId(updatedUserId);
            return this;
        }

        public Builder updatedRemark(String updatedRemark) {
            instance.setUpdatedRemark(updatedRemark);
            return this;
        }

        public Builder deletedTime(Date deletedTime) {
            instance.setDeletedTime(deletedTime);
            return this;
        }

        public Builder deleted(boolean deleted) {
            instance.setDeleted(deleted);
            return this;
        }

        public Server build() {
            Server server = new Server();
            server.setHostName(instance.getHostName());
            server.setIpAddress(instance.getIpAddress());
            server.setSshPort(instance.getSshPort());
            server.setUserName(instance.getUserName());
            server.setPassword(instance.getPassword());
            server.setId(instance.getId());
            server.setCreatedTime(instance.getCreatedTime());
            server.setCreatedUserId(instance.getCreatedUserId());
            server.setUpdatedTime(instance.getUpdatedTime());
            server.setUpdatedUserId(instance.getUpdatedUserId());
            server.setUpdatedRemark(instance.getUpdatedRemark());
            server.setDeletedTime(instance.getDeletedTime());
            server.setDeleted(instance.isDeleted());
            return server;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String HOST_NAME = "host_name";
        public static final String IP_ADDRESS = "ip_address";
        public static final String SSH_PORT = "ssh_port";
        public static final String USER_NAME = "user_name";
        public static final String password = "password";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String HOST_NAME = "hostName";
        public static final String IP_ADDRESS = "ipAddress";
        public static final String SSH_PORT = "sshPort";
        public static final String USER_NAME = "userName";
        public static final String password = "password";
    }
}
