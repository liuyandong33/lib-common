package build.dream.common.models.push;

import build.dream.common.models.BasicModel;

import javax.validation.constraints.NotNull;

public class MessageModel extends BasicModel {
    @NotNull
    private Integer type;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
