package build.dream.common.erp.domains;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class DietOrderDetail {
    private BigInteger id;
    private BigInteger dietOrderId;
    private BigInteger goodsId;
    private BigInteger goodsSpecificationId;
    private String goodsFlavorIds;
    private BigDecimal price;
    private BigDecimal discountAmount;
    private BigDecimal payableAmount;
    private Integer amount;
    private Date createTime;
    private BigInteger createUserId;
    private Date lastUpdateTime;
    private BigInteger lastUpdateUserId;
    private String lastUpdateRemark;
    private boolean deleted;
}
