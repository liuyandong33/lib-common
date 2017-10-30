package build.dream.common.erp.domains;

import build.dream.common.basic.BasicDomain;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class ElemeActivity extends BasicDomain {
    /**
     * 饿了么订单ID
     */
    private BigInteger elemeOrderId;
    /**
     * 饿了么活动ID
     */
    private BigInteger elemeActivityId;
    /**
     * 活动名称
     */
    private String name;
    /**
     * 活动类别
     */
    private Integer categoryId;
    /**
     * 活动类别含义
     */
    private String meaning;
    /**
     * 金额
     */
    private BigDecimal amount;

    public BigInteger getElemeOrderId() {
        return elemeOrderId;
    }

    public void setElemeOrderId(BigInteger elemeOrderId) {
        this.elemeOrderId = elemeOrderId;
    }

    public BigInteger getElemeActivityId() {
        return elemeActivityId;
    }

    public void setElemeActivityId(BigInteger elemeActivityId) {
        this.elemeActivityId = elemeActivityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
