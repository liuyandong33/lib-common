package build.dream.common.models.dingtalk;

import build.dream.common.models.BasicModel;

import javax.validation.constraints.NotNull;

public class SendModel extends BasicModel {
    @NotNull
    private String sender;

    @NotNull
    private String chatId;

    @NotNull
    private String content;

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
