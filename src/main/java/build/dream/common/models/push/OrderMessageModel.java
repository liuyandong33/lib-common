package build.dream.common.models.push;

import javax.validation.constraints.NotNull;

public class OrderMessageModel extends MessageModel {
    @NotNull
    private Long orderId;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
