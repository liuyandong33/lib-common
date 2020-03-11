package build.dream.common.domains.devops;

import build.dream.common.basic.BasicDomain;

import java.util.Date;

public class KafkaNode extends BasicDomain {
    public static final String TABLE_NAME = "kafka_node";
    /**
     * 集群ID
     */
    private Long clusterId;
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

    public Long getClusterId() {
        return clusterId;
    }

    public void setClusterId(Long clusterId) {
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

        public Builder clusterId(Long clusterId) {
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

        public Builder id(Long id) {
            instance.setId(id);
            return this;
        }

        public Builder createdTime(Date createdTime) {
            instance.setCreatedTime(createdTime);
            return this;
        }

        public Builder createdUserId(Long createdUserId) {
            instance.setCreatedUserId(createdUserId);
            return this;
        }

        public Builder updatedTime(Date updatedTime) {
            instance.setUpdatedTime(updatedTime);
            return this;
        }

        public Builder updatedUserId(Long updatedUserId) {
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

        public KafkaNode build() {
            KafkaNode kafkaNode = new KafkaNode();
            kafkaNode.setClusterId(instance.getClusterId());
            kafkaNode.setHostName(instance.getHostName());
            kafkaNode.setIpAddress(instance.getIpAddress());
            kafkaNode.setSshPort(instance.getSshPort());
            kafkaNode.setUserName(instance.getUserName());
            kafkaNode.setPassword(instance.getPassword());
            kafkaNode.setKafkaHome(instance.getKafkaHome());
            kafkaNode.setId(instance.getId());
            kafkaNode.setCreatedTime(instance.getCreatedTime());
            kafkaNode.setCreatedUserId(instance.getCreatedUserId());
            kafkaNode.setUpdatedTime(instance.getUpdatedTime());
            kafkaNode.setUpdatedUserId(instance.getUpdatedUserId());
            kafkaNode.setUpdatedRemark(instance.getUpdatedRemark());
            kafkaNode.setDeletedTime(instance.getDeletedTime());
            kafkaNode.setDeleted(instance.isDeleted());
            return kafkaNode;
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
