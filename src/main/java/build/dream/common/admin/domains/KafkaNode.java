package build.dream.common.admin.domains;

import build.dream.common.basic.BasicDomain;

import java.math.BigInteger;
import java.util.Date;

public class KafkaNode extends BasicDomain {
    /**
     * 集群ID
     */
    private BigInteger clusterId;
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
    /**
     * zookeeper 主目录
     */
    private String kafkaHome;

    public BigInteger getClusterId() {
        return clusterId;
    }

    public void setClusterId(BigInteger clusterId) {
        this.clusterId = clusterId;
    }

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

    public String getKafkaHome() {
        return kafkaHome;
    }

    public void setKafkaHome(String kafkaHome) {
        this.kafkaHome = kafkaHome;
    }

    public static class Builder {
        private final KafkaNode instance = new KafkaNode();

        public Builder clusterId(BigInteger clusterId) {
            instance.setClusterId(clusterId);
            return this;
        }

        public Builder hostName(String hostName) {
            instance.setHostName(hostName);
            return this;
        }

        public Builder ipAddress(String ipAddress) {
            instance.setIpAddress(ipAddress);
            return this;
        }

        public Builder sshPort(Integer sshPort) {
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

        public Builder kafkaHome(String kafkaHome) {
            instance.setKafkaHome(kafkaHome);
            return this;
        }

        public Builder id(BigInteger id) {
            instance.setId(id);
            return this;
        }

        public Builder createTime(Date createTime) {
            instance.setCreateTime(createTime);
            return this;
        }

        public Builder createUserId(BigInteger createUserId) {
            instance.setCreateUserId(createUserId);
            return this;
        }

        public Builder lastUpdateTime(Date lastUpdateTime) {
            instance.setLastUpdateTime(lastUpdateTime);
            return this;
        }

        public Builder lastUpdateUserId(BigInteger lastUpdateUserId) {
            instance.setLastUpdateUserId(lastUpdateUserId);
            return this;
        }

        public Builder lastUpdateRemark(String lastUpdateRemark) {
            instance.setLastUpdateRemark(lastUpdateRemark);
            return this;
        }

        public Builder deleteTime(Date deleteTime) {
            instance.setDeleteTime(deleteTime);
            return this;
        }

        public Builder deleted(boolean deleted) {
            instance.setDeleted(deleted);
            return this;
        }

        public KafkaNode build() {
            return instance;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String CLUSTER_ID = "cluster_id";
        public static final String HOST_NAME = "host_name";
        public static final String IP_ADDRESS = "ip_address";
        public static final String SSH_PORT = "ssh_port";
        public static final String USER_NAME = "user_name";
        public static final String PASSWORD = "password";
        public static final String KAFKA_HOME = "kafka_home";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String CLUSTER_ID = "clusterId";
        public static final String HOST_NAME = "hostName";
        public static final String IP_ADDRESS = "ipAddress";
        public static final String SSH_PORT = "sshPort";
        public static final String USER_NAME = "userName";
        public static final String PASSWORD = "password";
        public static final String KAFKA_HOME = "kafkaHome";
    }
}
