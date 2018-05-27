package build.dream.common.models.jingdong;

import build.dream.common.models.BasicModel;
import build.dream.common.utils.GsonUtils;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class RiskInfo extends BasicModel {
    @Length(max = 64)
    private String omId;

    @Length(max = 200)
    private String omName;

    @Length(max = 30)
    private String omRt;

    @Length(max = 20)
    private String omType;

    @Length(max = 200)
    private String omAdd;

    @Length(max = 64)
    private String agentId;

    @Length(max = 200)
    private String agentName;

    @NotNull
    @Length(max = 64)
    private String enterpriseId;

    public String getOmId() {
        return omId;
    }

    public void setOmId(String omId) {
        this.omId = omId;
    }

    public String getOmName() {
        return omName;
    }

    public void setOmName(String omName) {
        this.omName = omName;
    }

    public String getOmRt() {
        return omRt;
    }

    public void setOmRt(String omRt) {
        this.omRt = omRt;
    }

    public String getOmType() {
        return omType;
    }

    public void setOmType(String omType) {
        this.omType = omType;
    }

    public String getOmAdd() {
        return omAdd;
    }

    public void setOmAdd(String omAdd) {
        this.omAdd = omAdd;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    @Override
    public String toString() {
        return GsonUtils.toJson(this, false);
    }
}
