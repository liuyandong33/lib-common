package build.dream.common.models.dingtalk;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class CreateChatModel extends DingtalkBasicModel {
    /**
     * 群名称，长度限制为1~20个字符
     */
    @NotNull
    @Length(max = 20)
    private String name;

    /**
     * 群主userId，员工唯一标识ID；必须为该会话useridlist的成员之一
     */
    @NotNull
    private String owner;

    /**
     * 群成员列表，每次最多支持40人，群人数上限为1000
     */
    @NotEmpty
    @Size(max = 40)
    private List<String> userIdList;

    /**
     * 新成员是否可查看聊天历史消息（新成员入群是否可查看最近100条聊天记录），
     * 0代表否，
     * 1代表是，
     * 不传默认为否
     */
    private Integer showHistoryType;

    /**
     * 群可搜索，0-默认，不可搜索，1-可搜索
     */
    private Integer searchable;

    /**
     * 入群验证，0：不入群验证（默认） 1：入群验证
     */
    private Integer validationType;

    /**
     * @all 权限，0-默认，所有人，1-仅群主可@all
     */
    private Integer mentionAllAuthority;

    /**
     * 群禁言，0-默认，不禁言，1-全员禁言
     */
    private Integer chatBannedType;

    /**
     * 管理类型，0-默认，所有人可管理，1-仅群主可管理
     */
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

    public Integer getChatBannedType() {
        return chatBannedType;
    }

    public void setChatBannedType(Integer chatBannedType) {
        this.chatBannedType = chatBannedType;
    }

    public Integer getManagementType() {
        return managementType;
    }

    public void setManagementType(Integer managementType) {
        this.managementType = managementType;
    }

    public static class Builder extends DingtalkBasicModel.Builder<Builder, CreateChatModel> {
        public Builder name(String name) {
            instance.setName(name);
            return this;
        }

        public Builder owner(String owner) {
            instance.setOwner(owner);
            return this;
        }

        public Builder userIdList(List<String> userIdList) {
            instance.setUserIdList(userIdList);
            return this;
        }

        public Builder showHistoryType(Integer showHistoryType) {
            instance.setShowHistoryType(showHistoryType);
            return this;
        }

        public Builder searchable(Integer searchable) {
            instance.setSearchable(searchable);
            return this;
        }

        public Builder validationType(Integer validationType) {
            instance.setValidationType(validationType);
            return this;
        }

        public Builder mentionAllAuthority(Integer mentionAllAuthority) {
            instance.setMentionAllAuthority(mentionAllAuthority);
            return this;
        }

        public Builder chatBannedType(Integer chatBannedType) {
            instance.setChatBannedType(chatBannedType);
            return this;
        }

        public Builder managementType(Integer managementType) {
            instance.setManagementType(managementType);
            return this;
        }

        @Override
        public CreateChatModel build() {
            CreateChatModel createChatModel = super.build();
            createChatModel.setName(instance.getName());
            createChatModel.setOwner(instance.getOwner());
            createChatModel.setUserIdList(instance.getUserIdList());
            createChatModel.setShowHistoryType(instance.getShowHistoryType());
            createChatModel.setSearchable(instance.getSearchable());
            createChatModel.setValidationType(instance.getValidationType());
            createChatModel.setMentionAllAuthority(instance.getMentionAllAuthority());
            createChatModel.setChatBannedType(instance.getChatBannedType());
            createChatModel.setManagementType(instance.getManagementType());
            return createChatModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
