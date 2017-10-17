package build.dream.common.erp.domains;

import build.dream.common.basic.BasicDomain;

import java.math.BigDecimal;
import java.math.BigInteger;

public class DietOrderDetail extends BasicDomain {
    /**
     * 商户ID
     */
    private BigInteger tenantId;
    /**
     * 门店ID
     */
    private BigInteger branchId;
    /**
     * 商户编码
     */
    private String tenantCode;
    /**
     * 餐厅订单ID，diet_order.id
     */
    private BigInteger dietOrderId;
    /**
     * 产品ID，goods.id
     */
    private BigInteger goodsId;
    /**
     * 产品名称，goods.name
     */
    private String goodsName;
    /**
     * 菜品规格ID，goodsSpecification.id
     */
    private BigInteger goodsSpecificationId;
    /**
     * 菜品规格名称，goodsSpecification.name
     */
    private String goodsSpecificationName;
    /**
     * 单价
     */
    private BigDecimal price;
    /**
     * 总数量
     */
    private Integer amount;
    /**
     * 总金额
     */
    private BigDecimal totalAmount;
    /**
     * 优惠金额
     */
    private BigDecimal discountAmount;
    /**
     * 应付金额
     */
    private BigDecimal payableAmount;
}
