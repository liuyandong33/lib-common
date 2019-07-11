package build.dream.common.auth;

import java.math.BigInteger;

public class AgentUserDetails extends AbstractUserDetails {
    private BigInteger userId;
    private BigInteger agentId;
    private String agentCode;

    public BigInteger getUserId() {
        return userId;
    }

    public void setUserId(BigInteger userId) {
        this.userId = userId;
    }

    public BigInteger getAgentId() {
        return agentId;
    }

    public void setAgentId(BigInteger agentId) {
        this.agentId = agentId;
    }

    public String getAgentCode() {
        return agentCode;
    }

    public void setAgentCode(String agentCode) {
        this.agentCode = agentCode;
    }
}
