package build.dream.common.models.jpush;

import build.dream.common.models.BasicModel;

import javax.validation.constraints.NotNull;

public class ValidCodeModel extends BasicModel {
    @NotNull
    private String msgId;

    @NotNull
    private String code;

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public static class Builder {
        private final ValidCodeModel instance = new ValidCodeModel();

        public Builder msgId(String msgId) {
            instance.setMsgId(msgId);
            return this;
        }

        public Builder code(String code) {
            instance.setCode(code);
            return this;
        }

        public ValidCodeModel build() {
            ValidCodeModel validCodeModel = new ValidCodeModel();
            validCodeModel.setMsgId(instance.getMsgId());
            validCodeModel.setCode(instance.getCode());
            return validCodeModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
