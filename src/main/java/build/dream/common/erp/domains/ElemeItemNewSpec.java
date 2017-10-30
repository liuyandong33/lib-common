package build.dream.common.erp.domains;

import build.dream.common.basic.BasicDomain;

import java.math.BigInteger;
import java.util.Date;

public class ElemeItemNewSpec extends BasicDomain {
    /**
     * eleme item id
     */
    private BigInteger elemeItemId;
    /**
     * 规格名称
     */
    private String name;
    /**
     * 规格值
     */
    private String value;

    public BigInteger getElemeItemId() {
        return elemeItemId;
    }

    public void setElemeItemId(BigInteger elemeItemId) {
        this.elemeItemId = elemeItemId;
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
