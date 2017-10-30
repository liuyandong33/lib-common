package build.dream.common.erp.domains;

import build.dream.common.basic.BasicDomain;

import java.math.BigInteger;
import java.util.Date;

public class ElemeGroup extends BasicDomain {
    /**
     * 饿了么系统订单ID
     */
    private String orderId;
    /**
     * 分组名称
     */
    private String name;
    /**
     * 分组类型，normal-正常的菜品，extra-配送费等，discount-赠品
     */
    private String type;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
