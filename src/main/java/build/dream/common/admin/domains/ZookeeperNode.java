package build.dream.common.admin.domains;

import build.dream.common.basic.BasicDomain;

import java.math.BigInteger;

public class ZookeeperNode extends BasicDomain {
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
    private String zookeeperHome;

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

    public String getZookeeperHome() {
        return zookeeperHome;
    }

    public void setZookeeperHome(String zookeeperHome) {
        this.zookeeperHome = zookeeperHome;
    }
}
