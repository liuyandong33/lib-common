package build.dream.common.models.dingtalk;

import build.dream.common.models.BasicModel;

import javax.validation.constraints.NotNull;
import java.util.Map;

public class SendModel extends DingtalkBasicModel {
    @NotNull
    private String chatId;

    @NotNull
    private Map<String, Object> msg;

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public Map<String, Object> getMsg() {
        return msg;
    }

    public void setMsg(Map<String, Object> msg) {
        this.msg = msg;
    }

    public static class Builder extends DingtalkBasicModel.Builder<Builder, SendModel> {
        public Builder chatId(String chatId) {
            instance.setChatId(chatId);
            return this;
        }

        public Builder msg(Map<String, Object> msg) {
            instance.setMsg(msg);
            return this;
        }

        @Override
        public SendModel build() {
            SendModel sendModel = super.build();
            sendModel.setChatId(instance.getChatId());
            sendModel.setMsg(instance.getMsg());
            return sendModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
