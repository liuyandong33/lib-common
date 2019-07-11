package build.dream.common.models;

import build.dream.common.annotations.InstantiateObjectIgnore;
import build.dream.common.auth.AgentUserDetails;
import build.dream.common.utils.WebSecurityUtils;

import java.math.BigInteger;

public class AgentBasicModel extends BasicModel {
    @InstantiateObjectIgnore
    private BigInteger _userId;

    @InstantiateObjectIgnore
    private BigInteger _agentId;

    @InstantiateObjectIgnore
    private String _agentCode;

    public AgentBasicModel() {
        AgentUserDetails agentUserDetails = WebSecurityUtils.obtainAgentUserDetails();
        this._userId = agentUserDetails.getUserId();
        this._agentId = agentUserDetails.getAgentId();
        this._agentCode = agentUserDetails.getAgentCode();
    }

    public BigInteger obtainUserId() {
        return _userId;
    }

    public BigInteger obtainAgentId() {
        return _agentId;
    }

    public String obtainAgentCode() {
        return _agentCode;
    }
}
