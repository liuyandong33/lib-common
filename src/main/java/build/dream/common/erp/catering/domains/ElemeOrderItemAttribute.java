package build.dream.common.erp.catering.domains;

import build.dream.common.basic.BasicDomain;

import java.math.BigInteger;
import java.util.Date;

public class ElemeOrderItemAttribute extends BasicDomain {
    /**
     * eleme item id
     */
    private BigInteger elemeOrderItemId;
    /**
     * 属性名称
     */
    private String name;
    /**
     * 属性值
     */
    private String value;

    public BigInteger getElemeOrderItemId() {
        return elemeOrderItemId;
    }

    public void setElemeOrderItemId(BigInteger elemeOrderItemId) {
        this.elemeOrderItemId = elemeOrderItemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
