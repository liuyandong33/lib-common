package build.dream.common.models.push;

import javax.validation.constraints.NotNull;
import java.math.BigInteger;

public class OrderMessageModel extends MessageModel {
    @NotNull
    private BigInteger orderId;

    public BigInteger getOrderId() {
        return orderId;
    }

    public void setOrderId(BigInteger orderId) {
        this.orderId = orderId;
    }
}
