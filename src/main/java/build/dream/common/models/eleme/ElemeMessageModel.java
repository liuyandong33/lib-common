package build.dream.common.models.eleme;

import build.dream.common.models.push.MessageModel;

import javax.validation.constraints.NotNull;
import java.math.BigInteger;

public class ElemeMessageModel extends MessageModel {
    @NotNull
    private String uuid;
    @NotNull
    private BigInteger orderId;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public BigInteger getOrderId() {
        return orderId;
    }

    public void setOrderId(BigInteger orderId) {
        this.orderId = orderId;
    }
}
