package build.dream.common.models.dingtalk;

import build.dream.common.models.BasicModel;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class CreateChatModel extends BasicModel {
    @NotNull
    @Length(max = 20)
    private String name;

    @NotNull
    private String owner;

    @NotEmpty
    @Size(max = 40)
    private List<String> userIdList;

    @NotNull
    private Integer showHistoryType;

    @NotNull
    private Integer searchable;

    @NotNull
    private Integer validationType;

    @NotNull
    private Integer mentionAllAuthority;

    @NotNull
    private Integer managementType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public List<String> getUserIdList() {
        return userIdList;
    }

    public void setUserIdList(List<String> userIdList) {
        this.userIdList = userIdList;
    }

    public Integer getShowHistoryType() {
        return showHistoryType;
    }

    public void setShowHistoryType(Integer showHistoryType) {
        this.showHistoryType = showHistoryType;
    }

    public Integer getSearchable() {
        return searchable;
    }

    public void setSearchable(Integer searchable) {
        this.searchable = searchable;
    }

    public Integer getValidationType() {
        return validationType;
    }

    public void setValidationType(Integer validationType) {
        this.validationType = validationType;
    }

    public Integer getMentionAllAuthority() {
        return mentionAllAuthority;
    }

    public void setMentionAllAuthority(Integer mentionAllAuthority) {
        this.mentionAllAuthority = mentionAllAuthority;
    }

    public Integer getManagementType() {
        return managementType;
    }

    public void setManagementType(Integer managementType) {
        this.managementType = managementType;
    }
}
