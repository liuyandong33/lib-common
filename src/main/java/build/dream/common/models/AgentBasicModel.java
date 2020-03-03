package build.dream.common.models;

import build.dream.common.annotations.InstantiateObjectIgnore;
import build.dream.common.auth.AgentUserDetails;
import build.dream.common.utils.WebSecurityUtils;

public class AgentBasicModel extends BasicModel {
    @InstantiateObjectIgnore
    private Long _userId;

    @InstantiateObjectIgnore
    private Long _agentId;

    @InstantiateObjectIgnore
    private String _agentCode;

    public AgentBasicModel() {
        AgentUserDetails agentUserDetails = WebSecurityUtils.obtainAgentUserDetails();
        this._userId = agentUserDetails.getUserId();
        this._agentId = agentUserDetails.getAgentId();
        this._agentCode = agentUserDetails.getAgentCode();
    }

    public Long obtainUserId() {
        return _userId;
    }

    public Long obtainAgentId() {
        return _agentId;
    }

    public String obtainAgentCode() {
        return _agentCode;
    }
}
