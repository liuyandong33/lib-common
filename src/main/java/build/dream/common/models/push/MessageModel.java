package build.dream.common.models.push;

import build.dream.common.models.BasicModel;

import javax.validation.constraints.NotNull;

public class MessageModel extends BasicModel {
    /**
     * 消息类型
     * 1-饿了么订单生效
     * 2-订单被取消（接单前）
     * 3-下单用户申请取消
     * 4-用户取消取消订单
     * 5-用户申请仲裁
     * 6-客服仲裁取消单申请有效
     * 7-客服仲裁取消单申请无效
     * 8-用户申请退单
     * 9-用户取消退单
     * 10-用户申请仲裁
     * 11-客服仲裁退单有效
     * 12-客服仲裁退单无效
     * 13-用户催单
     * 100-POS MQTT Token 失效消息
     */
    @NotNull
    private Integer type;

    @NotNull
    private String uuid;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
