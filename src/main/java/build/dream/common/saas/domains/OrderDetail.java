package build.dream.common.saas.domains;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class OrderDetail {
    private BigInteger id;
    /**
     * 订单ID
     */
    private BigInteger orderId;
    /**
     * 产品ID
     */
    private BigInteger goodsId;
    /**
     * 产品规格ID
     */
    private BigInteger goodsSpecificationId;
    /**
     * 门店ID
     */
    private BigInteger branchId;
    /**
     * 单价
     */
    private BigDecimal price;
    /**
     * 优惠金额
     */
    private BigDecimal discountAmount;
    /**
     * 应付金额
     */
    private BigDecimal payableAmount;
    /**
     * 数量
     */
    private Integer amount;
    private Date createTime;
    private BigInteger createUserId;
    private Date lastUpdateTime;
    private BigInteger lastUpdateUserId;
    private String lastUpdateRemark;
    private boolean deleted;
}
